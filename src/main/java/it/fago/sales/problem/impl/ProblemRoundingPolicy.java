package it.fago.sales.problem.impl;

import it.fago.sales.rounding.RoundingPolicy;

import java.math.BigDecimal;


public class ProblemRoundingPolicy implements RoundingPolicy {

	private static final BigDecimal ROUND_FACTOR = BigDecimal.ONE.divide(new BigDecimal("0.05"));

	@Override
	public BigDecimal round(final BigDecimal value) {
		return BigDecimal
				.valueOf((Math.ceil(value.doubleValue() * ROUND_FACTOR.doubleValue()) / ROUND_FACTOR.doubleValue()));
	}

}// END
