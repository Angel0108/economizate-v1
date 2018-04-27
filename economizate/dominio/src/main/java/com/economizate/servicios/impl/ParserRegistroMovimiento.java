package com.economizate.servicios.impl;

import java.text.ParseException;

import com.economizate.entidades.MovimientoMonetario;

public class ParserRegistroMovimiento {

	private String registro;
	
	private String delimitador = ";";
	
	private int cantidadCampos;
	
	public ParserRegistroMovimiento(String registro, int cantidadCampos) {
		this.registro = registro;
		this.cantidadCampos = cantidadCampos;
	}
	
	public ParserRegistroMovimiento(String registro, String delimitador, int cantidadCampos) {
		this.delimitador = delimitador;
		this.registro = registro;
		this.cantidadCampos = cantidadCampos;
	}
	
	public MovimientoMonetario parse() throws ParseException, NumberFormatException {
		String[] campos = this.registro.split(delimitador);
		if(campos.length != cantidadCampos) {
			throw new ParseException("El registro de movimiento debe contener " + cantidadCampos + " campos", -10);
		}				
		MovimientoMonetario reg = ConvertToMovimiento.getObject(registro, delimitador);
		
		return reg;
	}
}
