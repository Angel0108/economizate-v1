package com.economizate;


import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.LoaderFromFile;
import com.economizate.servicios.impl.LoaderMovimientosFromFile;

public class ImportadorArchivoTest {

	@Test
	public void cargarArchivoTxtMovimientos() throws IOException, ParseException {
		LoaderFromFile<MovimientoMonetario> importadorTxt = new LoaderMovimientosFromFile("src/test/resources/prueba.txt");
		importadorTxt.cargarDatos();
		
	}

}
