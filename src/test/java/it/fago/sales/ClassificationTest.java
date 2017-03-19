package it.fago.sales;

import static it.fago.sales.TestUtil.fromClassLoader;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.fago.sales.classification.ItemClassification;
import it.fago.sales.problem.impl.ProblemItemClassificaton;
import it.fago.sales.utils.BasketFileBuilder;

public class ClassificationTest {
	//
	private BasketFileBuilder basketBuilder = null;

	@Before
	public void setUp() throws Exception {
		basketBuilder = BasketFileBuilder.builder();
	}

	@After
	public void tearDown() throws Exception {
		basketBuilder = null;
	}

	@Test
	public void testClassify_IMPORTED_DOMESTIC() {
		File f = new File(fromClassLoader("items3.txt"));
		
		List<BasketItem> items = basketBuilder
				.from(f)
				.with(new ItemClassification() {
					
					@Override
					public ItemType classify(String description) {
						return description.contains("imported")?ItemType.IMPORTED:ItemType.DOMESTIC;
					}
				})
				.build()
			.items();
		
		assertTrue(String.format("%s expected IMPORTED ", items.get(0).type()),items.get(0).type()==ItemType.IMPORTED);
		assertTrue(String.format("%s expected DOMESTIC ", items.get(1).type()),items.get(1).type()==ItemType.DOMESTIC);
		assertTrue(String.format("%s expected IMPORTED ", items.get(2).type()),items.get(2).type()==ItemType.IMPORTED);
		
	}
	
	@Test
	public void testClassify_PROBLEM_TEXT() {
		File f = new File(fromClassLoader("items4.txt"));
		
		List<BasketItem> items = basketBuilder
				.from(f)
				.with(new ProblemItemClassificaton())
				.build()
			.items();
		
		assertTrue(String.format("%s expected IMPORTED ", items.get(0).type()),items.get(0).type()==ItemType.IMPORTED);
		assertTrue(String.format("%s expected DOMESTIC", items.get(1).type()),items.get(1).type()==ItemType.DOMESTIC);
		assertTrue(String.format("%s expected DOMESTIC EXEMPT", items.get(2).type()),items.get(2).type()==ItemType.DOMESTIC_EXEMPT);
		assertTrue(String.format("%s expected IMPORTED EXEMPT", items.get(3).type()),items.get(3).type()==ItemType.IMPORTED_EXEMPT);
		
	}


}//END