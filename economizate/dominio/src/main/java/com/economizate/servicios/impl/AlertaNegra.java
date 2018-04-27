package com.economizate.servicios.impl;

import com.economizate.conector.ConectorAlerta;
import com.economizate.entidades.Alerta;
import com.economizate.servicios.IAlertas;

public class AlertaNegra implements IAlertas {

	ConectorAlerta conector = new ConectorAlerta();
	
	@Override
	public Alerta crearAlerta(double saldoAnterior, double saldoActual) {
		return conector.crearAlertaNegra(saldoAnterior, saldoActual, 
				//Propiedad.getInstance().getPropiedad("mensajeAlerta100Porciento"));
				"Supera el saldo total");
	}

	@Override
	public String getMensaje() {
		return "Supera el saldo total";//Propiedad.getInstance().getPropiedad("mensajeAlerta100Porciento");
	}
	
}