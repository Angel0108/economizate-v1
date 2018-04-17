package com.economizate.servicios.impl;

import java.io.IOException;

import com.economizate.servicios.BaseReader;

public class PipeReader extends BaseReader {

	public PipeReader(String FileName) {
		super(FileName);
	}

	public PipeReader() {
		super();
	}

	@Override
	public String Read() throws IOException {
		Delimiter = "|";
		return super.Read();
	}

	@Override
	public String toString() {
		return ParserType.TXT.toString();
	}
}
