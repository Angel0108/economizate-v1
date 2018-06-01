package com.economizate;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.economizate.conector.ConectorCuenta;
import com.economizate.loader.MyClassLoader;
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
		
		ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
	    MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
	    Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	    classLoader.loadClass("NubeEnum");
	    classLoader.loadClass("NubePropiedades");
	    INube drive = (INube) myObjectClass.newInstance();
	      drive.conectar();
	    drive.upload(file.getAbsolutePath());
	}
	
	@Test
	public void encriptadoAESDrive() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		DataSourceDecorator encoded = 
				new EncryptionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoAES.csv"), new AESEncrypt());
		File file = new File(Propiedad.getInstance().getPropiedad("resourcesTesting") + "archivoEncriptadoAES.csv");
		encoded.writeData(ConvertListaMovimientosToString.getRegistros(conector.getMovimientos().getTodos(), new ConversorMovimientoSinCuota(";")));
		
		ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
	    MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
	    Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	    classLoader.loadClass("NubeEnum");
	    classLoader.loadClass("NubePropiedades");
	    INube drive = (INube) myObjectClass.newInstance();
	      drive.conectar();
	    drive.upload(file.getAbsolutePath());
	}
}
