package it.fago.sales.utils;

import static it.fago.sales.utils.Utils.assembleDescription;
import static it.fago.sales.utils.Utils.isCorruptedFormat;
import static it.fago.sales.utils.Utils.readLineFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import it.fago.sales.Basket;
import it.fago.sales.BasketItem;
import it.fago.sales.classification.ItemClassification;

public class BasketFileBuilder {
	//
	private GoodsFileReader reader;
	//
	private ItemClassification classifier;

	private BasketFileBuilder() {
	}

	public static BasketFileBuilder builder() {
		return new BasketFileBuilder();
	}

	public BasketFileBuilder from(File source) {
		try {
			reader = new GoodsFileReader();
			reader.init(source);
		} catch (FileNotFoundException e) {
			throw new BuildBasketException(e);
		}
		return this;
	}

	public BasketFileBuilder with(ItemClassification classifier) {
		this.classifier = classifier;
		return this;
	}

	public Basket build() {
		List<String> lines = readLineFromFile(reader);
		Basket basket = new Basket();
		forEachLineDefineItem(lines, basket, classifier);
		reader = null;
		classifier = null;
		return basket;
	}

	// =========================================================
	//
	//
	//
	// =========================================================

	private void forEachLineDefineItem(List<String> lines, Basket basket, ItemClassification classifier) {
		String line = null;
		for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
			line = iterator.next();
			basket.addItem(fromLine(line, classifier));
		}
	}

	private BasketItem fromLine(String line, ItemClassification classifier) {
		String[] data = line.split("\\s");
		if (isCorruptedFormat(data)) {
			throw new BuildBasketException("No parsable line: " + line);
		}
		int quantity = Integer.parseInt(data[0]);
		String price = data[data.length - 1];
		String description = assembleDescription(data);
		return new BasketItem(quantity, price, description, classifier.classify(description));
	}

	// ===============================================================
	//
	//
	//
	// ===============================================================

}// END