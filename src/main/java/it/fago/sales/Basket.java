package it.fago.sales;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	//
	private ArrayList<BasketItem> items = new ArrayList<BasketItem>();

	public void addItem(BasketItem item) {
		if (item != null) {
			items.add(item);
		}
	}

	public List<BasketItem> items() {
		return new ArrayList<BasketItem>(items);
	}

	public void destroy() {
		items.clear();
		items = null;
	}

}// END
