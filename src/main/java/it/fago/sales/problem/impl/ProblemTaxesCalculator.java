package it.fago.sales.problem.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.fago.sales.BasketItem;
import it.fago.sales.PurchasedItem;
import it.fago.sales.RoundingPolicy;
import it.fago.sales.calculator.TaxesCalculator;

public class ProblemTaxesCalculator implements TaxesCalculator {

	@Override
	public List<PurchasedItem> compute(List<BasketItem> items, RoundingPolicy policy) {

		ArrayList<PurchasedItem> result = new ArrayList<PurchasedItem>();

		BasketItem item = null;
		BigDecimal price = null;
		BigDecimal taxes = null;
		BigDecimal addedWithTaxes = null;

		for (Iterator<BasketItem> iterator = items.iterator(); iterator.hasNext();) {
			item = iterator.next();
			price = new BigDecimal(item.price());
			price = price.multiply(BigDecimal.valueOf((long) item.quantity()));
			taxes = price.multiply(item.type().perc());
			taxes = policy.round(taxes);
			addedWithTaxes = price.add(taxes);
			result.add(new PurchasedItem(item.quantity(), addedWithTaxes, taxes, item.description()));
		}
		return result;
	}

}// END