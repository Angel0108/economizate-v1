package com.economizate;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import com.economizate.conector.ConectorCuenta;
import com.economizate.loader.LoaderClase;
import com.economizate.servicios.DataSource;
import com.economizate.servicios.IEncryption;
import com.economizate.servicios.INube;
import com.economizate.servicios.impl.AESEncrypt;
import com.economizate.servicios.impl.ConversorMovimientoSinCuota;
import com.economizate.servicios.impl.ConvertListaMovimientosToString;
import com.economizate.servicios.impl.DataSourceDecorator;
import com.economizate.servicios.impl.EncryptionDecorator;
import com.economizate.servicios.impl.FileDataSource;
import com.economizate.servicios.impl.Propiedad;
import com.economizate.servicios.impl.RSAEncrypt;

public class EncriptadoTest {

	private ConectorCuenta conector = new ConectorCuenta();
	
	// Criterio de Aceptación 1
	@Test (expected=IllegalArgumentException.class)
	public void encriptadoRSATextoVacio() {
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoVacio.csv"), new RSAEncrypt());
		encoded.writeData("");			
	}
	
	// Criterio de Aceptación 2
	@Test (expected=IllegalArgumentException.class)
	public void encriptadoAESTextoVacio() {
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoVacio.csv"), new AESEncrypt());
		encoded.writeData("");			
	}
	
	// Criterio de Aceptación 3
	@Test
	public void encriptadoRSADrive() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		String nombreArchivo = Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoRSA.csv";
		DataSourceDecorator encoded = encriptar(nombreArchivo, new RSAEncrypt());
		File file = new File(nombreArchivo);
		Class myObjectClass = cargarClaseConnectorDrive();
		INube drive = (INube) myObjectClass.newInstance();
		drive.conectar();
		String id = drive.uploadId(file.getAbsolutePath());		
		com.google.api.services.drive.model.File nuevo = buscarFilePorId(drive.leerArchivos(), id);
		assertTrue(estaEncriptado(nombreArchivo));
		assertTrue(encoded.readData().equals(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";"))));
		assertTrue("Busco el archivo subido al Drive: ", nuevo.getId().equals(id));
	}
	
	// Criterio de Aceptación 4
	@Test
	public void encriptadoAESDrive() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		String nombreArchivo = Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoAES.csv";
		DataSourceDecorator encoded = encriptar(nombreArchivo, new AESEncrypt());		
		File file = new File(nombreArchivo);		
		Class myObjectClass = cargarClaseConnectorDrive();	    
	    INube drive = (INube) myObjectClass.newInstance();
	    drive.conectar();
	    String id = drive.uploadId(file.getAbsolutePath());
	    	    
	    com.google.api.services.drive.model.File nuevo = buscarFilePorId(drive.leerArchivos(), id);
	    assertTrue(estaEncriptado(nombreArchivo));
	    assertTrue(encoded.readData().equals(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";"))));
		assertTrue("Busco el archivo subido al Drive: ", nuevo.getId().equals(id));
	    
	}
	
	private com.google.api.services.drive.model.File buscarFilePorId(
			List<com.google.api.services.drive.model.File> archivos, String id) {
		com.google.api.services.drive.model.File nuevo = null;
		for(com.google.api.services.drive.model.File f : archivos) {
			if (f.getId().equals(id))
				nuevo = f;
		}
		return nuevo;
	}
	
	private boolean estaEncriptado(String nombreArchivo) {
		DataSource plain = new FileDataSource(nombreArchivo);
		return !plain.readData().equals(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
	}
	
	private DataSourceDecorator encriptar(String nombreArchivo, IEncryption encriptador) {
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(nombreArchivo), encriptador );		
		encoded.writeData(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
		return encoded;
	}

	private Class cargarClaseConnectorDrive() throws ClassNotFoundException {
		ClassLoader parentClassLoader = LoaderClase.class.getClassLoader();
	    LoaderClase classLoader = new LoaderClase(parentClassLoader);
	    Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	    classLoader.loadClass("NubeEnum");
	    classLoader.loadClass("NubePropiedades");
		return myObjectClass;
	}
}
