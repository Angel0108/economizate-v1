package com.economizate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.stream.DoubleStream;

import org.junit.Before;
import org.junit.Test;

import com.economizate.datos.ListaMovimientos;
import com.economizate.entidades.MovimientoMonetario;

public class IngresosEgresosTest {
	
	ListaMovimientos listaMovimientos;
	
	@Before
	public void crearListaConMovimientos() {
		this.listaMovimientos = new ListaMovimientos();
	}
	
	@Test
	public void agregarIngresosYObtenerSaldoTotalOK() {
		double saldoAnterior = listaMovimientos
								.getMovimientos()
								.stream()
								.mapToDouble(m -> m.getImporte()).sum();
		listaMovimientos.agregarMovimiento("test", "agrego ingreso venta", 500);
		double saldoActual = listaMovimientos
				.getMovimientos()
				.stream()
				.mapToDouble(m -> m.getImporte()).sum();
		assertTrue("Antes y después de ingreso: ", saldoActual - saldoAnterior == (double) 500 );
		
	}
	
	@Test
	public void agregarEgresoYObtenerSaldoTotalOK() {
		double saldoAnterior = listaMovimientos
								.getMovimientos()
								.stream()
								.mapToDouble(m -> m.getImporte()).sum();
		MovimientoMonetario egreso = new MovimientoMonetario("test", -500);
		egreso.setObservacion("agrego egreso robo");
		egreso.setFecha(new Date());
		listaMovimientos.agregarMovimiento(egreso);
		double saldoActual = listaMovimientos
				.getMovimientos()
				.stream()
				.mapToDouble(m -> m.getImporte()).sum();
		assertTrue("Antes y después de egreso: ", saldoActual - saldoAnterior == (double) -500 );
		
	}
	
}
