package com.economizate.servicios;

import com.economizate.servicios.impl.CSVReader;
import com.economizate.servicios.impl.ExcelReader;
import com.economizate.servicios.impl.ParserType;
import com.economizate.servicios.impl.PipeReader;

public class FactoryReader {

	public static BaseReader getParseador(String nombreArchivo) {
		
		String[] separador = nombreArchivo.split(".");
		
		if(separador.length == 0) {
			return null;
		} else if(separador[separador.length - 1].toUpperCase().equals(ParserType.CSV.toString())) {
			return new CSVReader(nombreArchivo);
		} else if(separador[separador.length - 1].toUpperCase().equals(ParserType.PIPE.toString())) {
			return new PipeReader(nombreArchivo);
		} else if(separador[separador.length - 1].toUpperCase().equals(ParserType.EXCEL.toString())) {
			return new ExcelReader(nombreArchivo);			
		}
		
		return null;
	}
}
