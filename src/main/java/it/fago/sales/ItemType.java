package it.fago.sales;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ItemType {

	DOMESTIC(new BigDecimal("0.1")),
	DOMESTIC_EXEMPT(new BigDecimal("0.0")),
	IMPORTED(new BigDecimal("0.15")),
	IMPORTED_EXEMPT(new BigDecimal("0.05"));
	
	private BigDecimal taxesPerc;
	
	private ItemType(BigDecimal taxesPerc){
		this.taxesPerc = taxesPerc;
	}
	
	public BigDecimal perc(){
		return taxesPerc;
	}
	
}//END
