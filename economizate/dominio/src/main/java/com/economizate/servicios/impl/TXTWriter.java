package com.economizate.servicios.impl;

import java.io.IOException;
import com.economizate.servicios.BaseWriter;

public class TXTWriter extends BaseWriter {

	public TXTWriter(String nombreArchivo) {
		super(nombreArchivo);
	}

	@Override
	public void write(String contenidoArchivo) throws IOException { 
    	super.write(contenidoArchivo);
    } 
	
}
