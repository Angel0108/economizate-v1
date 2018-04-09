package com.economizate.servicios.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserListRegistrosMovimientos {

	private List<Registro> registrosMovs;
	private String registros;
	
	public ParserListRegistrosMovimientos(String registros) {
		
		this.registros  = registros;
		
	}
	
	public List<Registro> parse() throws ParseException {
		
		registrosMovs = new ArrayList<Registro>();		
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
