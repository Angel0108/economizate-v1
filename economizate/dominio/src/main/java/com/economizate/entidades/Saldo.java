package com.economizate.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Saldo extends java.util.Observable{
	
	private long id;
	private List<MovimientoMonetario> movimientos;
	private double total;
	
	public Saldo () {
		this.movimientos = new ArrayList<>();
		this.total = 0;
	}
	
	public Saldo (List<MovimientoMonetario> movimientos, double total) {
		this.movimientos = movimientos;
		this.total = total;
	}
	
	public List<MovimientoMonetario> getMovimientos() {
		return movimientos;
	}
	
	public void setMovimientos(List<MovimientoMonetario> movimientos) {
		this.movimientos = movimientos;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
		notifyObservers(total); //MVC
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String imprimirHistoricoMovimientos() {
		List<String> movimientosImpresos = 
				movimientos.stream().map( m -> m.toString()).collect(Collectors.toList());
		return movimientos.stream().map( m -> m.toString()).toString();
	}
}
