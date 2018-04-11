package com.economizate.conector;

import com.economizate.entidades.MovimientoMonetario;

public class ConectorMovimientoMonetario {
	
	public MovimientoMonetario buscarIngresoPorDescripcion(String descripcion) {
		return new MovimientoMonetario("cuenta sueldo", 100);
	}
	
	public MovimientoMonetario buscarEgresoPorDescripcion(String descripcion) {
		return new MovimientoMonetario("cuenta sueldo", -100);
	}
	

}
