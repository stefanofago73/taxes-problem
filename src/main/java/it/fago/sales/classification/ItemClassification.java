package it.fago.sales.classification;

import it.fago.sales.ItemType;

public interface ItemClassification {

	ItemType classify(String description);
	
}
