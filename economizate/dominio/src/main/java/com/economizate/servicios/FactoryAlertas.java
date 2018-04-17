package com.economizate.servicios;

import com.economizate.servicios.impl.AlertaAmarilla;
import com.economizate.servicios.impl.AlertaRoja;
import com.economizate.servicios.impl.AlertaVerde;

public class FactoryAlertas {

	
	public static Alertas getTipoAlerta(double saldoAnterior, double saldoActual) {
		if(getPorcentajeGasto(saldoAnterior, saldoActual) <= (double)5)
			return new AlertaRoja(saldoAnterior, saldoActual);
		else if(getPorcentajeGasto(saldoAnterior, saldoActual) <= (double)20)
			return new AlertaAmarilla(saldoAnterior, saldoActual);
		else 
			return new AlertaVerde(saldoAnterior, saldoActual);
	}
	
	private static double getPorcentajeGasto(double saldoAnterior, double saldoActual) {
		return (double)saldoActual * 100 / saldoAnterior;
	}
}
