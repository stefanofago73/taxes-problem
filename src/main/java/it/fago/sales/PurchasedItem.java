package it.fago.sales;

import java.math.BigDecimal;

public class PurchasedItem {
	//
	private final int quantity;

	private final BigDecimal taxes;

	private final BigDecimal addedWithTaxes;

	private final String description;

	private final String toStringDesc;

	public PurchasedItem(int quantity, BigDecimal addedWithTaxes, BigDecimal taxes, String description) {
		this.quantity = quantity;
		this.taxes = taxes;
		this.addedWithTaxes = addedWithTaxes;
		this.description = description;
		this.toStringDesc = String.format("%s[%s](%s,%s,%s,\"%s\")", getClass().getName(), hashCode(), quantity,
				addedWithTaxes, taxes, description);
	}

	public int quantity() {
		return quantity;
	}

	public String description() {
		return description;
	}

	public BigDecimal taxes() {
		return taxes;
	}

	public BigDecimal priceWithTaxes() {
		return addedWithTaxes;
	}

	@Override
	public String toString() {
		return toStringDesc;
	}
	
}// END