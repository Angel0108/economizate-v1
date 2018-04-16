package com.economizate.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.Criterio;

public class RangoFechaCriterio implements Criterio {

	private Date fechaDesde;
	private Date fechaHasta;
	
	public RangoFechaCriterio(Date fechaDesde, Date fechaHasta) {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	@Override
	public List<MovimientoMonetario> filtrarMovimientos(
			List<MovimientoMonetario> movimientos) {
		
		List<MovimientoMonetario> movsFecha = new ArrayList<MovimientoMonetario>();
		
		for (MovimientoMonetario mov : movimientos) {
			if(mov.getFecha().after(fechaDesde) && mov.getFecha().before(fechaHasta)) {
				movsFecha.add(mov);
			}
		}
		
		return null;
	}

}
