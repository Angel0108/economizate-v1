package com.economizate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.economizate.batch.BackupArchivo;
import com.economizate.batch.BackupTimer;
import com.economizate.batch.EjecutorBackup;
import com.economizate.batch.IBackup;

public class BackupTest {
	
	IBackup backupArchivo;
	List<IBackup> listaBackups;
	EjecutorBackup ejecutor;
	
	@Before
	public void inicializar() {
		backupArchivo = new BackupArchivo("./src/test/resources/backup/");
		listaBackups = Arrays.asList(backupArchivo);
		borrarArchivosBackup();
	}
	
	@After
	public void restaturar() {
		borrarArchivosBackup();
	}
	
	@Test
	public void generarDescargaDeArchivoTxtConFrecuencia3Segundos() throws IOException {
		borrarArchivosBackup();
		
		ejecutor = new EjecutorBackup(BackupTimer.TRESSEGUNDOS, listaBackups);
		long contador = 0;
		
		try {
			ejecutor.ejecutar();
			Thread.sleep(5000);
		
			try (Stream<Path> files = Files.list(Paths.get("./src/test/resources/backup/"))) {
				contador = files.count();
			}
			
			assertTrue("Descarga de archivo .txt en forma perdiódica", contador == 2);
			borrarArchivosBackup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void generarDescargaDeArchivoTxtConFrecuencia5Minutos() throws IOException {
		borrarArchivosBackup();
		
		ejecutor = new EjecutorBackup(BackupTimer.CINCOMINUTOS, listaBackups);
		long contador = 0;
		
		try {
			ejecutor.ejecutar();
			Thread.sleep(305000);
		
			try (Stream<Path> files = Files.list(Paths.get("./src/test/resources/backup/"))) {
				contador = files.count();
			}

			assertTrue("Descarga de archivo .txt en forma perdiódica", contador == 2);
			borrarArchivosBackup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void generarDescargaDeArchivoTxtYBuscar2ArchivoAntesDe5Minutos() throws IOException {
		borrarArchivosBackup();
		
		ejecutor = new EjecutorBackup(BackupTimer.CINCOMINUTOS, listaBackups);
		long contador = 0;
		
		try {
			ejecutor.ejecutar();
			Thread.sleep(4000);
		
			try (Stream<Path> files = Files.list(Paths.get("./src/test/resources/backup/"))) {
				contador = files.count();
			}
			
			assertTrue("Descarga de archivo .txt en forma perdiódica", contador == 1);
			borrarArchivosBackup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void generarDescargaDeArchivoTxtConFrecuencia3SegundosSinEsperar() throws IOException {
		borrarArchivosBackup();
		
		ejecutor = new EjecutorBackup(BackupTimer.TRESSEGUNDOS, listaBackups);
		long contador = 0;
		
		try {
			ejecutor.ejecutar();
			Thread.sleep(2000);
		
			try (Stream<Path> files = Files.list(Paths.get("./src/test/resources/backup/"))) {
				contador = files.count();
			}

			assertTrue("Descarga de archivo .txt en forma perdiódica sin espera", contador == 1);
			borrarArchivosBackup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void borrarArchivosBackup() {
		for(File file: new java.io.File("./src/test/resources/backup/").listFiles()) 
		    if (!file.isDirectory()) 
		        file.delete();
	}

}
