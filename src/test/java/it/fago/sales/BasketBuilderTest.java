package it.fago.sales;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.fago.sales.problem.impl.ProblemItemClassificaton;
import it.fago.sales.utils.BasketFileBuilder;
import it.fago.sales.utils.BuildBasketException;

public class BasketBuilderTest {
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
	public void testBasketWithSingleItem() {

		File f = new File(fromClassLoader("items1.txt"));

		List<BasketItem> items = basketBuilder.from(f).with(new ProblemItemClassificaton()).build().items();

		assertTrue(String.format("Found %s Expected 1", items.size()), items.size() == 1);
	}

	@Test
	public void testBasketWithItems() {

		File f = new File(fromClassLoader("items2.txt"));

		List<BasketItem> items = basketBuilder.from(f).with(new ProblemItemClassificaton()).build().items();

		assertTrue(String.format("Found %s Expected 4", items.size()), items.size() == 4);
	}

	@Test(expected = BuildBasketException.class)
	public void testBasketBuildingError() {

		File f = new File(fromClassLoader("corruptedFormat.txt"));

		try {
			List<BasketItem> items = basketBuilder.from(f).with(new ProblemItemClassificaton()).build().items();
		} catch (RuntimeException e) {
			System.out.println("FOUND: "+e);
			throw e;
		}
	}

	// ===========================================================
	//
	//
	//
	// ===========================================================

	private static String fromClassLoader(String name) {
		return BasketBuilderTest.class.getClassLoader().getResource(name).getFile();
		//return name;
	}

}// END