package com.economizate.servicios.impl;

import java.io.IOException;

import com.economizate.servicios.BaseParser;

public class PipeParser extends BaseParser {

	public PipeParser(String FileName) {
		super(FileName);
	}

	public PipeParser() {
		super();
	}

	@Override
	public String Read() throws IOException {
		Delimiter = "|";
		return super.Read();
	}

	@Override
	public String toString() {
		return ParserType.PIPE.toString();
	}
}
