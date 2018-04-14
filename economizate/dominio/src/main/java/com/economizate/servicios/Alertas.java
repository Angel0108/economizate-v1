package com.economizate.servicios;

import com.economizate.entidades.Alerta;

public abstract class Alertas {
	
	public double saldoAnterior;
	public double saldoActual;
	
	public Alertas(double saldoAnterior, double saldoActual) {
		this.saldoAnterior = saldoAnterior;
		this.saldoActual = saldoActual;
	}
	
	public abstract Alerta crearAlerta(); 
	
	//public boolean esNecesarioAlerta(double saldoAnterior, double saldoActual);

}
