package com.economizate.servicios.impl;

import java.io.IOException;

import com.economizate.servicios.BaseParser;

public class CSVParser extends BaseParser {

	public CSVParser(String FileName) {
		super(FileName);
	}

	public CSVParser() {
		super();
	}

	@Override
	public String Read() throws IOException {
		Delimiter = ",";
		return super.Read();
	}

	@Override
	public String toString() {
		return ParserType.CSV.toString();
	}

}
