package com.economizate.servicios.impl;

import com.economizate.entidades.Alerta;
import com.economizate.servicios.Alertas;
import com.economizate.servicios.IAlertas;

public class AlertaRoja extends Alertas implements IAlertas {

	public AlertaRoja(double saldoAnterior, double saldoActual) {
		super(saldoAnterior, saldoActual);
	}

	public AlertaRoja() {
		
	}
	
	@Override
	public Alerta crearAlerta() {
		Alerta alert = conector.crearAlerta(saldoAnterior, saldoActual);
		alert.setTipoAlerta(new AlertaRoja());
		return alert;
	}

	@Override
	public boolean esNecesarioAlerta() {		
		return true;
	}

	@Override
	public String getMensaje() {
		return "Ha superado el 95%";
	}

	
}
