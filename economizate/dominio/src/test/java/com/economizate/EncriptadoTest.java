package com.economizate;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.economizate.conector.ConectorCuenta;
import com.economizate.loader.LoaderClase;
import com.economizate.servicios.IEncryption;
import com.economizate.servicios.INube;
import com.economizate.servicios.impl.AESEncrypt;
import com.economizate.servicios.impl.CompressionDecorator;
import com.economizate.servicios.impl.ConversorMovimientoSinCuota;
import com.economizate.servicios.impl.ConvertListaMovimientosToString;
import com.economizate.servicios.impl.DataSourceDecorator;
import com.economizate.servicios.impl.EncryptionDecorator;
import com.economizate.servicios.impl.FileDataSource;
import com.economizate.servicios.impl.Propiedad;
import com.economizate.servicios.impl.RSAEncrypt;
import com.economizate.servicios.impl.TXTWriter;

public class EncriptadoTest {

	private ConectorCuenta conector = new ConectorCuenta();
	
	@Test
	public void encriptarTest() throws FileNotFoundException {
		
        IEncryption encriptador = new AESEncrypt();
        String texto = "Hola Mundo";
        byte[] textoEncriptado = encriptador.encrypt(texto);
		String textoDesencriptado = encriptador.decrypt(textoEncriptado);
		assertTrue(texto.equals(textoDesencriptado));
	}
	
	/*@Test
	public void encriptarDESTest() throws FileNotFoundException {
		
		
        IEncryption encriptador = new DESEncrypt();
        String texto = "Hola Mundo";
        byte[] textoEncriptado = encriptador.encrypt(texto);
		String textoDesencriptado = encriptador.decrypt(textoEncriptado);
		assertTrue(texto.equals(textoDesencriptado));
	}*/
	
	@Test
	public void encriptarRSATest() throws FileNotFoundException {
		
        IEncryption encriptador = new RSAEncrypt();
        String texto = "Hola Mundo";
        byte[] textoEncriptado = encriptador.encrypt(texto);
		String textoDesencriptado = encriptador.decrypt(textoEncriptado);
		assertTrue(texto.equals(textoDesencriptado));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void encriptadoRSATextoVacio() {
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoVacio.csv"), new RSAEncrypt());
		encoded.writeData("");			
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void encriptadoAESTextoVacio() {
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoVacio.csv"), new AESEncrypt());
		encoded.writeData("");			
	}
	
	@Test
	public void encriptadoRSADrive() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoRSA.csv"), new RSAEncrypt());
		File file = new File(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoRSA.csv");
		encoded.writeData(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
		
		ClassLoader parentClassLoader = LoaderClase.class.getClassLoader();
	    LoaderClase classLoader = new LoaderClase(parentClassLoader);
	    Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	    classLoader.loadClass("NubeEnum");
	    classLoader.loadClass("NubePropiedades");
	    INube drive = (INube) myObjectClass.newInstance();
	      drive.conectar();
	      String id = drive.uploadId(file.getAbsolutePath());
  	    
		    com.google.api.services.drive.model.File nuevo = buscarFilePorId(drive.leerArchivos(), id);
		    assertTrue(encoded.readData().equals(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";"))));
			assertTrue("Busco el archivo subido al Drive: ", nuevo.getId().equals(id));
	}
	
	@Test
	public void encriptadoAESDrive() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoAES.csv"), new AESEncrypt());
		File file = new File(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoAES.csv");
		encoded.writeData(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
		
		//encoded.readData().equals(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
		
		ClassLoader parentClassLoader = LoaderClase.class.getClassLoader();
	    LoaderClase classLoader = new LoaderClase(parentClassLoader);
	    Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	    classLoader.loadClass("NubeEnum");
	    classLoader.loadClass("NubePropiedades");
	    
	    INube drive = (INube) myObjectClass.newInstance();
	      drive.conectar();
	    String id = drive.uploadId(file.getAbsolutePath());
	    	    
	    com.google.api.services.drive.model.File nuevo = buscarFilePorId(drive.leerArchivos(), id);
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
}
