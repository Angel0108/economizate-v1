package com.economizate.servicios.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ValidationException;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.BaseReader;
import com.economizate.servicios.FactoryImportador;

public class LoaderMovimientosFromFile {

	private List<MovimientoMonetario> registrosMovimientos;
	
	public LoaderMovimientosFromFile(String nombreArchivo) throws IOException, ParseException {				
		BaseReader importador = FactoryImportador.getParseador(nombreArchivo);
		ParserListRegistrosMovimientos parser = new ParserListRegistrosMovimientos(importador.Read());
		registrosMovimientos = parser.parse();
	}
	
	public List<MovimientoMonetario> getMovimientos() throws ValidationException {
		validarMovimientos();
		return registrosMovimientos;
	}
	
	private void validarMovimientos() throws ValidationException {
		Iterator<MovimientoMonetario> iterator = registrosMovimientos.iterator();
		int linea = 0;
		while (iterator.hasNext()) {
			linea++;
			MovimientoMonetario r = iterator.next();
			r.setValidador(new ConcreteValidadorRegistroStrategy());
			if(!r.isValid()) {
				throw new ValidationException("Registro inválido. Línea " + linea);
			}
			
		}
	}
	
	
}
