package it.fago.sales;

public class BasketItem {
	//
	private final int quantity;
	//
	private final String price;
	//
	private final String description;
	//
	private final String toStringDesc;
	//
	private final ItemType type;

	public BasketItem(int quantity, String price, String description, ItemType type) {
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.type = type;
		this.toStringDesc = String.format("%s[%s](%s,%s,\"%s\",%s)", getClass().getName(), hashCode(), quantity, price,
				description, type);
	}

	public String price() {
		return price;
	}

	public int quantity() {
		return quantity;
	}

	public String description() {
		return description;
	}

	public ItemType type() {
		return type;
	}

	@Override
	public String toString() {
		return toStringDesc;
	}

}// END