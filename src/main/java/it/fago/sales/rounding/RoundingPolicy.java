package it.fago.sales.rounding;

import java.math.BigDecimal;

/**
 * 
 * @author Stefano
 *
 */
public interface RoundingPolicy {
    
	public BigDecimal round(BigDecimal value);
	
}
