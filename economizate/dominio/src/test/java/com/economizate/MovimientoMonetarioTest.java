package com.economizate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.economizate.entidades.MovimientoMonetario;


public class MovimientoMonetarioTest {

	@Test
	public void MovimientoMonetarioEqualsMismoObjetoTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		assertTrue(mov.equals(mov));
	}
	
	@Test
	public void MovimientoMonetarioEqualsNullTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		assertFalse(mov.equals(null));
	}
	
	@Test
	public void MovimientoMonetarioEqualsOtraClase() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		assertFalse(mov.equals(new String()));
	}
	
	@Test
	public void MovimientoMonetarioEqualsDistintaDescripcionTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		MovimientoMonetario mov2 = new MovimientoMonetario("Luz", "Sueldo", 12000.0);
		assertFalse(mov.equals(mov2));
	}
	
	@Test
	public void MovimientoMonetarioEqualsDistintaObservacionTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		MovimientoMonetario mov2 = new MovimientoMonetario("Sueldo", "Servicio", 12000.0);
		assertFalse(mov.equals(mov2));
	}
	
	@Test
	public void MovimientoMonetarioEqualsDistintoImporteTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", 12000.0);
		MovimientoMonetario mov2 = new MovimientoMonetario("Sueldo", "Sueldo", 22000.0);
		assertFalse(mov.equals(mov2));
	}

	@Test
	public void MovimientoMonetarioEqualsDescripcionNullTest() {
		MovimientoMonetario mov = new MovimientoMonetario(null, "Sueldo", 12000.0);
		MovimientoMonetario mov2 = new MovimientoMonetario("Sueldo", "Sueldo", 22000.0);
		assertFalse(mov.equals(mov2));
	}
	
	@Test
	public void MovimientoMonetarioEqualsObservacionNullTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", null, 12000.0);
		MovimientoMonetario mov2 = new MovimientoMonetario("Sueldo", "Sueldo", 22000.0);
		assertFalse(mov.equals(mov2));
	}
	
	@Test
	public void MovimientoMonetarioEqualsImporteNullTest() {
		MovimientoMonetario mov = new MovimientoMonetario("Sueldo", "Sueldo", null);
		MovimientoMonetario mov2 = new MovimientoMonetario("Sueldo", "Sueldo", 22000.0);
		assertFalse(mov.equals(mov2));
	}
}
