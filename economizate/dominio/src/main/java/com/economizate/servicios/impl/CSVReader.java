package com.economizate.servicios.impl;

import java.io.IOException;

import com.economizate.servicios.BaseReader;

public class CSVReader extends BaseReader {

	public CSVReader(String FileName) {
		super(FileName);
	}

	public CSVReader() {
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
