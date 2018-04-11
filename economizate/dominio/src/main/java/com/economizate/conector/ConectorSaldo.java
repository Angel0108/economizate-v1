package com.economizate.conector;

import java.util.List;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.entidades.Saldo;

public class ConectorSaldo {
	
	private double total = 100;
	
	public Saldo nuevoSaldo() {
		Saldo saldo = new Saldo();
		MovimientoMonetario ingreso = new MovimientoMonetario("cuenta sueldo", 100);
		saldo.getMovimientos().add(ingreso);
		saldo.setTotal(obtenerSaldo());
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
	}

}
