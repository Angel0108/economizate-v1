package com.economizate.conector;

import com.economizate.entidades.Alerta;

public class ConectorAlerta {
	
	private Alerta alerta;
	
	public Alerta crearAlerta(double saldoAnterior, double saldoActual) {
		if(alerta == null) {
			alerta = new Alerta(saldoAnterior, saldoActual);
			alerta.setMensaje("Alerta tipo 80%");
		}
		return alerta;
	}

}
