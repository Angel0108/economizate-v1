package com.economizate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.Observer;
import java.util.stream.DoubleStream;

import org.junit.Before;
import org.junit.Test;

import com.economizate.conector.ConectorSaldo;
import com.economizate.datos.ListaMovimientos;
import com.economizate.entidades.Cuenta;
import com.economizate.entidades.MovimientoMonetario;

public class IngresosEgresosTest {
	
	ListaMovimientos listaMovimientos;
	Cuenta saldo;
	
	@Before
	public void crearListaConMovimientos() {
		this.listaMovimientos = new ListaMovimientos();
		this.saldo = new ConectorSaldo().nuevoSaldo();
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
	
	@Test
	public void crearNuevoSaldoYVerificarContenido() {
		Cuenta saldoNuevo = new Cuenta(listaMovimientos.getMovimientos(), 99);
		assertTrue("Saldo nuevo ok: ", 99 ==  saldoNuevo.getTotal());
		assertTrue("Lista de movimientos ok : ", listaMovimientos.getMovimientos().equals(saldoNuevo.getMovimientos()));
		
		saldoNuevo.setTotalSinObserver(101);
		assertTrue("Saldo nuevo ok: ", 101 ==  saldoNuevo.getTotal());
	}
	
	@Test
	public void cambiarListaDeMovimientosYObtenerChequeoOK() {

		saldo.setMovimientos(Arrays.asList(new MovimientoMonetario("test", 50)));
		assertTrue("Saldo nuevo cantidad de movimientos ok: ", 1 ==  saldo.getMovimientos().size());
		assertTrue("Saldo nuevo con total ok: ", 50 ==  saldo.getMovimientos().get(0).getImporte());
	}
	
}
