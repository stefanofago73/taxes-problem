package it.fago.sales.calculator;

import java.util.List;

import it.fago.sales.BasketItem;
import it.fago.sales.PurchasedItem;
import it.fago.sales.RoundingPolicy;

public interface TaxesCalculator {

	List<PurchasedItem> compute(List<BasketItem> items, RoundingPolicy policy);

}
