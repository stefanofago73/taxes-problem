## Sales Tax Problem ##
 
This is a sample project related to the "Sales Taxes Problem".

It was developed with limited dependencies but it try, in the 
same time, introducing some checks and to be a complete program.

The project structure is done using  some model interfaces on the root package,
needed to demostrate the eventual ability to evolve; on the same time
things are made really easy to understand and a short DSL to guide developer.

```java
new Sale()
  .init(new File("list1.txt"),
        new ProblemItemClassificaton())
     .computeTaxesWith(
		  new ProblemTaxesCalculator(), 
		  new ProblemRoundingPolicy())
     .executeSaleAndReceipt(new ProblemReceipt())
   .destroy();
```

##  Item Format ##

The input come from file and it's supposed the following format:

<pre>[qty] [word for description]* at [price]</pre>

There is a simple check about this format
(at least 4 elements and the presence of "at" term).


##  Compile & Build ##

The project was coded with Java 1.7 and automated with Maven 3.3.9


##  Other Details ##

The program is not thread-safe, also if main abstractions are quite immutable.

I've used BigDecimal but more interesting is to use Joda-Money  or Java-Money 
Specification (it's also a matter of performances)


##  Reasoning about FP ##

If you consider the task as a trasformation of a stream of items starting from
a list of String, passing to list of BasketItem and then arriving to a list of
PurchasedItem, it's possible to adopt a fully functional style where, at the end,
the Receipt is a consumer of PurchasedItem. This way of thinking also had impact 
on code done in more classical OOP.


```java

  String[] data = { 
  		 "1 imported bottle of perfume at 27.99", 
		 "1 bottle of perfume at 18.99",
		 "1 packet of headache pills at 9.75", 
		 "1 box of imported chocolates at 11.25"
		};

  Receipt receipt = new Receipt();
		
	Arrays
	  .stream(data)
	    .map(fromStringToItem)
	    .map(fromItemToPurchased)
        .forEach(receipt);
		    
	System.out.println(receipt.print());
	
```


Also if elegant, the real code can be really different since you need to consider
error management and special cases: so the functional model can change