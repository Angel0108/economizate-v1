package com.economizate.servicios.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ValidationException;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.ImportadorStrategy;

public class LoaderMovimientosFromFile {

	public LoaderMovimientosFromFile(String filename) throws IOException, ParseException, ValidationException {
		
		/*ImportadorStrategy importador = new TxtImportadorStrategy();
		ParserListRegistrosMovimientos parser = new ParserListRegistrosMovimientos(importador.importarFile(filename));
		List<MovimientoMonetario> registrosMovimientos = parser.parse();
		
		Iterator<MovimientoMonetario> iterator = registrosMovimientos.iterator();
		int linea = 0;
		while (iterator.hasNext()) {
			linea++;
			MovimientoMonetario r = iterator.next();
			r.setValidador(new ConcreteValidadorRegistroStrategy());
			if(!r.isValid()) {
				throw new ValidationException("Registro inválido. Línea " + linea);
			}
			
		}		*/
	}
	
	
	
}
