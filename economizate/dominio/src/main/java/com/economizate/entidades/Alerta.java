package com.economizate.entidades;

import java.util.Date;

import com.economizate.servicios.Alertas;

public class Alerta extends java.util.Observable {
	
	private Date fecha;
	private double saldoAnterior;
	private double saldoActual;
	private String mensaje;
	private Alertas tipoAlerta;
	
	public Alerta(double saldoAnterior, double saldoActual) {
		this.saldoAnterior = saldoAnterior;
		this.saldoActual = saldoActual;
	}

	public void setTipoAlerta(Alertas tipo) {
		this.tipoAlerta = tipo;
	}
	
	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getMensaje() {
		return tipoAlerta.getMensaje();
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
