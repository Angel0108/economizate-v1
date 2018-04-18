package com.economizate;

import static org.junit.Assert.*;


import java.io.IOException;
import org.junit.Test;
import com.economizate.servicios.BaseReader;
import com.economizate.servicios.FactoryReader;


public class ReaderTest {

	BaseReader importador;
	
	@Test (expected = IOException.class)
	public void readArchivoInvalidoConExtension() throws IOException {
		
		importador = FactoryReader.getParseador("src/test/resources/prueba.doc");
	}
	
	@Test (expected = IOException.class)
	public void readArchivoInvalidoSinExtension() throws IOException {
		
		importador = FactoryReader.getParseador("src/test/resources/prueba");
	}
	
	@Test
	public void readArchivoCSV() throws IOException {
		
		importador = FactoryReader.getParseador("src/test/resources/prueba.csv");
		assertFalse(importador.read().isEmpty());
	}
	
	@Test
	public void readArchivoTXT() throws IOException {
		
		importador = FactoryReader.getParseador("src/test/resources/prueba.txt");
		assertFalse(importador.read().isEmpty());
	}
	
	@Test
	public void readArchivoExcel() throws IOException {
		
		importador = FactoryReader.getParseador("src/test/resources/prueba.xlsx");
		assertFalse(importador.read().isEmpty());
	}
	
}
