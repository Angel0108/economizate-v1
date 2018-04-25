package com.economizate.servicios;

import java.io.IOException;

import com.lowagie.text.DocumentException;

public interface BaseTransformador {

	public void procesar() throws IOException, DocumentException;
}
