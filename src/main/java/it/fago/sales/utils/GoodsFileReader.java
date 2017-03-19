package it.fago.sales.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class GoodsFileReader {
	//
	private LineNumberReader reader;

	public void init(File source) throws FileNotFoundException {
		reader = new LineNumberReader(new InputStreamReader(new FileInputStream(source)));
	}

	public void destroy() {
		reader = null;
	}

	public List<String> readGoodsLines() throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		String tmp = null;
		try {
			while ((tmp = reader.readLine()) != null) {
				lines.add(tmp);
			}
		} finally {
			reader.close();
		}
		return lines;
	}

}// END