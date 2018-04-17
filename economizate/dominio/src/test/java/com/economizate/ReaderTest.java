package com.economizate;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.Assert;

import org.junit.Test;

import com.economizate.datos.ListaMovimientos;
import com.economizate.servicios.BaseReader;
import com.economizate.servicios.BaseWriter;
import com.economizate.servicios.FactoryReader;
import com.economizate.servicios.impl.ExcelWriter;
import com.economizate.servicios.impl.MovimientosSheet;

public class ReaderTest {

	BaseReader importador;
	
	@Test (expected = IOException.class)
	public void readArchivoInvalidoConExtension() throws IOException {
		
		importador = FactoryReader.getParseador("C:\\Users\\Desktop\\prueba.doc");
	}
	
	@Test (expected = IOException.class)
	public void readArchivoInvalidoSinExtension() throws IOException {
		
		importador = FactoryReader.getParseador("C:\\Users\\Desktop\\prueba");
	}
	
	@Test
	public void readArchivoCSV() throws IOException {
		
		importador = FactoryReader.getParseador("C:\\Users\\nidibiase\\Desktop\\prueba.csv");
		assertFalse(importador.Read().isEmpty());
	}
	
	@Test
	public void readArchivoCSV() throws IOException {
		
		importador = FactoryReader.getParseador("C:\\Users\\nidibiase\\Desktop\\prueba.csv");
		assertFalse(importador.Read().isEmpty());
	}
}
