package com.economizate.servicios.impl;

import com.economizate.conector.ConectorAlerta;
import com.economizate.entidades.Alerta;
import com.economizate.servicios.Alertas;

public class AlertaAmarilla extends Alertas{
	
	private ConectorAlerta conector = new ConectorAlerta();
		
	public AlertaAmarilla(double saldoAnterior, double saldoActual) {
		super(saldoAnterior, saldoActual);
	}
	
	@Override
	public Alerta crearAlerta() {
		return conector.crearAlerta(saldoAnterior, saldoActual);
	}

}
