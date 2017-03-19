package it.fago.sales;

import static it.fago.sales.TestUtil.fromClassLoader;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.fago.sales.problem.impl.ProblemItemClassificaton;
import it.fago.sales.problem.impl.ProblemReceipt;
import it.fago.sales.problem.impl.ProblemTaxesCalculator;
import it.fago.sales.rounding.ProblemRoundingPolicy;

public class SaleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void demo_SALE_TEST_INPUT_1() {
		new Sale()
				.init(new File(fromClassLoader("list1.txt")),new ProblemItemClassificaton())
				.computeTaxesWith(
					  new ProblemTaxesCalculator(), 
					  new ProblemRoundingPolicy())
				.executeSaleAndReceipt(new ProblemReceipt())
				.destroy();
	}

	@Test
	public void demo_SALE_TEST_INPUT_2() {
		new Sale()
				.init(new File(fromClassLoader("list2.txt")),new ProblemItemClassificaton())
				.computeTaxesWith(
						  new ProblemTaxesCalculator(), 
						  new ProblemRoundingPolicy())
					.executeSaleAndReceipt(new ProblemReceipt())
					.destroy();
	}
	
	@Test
	public void demo_SALE_TEST_INPUT_3() {
		new Sale()
				.init(new File(fromClassLoader("list3.txt")),new ProblemItemClassificaton())
				.computeTaxesWith(
						  new ProblemTaxesCalculator(), 
						  new ProblemRoundingPolicy())
					.executeSaleAndReceipt(new ProblemReceipt())
					.destroy();
	}


}//END