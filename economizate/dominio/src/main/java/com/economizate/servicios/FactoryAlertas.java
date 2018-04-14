package com.economizate.servicios;

import com.economizate.servicios.impl.AlertaAmarilla;
import com.economizate.servicios.impl.AlertaRoja;

public class FactoryAlertas {

	
	public static Alertas getTipoAlerta(double saldoAnterior, double saldoActual) {
		if(getPorcentajeGasto(saldoAnterior, saldoActual) >= (double)95)
			return new AlertaRoja(saldoAnterior, saldoActual);
		else
			return new AlertaAmarilla(saldoAnterior, saldoActual);
	}
	
	private static double getPorcentajeGasto(double saldoAnterior, double saldoActual) {
		return (double)saldoActual * 100 / saldoAnterior;
	}
}
