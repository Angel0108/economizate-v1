package com.economizate.servicios.impl;

import com.economizate.entidades.Alerta;
import com.economizate.servicios.Alertas;
import com.economizate.servicios.IAlertas;

public class AlertaVerde extends Alertas implements IAlertas {

	public AlertaVerde(double saldoAnterior, double saldoActual) {
		super(saldoAnterior, saldoActual);
	}
	
	public AlertaVerde() {
		
	}
	
	@Override
	public Alerta crearAlerta() {
		Alerta alert = conector.crearAlerta(saldoAnterior, saldoActual);
		alert.setTipoAlerta(new AlertaVerde());
		return alert;
	}

	@Override
	public boolean muestraAlerta() {
		return false;
	}

	@Override
	public String getMensaje() {
		return "";
	}
}
