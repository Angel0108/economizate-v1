package com.economizate.conector;

import java.util.List;
import java.util.Observer;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.entidades.Saldo;

public class ConectorSaldo {
	
	private double total = 100;
	private Saldo saldo;
	private Observer observer;
		
	public Saldo nuevoSaldo() {
		if (saldo == null) {
			saldo = new Saldo();
			MovimientoMonetario ingreso = new MovimientoMonetario("cuenta sueldo", 100);
			saldo.getMovimientos().add(ingreso);
			saldo.setTotal(obtenerSaldo());
		}
		return saldo;
	}
	
	public Saldo nuevoSaldo(Observer o) {
		if (saldo == null) {
			observer = o;
			saldo = new Saldo(o, obtenerSaldo());
			MovimientoMonetario ingreso = new MovimientoMonetario("cuenta sueldo", 100);
			saldo.getMovimientos().add(ingreso);
			saldo.setTotalTest(obtenerSaldo());
		}
		return saldo;
	}
	
	public List<MovimientoMonetario> obtenerHistorialDeMovimientos(){
		return nuevoSaldo().getMovimientos();
	}
	
	public double obtenerSaldo() {
		return total;
	}
	
	public void cambiarSaldo(double importe) {
		total += importe;
		nuevoSaldo().setTotal(total);
	}
	
	public void addObserver(Observer observer) {
		this.observer = observer;
	}

}
