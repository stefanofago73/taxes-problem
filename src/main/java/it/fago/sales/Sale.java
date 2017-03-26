package it.fago.sales;

import static it.fago.sales.utils.BasketFileBuilder.builder;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.fago.sales.calculator.TaxesCalculator;
import it.fago.sales.classification.ItemClassification;
import it.fago.sales.problem.impl.ProblemItemClassificaton;
import it.fago.sales.rounding.RoundingPolicy;

public class Sale {
	//
	private Basket basket;
	//
	private TaxesCalculator calculator;
	//
	private RoundingPolicy policy;
	//
	private Logger logger;

	public Sale init(File itemsListFile,ItemClassification classifier) {
		this.logger = LoggerFactory.getLogger(getClass());
		this.basket = builder().from(itemsListFile).with(classifier).build();
		return this;
	}

	public void destroy() {
		basket.destroy();
		basket = null;
		policy = null;
		calculator = null;
		logger = null;
	}

	public Sale computeTaxesWith(TaxesCalculator calculator, RoundingPolicy policy) {
		this.calculator = calculator;
		this.policy = policy;
		return this;
	}

	public Sale executeSaleAndReceipt(Receipt receipt) {
		List<BasketItem> items = showInput(basket.items());
		List<PurchasedItem> purchased = calculator.compute(items, policy);
		logger.info("\nReceipt:\n{}", receipt.print(purchased));
		return this;
	}

	// =========================================================
	//
	//
	//
	// =========================================================

	private final List<BasketItem> showInput(List<BasketItem> items) {
		logger.info("\n---------------------------------------------------");
		logger.info("\t\tBASKET");
		logger.info("---------------------------------------------------");

		for (BasketItem basketItem : items) {
			logger.info("Qty: {}  Desc: {}  Price: {}", basketItem.quantity(), basketItem.description(),
					basketItem.price());
		}
		logger.info("---------------------------------------------------");
		return items;
	}

}// END