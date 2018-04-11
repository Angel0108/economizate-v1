package com.economizate.servicios.impl;

import java.util.Date;
import java.util.List;

import com.economizate.conector.ConectorSaldo;
import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.Saldos;

public class SaldosImpl implements Saldos{
	
	private ConectorSaldo conector = new ConectorSaldo();

	@Override
	public List<MovimientoMonetario> obtenerHistorialMovimientos() {
		return conector.obtenerHistorialDeMovimientos();
	}

	@Override
	public double obtenerSaldoTotal() {
		return conector.obtenerSaldo();
	}

	@Override
	public List<MovimientoMonetario> obtenerIngresosPorFecha(Date fecha) {
		return new MovimientosMonetariosImpl().obtenerIngresosPorFecha(fecha);
	}

	@Override
	public List<MovimientoMonetario> obtenerEgresosPorFecha(Date fecha) {
		return new MovimientosMonetariosImpl().obtenerEgresosPorFecha(fecha);
	}

	@Override
	public void agregarIngreso(MovimientoMonetario ingreso) {
		
	}

	@Override
	public void agregarEgreso(MovimientoMonetario egreso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarSaldoTotal(double importe) {
		conector.cambiarSaldo(importe);
	}

}