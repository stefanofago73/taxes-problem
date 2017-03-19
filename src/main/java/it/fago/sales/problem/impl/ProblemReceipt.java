package it.fago.sales.problem.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import it.fago.sales.PurchasedItem;
import it.fago.sales.Receipt;

public class ProblemReceipt implements Receipt{

	@Override
	public String print(List<PurchasedItem> items) {
		String pattern ="#.00";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		BigDecimal taxes = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		
		StringBuilder sb = new StringBuilder();
		
		for (PurchasedItem purchasedItem : items) {
		 sb.append(String.format("%s %s : %s", purchasedItem.quantity(),purchasedItem.description(),purchasedItem.priceWithTaxes())).append('\n');	
		  taxes = taxes.add(purchasedItem.taxes());
		  total = total.add(purchasedItem.priceWithTaxes());
		}
		String _taxes = decimalFormat.format(taxes);
		String _total = decimalFormat.format(total);
		sb.append(String.format("Sales Taxes : %s\nTotal : %s\n",_taxes ,_total));
		String result = sb.toString();
		sb.setLength(0);
		sb = null;
		return result;
	}

}//END
