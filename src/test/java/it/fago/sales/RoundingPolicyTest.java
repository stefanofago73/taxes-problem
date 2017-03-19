package it.fago.sales;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.fago.sales.rounding.ProblemRoundingPolicy;

public class RoundingPolicyTest {
	//
	private BigDecimal[] data;
	//
	private BigDecimal[] expected;

	@Before
	public void setUp() throws Exception {
		data = new BigDecimal[] { new BigDecimal("0.50"), new BigDecimal("0.5625"), new BigDecimal("7.1250"),
				new BigDecimal("1.499") };
		expected = new BigDecimal[] { new BigDecimal("0.5"), new BigDecimal("0.6"), new BigDecimal("7.15"),
				new BigDecimal("1.5") };
	}

	@After
	public void tearDown() throws Exception {
		Arrays.fill(data, null);
		Arrays.fill(expected, null);
	}

	@Test
	public void test_PROBLEM_TEXT_Rounding() {
		RoundingPolicy policy = new ProblemRoundingPolicy();
		int len = data.length;
		BigDecimal tmp = null;
		for (int i = 0; i < len; i++) {
			tmp = policy.round(data[i]);
			assertTrue(String.format("Found %s expected: %s ", tmp, expected[i]), tmp.equals(expected[i]));
		}

	}

	@Test
	public void test_NO_ROUNDING_POLICY() {
		RoundingPolicy policy = new RoundingPolicy() {
			@Override
			public BigDecimal round(BigDecimal value) {
				return value;
			}
		};
		int len = data.length;
		BigDecimal tmp = null;
		for (int i = 0; i < len; i++) {
			tmp = policy.round(data[i]);
			assertTrue(String.format("Found %s expected: %s ", tmp, data[i]), tmp.equals(data[i]));
		}
	}

}// END