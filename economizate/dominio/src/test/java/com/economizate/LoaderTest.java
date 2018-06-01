package com.economizate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.economizate.loader.LoaderClase;
import com.economizate.servicios.INube;
import com.economizate.servicios.impl.Propiedad;

public class LoaderTest {
	
	@Test
	public void cargarClasesDeNubeManagerConExito() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader loaderGenerico = LoaderClase.class.getClassLoader();
		LoaderClase loader = new LoaderClase(loaderGenerico);
		
		Class nube = loader.loadClass("ConnectorDrive");
		loader.loadClass(Propiedad.getInstance().getPropiedad("nubes"));
		loader.loadClass("NubePropiedades");
		
		INube drive = (INube) nube.newInstance();
		System.out.println(drive.getClass().getName());
		
		assertTrue("Clase ConnectorDrive cargada", drive.getClass().getName().equals("com.economizate.nubeManager.ConnectorDrive"));
	}

}
