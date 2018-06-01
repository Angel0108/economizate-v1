package com.economizate.nubeManager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.drive.model.File;

public class NubeCoberturaTest {

	private ListaNubes nubes = new ListaNubes();
	
	private NubeManagerFactory factory = new NubeManagerFactory();
	
	@Test
	public void conectarDropBox() {
		ConnectorDropBox drive = new ConnectorDropBox();

		boolean resultado = drive.conectar();
		assertFalse("No Hay conexión: ", resultado);
	}
	
	@Test
	public void conectarOneDrive() {
		ConnectorOneDrive drive = new ConnectorOneDrive();
		boolean resultado = drive.conectar();
		assertFalse("No Hay conexión: ", resultado);
	}
	
	@Test
	public void uploadDropBox() {
		ConnectorOneDrive drive = new ConnectorOneDrive();
		assertFalse(drive.upload("archivoInexistente.csv"));
	}
	
	@Test
	public void uploadOneDrive() {
		ConnectorDropBox drive = new ConnectorDropBox();
		assertFalse(drive.upload("archivoInexistente.csv"));
	}
	
	@Test
	public void uploadIdDropBox() throws IOException {
		ConnectorOneDrive drive = new ConnectorOneDrive();
		assertTrue(drive.uploadId("archivoInexistente.csv") == null);
	}
	
	@Test
	public void uploadIdOneDrive() throws IOException {
		ConnectorDropBox drive = new ConnectorDropBox();
		assertTrue(drive.uploadId("archivoInexistente.csv") == null);
	}
	
	@Test
	public void leerArchivosDropBox() throws IOException {
		ConnectorOneDrive drive = new ConnectorOneDrive();
		assertTrue(drive.leerArchivos() == null);
	}
	
	@Test
	public void leerArchivosOneDrive() throws IOException {
		ConnectorDropBox drive = new ConnectorDropBox();
		assertTrue(drive.leerArchivos() == null);
	}
	
	@Test
	public void buscarYEncontrarConectorDropBox() {
		assertTrue(ListaNubes.loadNubes().get("DROPBOX").getTipo().equals(NubeEnum.DROPBOX));
	}
	
	@Test
	public void buscarYEncontrarConectorOneDrive() {
		assertTrue(ListaNubes.loadNubes().get("ONEDRIVE").getTipo().equals(NubeEnum.ONEDRIVE));
	}


}
