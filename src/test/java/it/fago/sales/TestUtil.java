package it.fago.sales;

public class TestUtil {

	private TestUtil(){
		throw new IllegalStateException("Ctor can't be invoked!");
	}
	
	public static final String fromClassLoader(String name) {
		return BasketBuilderTest.class.getClassLoader().getResource(name).getFile();
		//return name;
	}

}
