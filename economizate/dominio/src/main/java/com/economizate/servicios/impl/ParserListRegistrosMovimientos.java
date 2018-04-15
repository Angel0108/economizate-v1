package com.economizate.servicios.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.economizate.entidades.MovimientoMonetario;

public class ParserListRegistrosMovimientos {

	private List<MovimientoMonetario> registrosMovs;
	private String registros;
	
	public ParserListRegistrosMovimientos(String registros) {
		
		this.registros  = registros;
		
	}
	
	public List<MovimientoMonetario> parse() throws ParseException {
		
		registrosMovs = new ArrayList<MovimientoMonetario>();		
		Scanner scanner = new Scanner(registros);
		while (scanner.hasNextLine()) {
		  ParserRegistroMovimiento parseRegistro = new ParserRegistroMovimiento(scanner.nextLine());
		  registrosMovs.add(parseRegistro.parse());
		  // process the line
		}
		scanner.close();
		return registrosMovs;
	}
}
