package com.economizate;

import static org.junit.Assert.*;
import org.junit.Test;
import com.economizate.servicios.impl.Idioma;
import com.economizate.servicios.impl.ManejadorEtiqueta;

public class MultiIdiomaTest {

	ManejadorEtiqueta labels = new ManejadorEtiqueta();
	
	@Test
	public void InglesTest() {
	
		assertTrue(ManejadorEtiqueta.getInstance(Idioma.INGLES).getMensaje("etiquetaBienvenido").equals("Welcome"));
	}
	
	@Test
	public void EspaniolTest() {
		
		assertTrue(ManejadorEtiqueta.getInstance(Idioma.ESPANIOL).getMensaje("etiquetaBienvenido").equals("Bienvenido"));
	}

}
