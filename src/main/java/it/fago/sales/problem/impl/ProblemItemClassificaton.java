package it.fago.sales.problem.impl;

import it.fago.sales.ItemType;
import it.fago.sales.classification.ItemClassification;

public class ProblemItemClassificaton implements ItemClassification {

	@Override
	public ItemType classify(String description) {
		
		boolean isImported = description.contains("imported");
		boolean isExempt = description.contains("pill") || description.contains("chocolate")
				|| description.contains("book");

		if (isImported && isExempt) {
			return ItemType.IMPORTED_EXEMPT;
		}

		if (!isImported && isExempt) {
			return ItemType.DOMESTIC_EXEMPT;
		}

		if (isImported && !isExempt) {
			return ItemType.IMPORTED;
		}

		return ItemType.DOMESTIC;
	}

}// END
