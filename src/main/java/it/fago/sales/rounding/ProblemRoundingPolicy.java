package it.fago.sales.rounding;

import java.math.BigDecimal;

import it.fago.sales.RoundingPolicy;

public class ProblemRoundingPolicy implements RoundingPolicy {

	private static final BigDecimal ROUND_FACTOR = BigDecimal.ONE.divide(new BigDecimal("0.05"));

	@Override
	public BigDecimal round(final BigDecimal value) {
		return BigDecimal
				.valueOf((Math.ceil(value.doubleValue() * ROUND_FACTOR.doubleValue()) / ROUND_FACTOR.doubleValue()));
	}

}// END
