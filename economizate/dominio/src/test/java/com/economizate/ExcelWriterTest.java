package com.economizate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.Assert;

import org.junit.Test;

import com.economizate.datos.ListaMovimientos;
import com.economizate.servicios.BaseWriter;
import com.economizate.servicios.impl.ExcelWriter;
import com.economizate.servicios.impl.MovimientosSheet;

public class ExcelWriterTest {

	@Test
	public void writeExcelMovimientos() throws IOException {
		
		String nombreArchivo = "C:\\Users\\nidibiase\\Desktop\\prueba.xlsx";
		BaseWriter writer = new ExcelWriter(nombreArchivo, new MovimientosSheet(new ListaMovimientos().getMovimientos()));
		writer.write();
		Path path = Paths.get(nombreArchivo);


		Assert.assertTrue(Files.exists(path));
	}
}
