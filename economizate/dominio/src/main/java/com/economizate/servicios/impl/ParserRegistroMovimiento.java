package com.economizate.servicios.impl;

import java.text.ParseException;

public class ParserRegistroMovimiento {

	private String registro;
	
	
	public ParserRegistroMovimiento(String registro) {
		this.registro = registro;
	}
	
	public Registro parse() throws ParseException {
		String[] campos = this.registro.split("|");
		if(campos.length != 3) {
			throw new ParseException("El registro de movimiento debe contener 3 campos", -10);
		}
		Registro reg = new Registro();
		reg.setConcepto(campos[0]);
		reg.setObservacion(campos[1]);
		reg.setImporte(campos[2]);
		return reg;
	}
}
