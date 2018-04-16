package com.economizate.servicios.impl;

import java.util.List;
import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.Criterio;

public class AndCriterio implements Criterio {

	private Criterio criterio1;
	private Criterio criterio2;
	
	public AndCriterio(Criterio criterio1, Criterio criterio2) {
		this.criterio1 = criterio1;
		this.criterio2 = criterio2;
	}
	
	@Override
	public List<MovimientoMonetario> filtrarMovimientos(
			List<MovimientoMonetario> movimientos) {
		
		List<MovimientoMonetario> movimientosFinal = criterio1.filtrarMovimientos(movimientos);		
		return criterio2.filtrarMovimientos(movimientosFinal);
	}

	
}
