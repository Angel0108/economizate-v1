package com.economizate;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.ValidationException;

import junit.framework.Assert;

import org.junit.Test;

import com.economizate.datos.ListaMovimientos;
import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.BaseWriter;
import com.economizate.servicios.LoaderFromFile;
import com.economizate.servicios.impl.ExcelWriter;
import com.economizate.servicios.impl.LoaderMovimientosFromFile;
import com.economizate.servicios.impl.MovimientosSheet;
import com.economizate.servicios.impl.PdfWriter;
import com.economizate.servicios.impl.Propiedad;
import com.economizate.servicios.impl.TXTWriter;
import com.economizate.servicios.impl.TransformadorMovimientos;

public class GenerarArchivoMovimientosTest {

	private String rutaArchivos = Propiedad.getInstance().getPropiedad("resourcesTesting");
	
	private LoaderFromFile<MovimientoMonetario> importador;
	
	private int cantidadCampos = 3;
	
	private void importarArchivo(String nombreArchivo) throws IOException, ParseException {
		importador = new LoaderMovimientosFromFile(nombreArchivo);
		importador.cargarDatos(cantidadCampos);
	}
	
	private boolean verificacionMovimientosArchivo(String nombreArchivo) throws ValidationException, IOException, ParseException {
		importarArchivo(nombreArchivo);
		if(new ListaMovimientos().getMovimientos().size() != importador.getDatos().size()) 
			return false;
		for (MovimientoMonetario mov : importador.getDatos()) {
			if(!new ListaMovimientos().getMovimientos().contains(mov))
				return false;
		}
		return true;
	}
	
	private boolean escribirArchivo(String nombreArchivo, BaseWriter writer) throws IOException {
		writer.write();
		Path path = Paths.get(nombreArchivo);
		return Files.exists(path);
	}
	
	@Test
	public void generarExcelHistorialMovimientos() throws IOException, ParseException, ValidationException {
		
		String nombreArchivo = rutaArchivos + "movimientos.xlsx";
		assertTrue(escribirArchivo(nombreArchivo, new ExcelWriter(nombreArchivo, new MovimientosSheet(new ListaMovimientos().getMovimientos()))));
		assertTrue(verificacionMovimientosArchivo(nombreArchivo));
	}
	
	@Test
	public void writeTxtHistorialMovimientos() throws IOException, ValidationException, ParseException {
		
		String nombreArchivo = rutaArchivos + "movimientos.xlsx";
		assertTrue(escribirArchivo(nombreArchivo, new ExcelWriter(nombreArchivo, new MovimientosSheet(new ListaMovimientos().getMovimientos()))));
		assertTrue(verificacionMovimientosArchivo(nombreArchivo));
	}
	
	@Test (expected = NullPointerException.class) 
	public void writeTxtMovimientosRutaInvalida() throws IOException{
		
			String nombreArchivo = null;
			BaseWriter writer = new TXTWriter(nombreArchivo);
			writer.write();
			
			Paths.get(nombreArchivo);		
	}
	
	@Test
	public void writePdfMovimientos() throws IOException {
				
		String nombreArchivo = "src/test/resources/prueba_writer.pdf";
		BaseWriter writer = new PdfWriter(nombreArchivo, new TransformadorMovimientos(new ListaMovimientos().getMovimientos()));
		writer.write();
		Path path = Paths.get(nombreArchivo);
		Assert.assertTrue(Files.exists(path));
	}

}
