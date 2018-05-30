package com.economizate;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.economizate.servicios.IEncryption;
import com.economizate.servicios.impl.AESEncrypt;
import com.economizate.servicios.impl.CompressionDecorator;
import com.economizate.servicios.impl.DataSourceDecorator;
import com.economizate.servicios.impl.FileDataSource;
import com.economizate.servicios.impl.Propiedad;

public class ComprimirTest {

	@Test
	public void comprimirTest() {
		
		DataSourceDecorator encoded = new CompressionDecorator(
                    new FileDataSource(Propiedad.getInstance().getPropiedad("resourcesTesting") + "OutputDemo.txt"));
		encoded.writeData("pepe pompin");
	}

}
