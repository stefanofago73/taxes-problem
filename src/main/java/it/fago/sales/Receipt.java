package it.fago.sales;

import java.util.List;

public interface Receipt {

	String print(List<PurchasedItem> items);

}
