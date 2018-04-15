package com.economizate.servicios.impl;

import com.economizate.conector.ConectorAlerta;
import com.economizate.entidades.Alerta;
import com.economizate.servicios.Alertas;
import com.economizate.servicios.IAlertas;

public class AlertaAmarilla extends Alertas implements IAlertas {
	
	
		
	public AlertaAmarilla(double saldoAnterior, double saldoActual) {
		super(saldoAnterior, saldoActual);
	}
	
	public AlertaAmarilla() {
		
	}
	
	@Override
	public Alerta crearAlerta() {
		Alerta alert = conector.crearAlerta(saldoAnterior, saldoActual);
		alert.setTipoAlerta(new AlertaAmarilla());
		return alert;
	}

	@Override
	public boolean muestraAlerta() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getMensaje() {
		return "Ha superado el 80%";
	}


}
