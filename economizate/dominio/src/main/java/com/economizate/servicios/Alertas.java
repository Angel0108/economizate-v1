package com.economizate.servicios;

import com.economizate.conector.ConectorAlerta;

public abstract class Alertas implements IAlertas {
	
	public double saldoAnterior;
	public double saldoActual;	
	public ConectorAlerta conector = new ConectorAlerta();
	
	public Alertas(double saldoAnterior, double saldoActual) {
		this.saldoAnterior = saldoAnterior;
		this.saldoActual = saldoActual;
	}
	
	public Alertas() {
		
	}
		
	
	//public boolean esNecesarioAlerta(double saldoAnterior, double saldoActual);

}
