package it.fago.sales.utils;

import java.io.IOException;
import java.util.List;

public final class Utils {

	private Utils() {
		throw new IllegalStateException("Ctor must never invoked!");
	}

	public static final String assembleDescription(String[] elements) {
		int len = elements.length - 3;
		StringBuilder sbuilder = new StringBuilder();
		for (int i = 1; i < len; i++) {
			sbuilder.append(elements[i].toLowerCase()).append(" ");
		}
		sbuilder.append(elements[len]);
		String description = sbuilder.toString();
		sbuilder.setLength(0);
		sbuilder = null;
		return description;
	}

	public static final List<String> readLineFromFile(GoodsFileReader reader) {
		try {
			return reader.readGoodsLines();
		} catch (IOException e) {
			throw new BuildBasketException("Problem reading goods file!", e);
		} finally {
			reader.destroy();
		}
	}

	public static final boolean isCorruptedFormat(String[] data) {
		int len = data.length;
		if (len < 4)
			return true;
		for (int i = 0; i < len; i++) {
			if (data[i].equalsIgnoreCase("at")) {
				return false;
			}
		}
		return true;
	}

}// END