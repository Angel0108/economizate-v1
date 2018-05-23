package com.economizate.nubeManager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.api.services.drive.model.File;

public class DriveTest {
	
	//@Test
	public void conectaConGoogleDriveYSubirArchivo() {
		ConnectorDrive drive = new ConnectorDrive("src/main/java/com/economizate/nubeManager/reporte/reporte-test.csv");
		
		//subo archivo
		boolean resultado = drive.upload();
		
		assertTrue("el archivo fue subido: ", resultado);
	}
	
	//@Test
	public void conectarConDriveYSubirArchivoOkConChequeoDeIdArchivo() throws IOException {
		ConnectorDrive drive = new ConnectorDrive("src/main/java/com/economizate/nubeManager/reporte/reporte-test.csv");
		
		//Subo archivo
		String id = drive.uploadId();
		
		//Lo busco en el Drive
		File nuevo = null;
		List<File> archivos = drive.authorize().files().list().execute().getFiles();
		for(File f : archivos) {
			if (f.getId().equals(id))
				nuevo = f;
		}
		
		assertTrue("Busco el archivo subido al Drive: ", nuevo.getName().equals("historial-movimientos"));
		
	}

}
