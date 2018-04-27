package com.economizate.servicios.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.IParserRegistro;

public class ParserRegistroFechaSinCuota implements IParserRegistro {

int cantidadCampos;
	
	public ParserRegistroFechaSinCuota() {
		this.cantidadCampos = 4;
	}
	
	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public MovimientoMonetario getObjeto(String[] stringarray) {
		MovimientoMonetario movimiento = null;
		try {
			movimiento = new MovimientoMonetario(stringarray[1], stringarray[2], 
					Double.parseDouble(stringarray[3]), formater.parse(stringarray[0]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return movimiento; 
	}

	@Override
	public int getCantidadCampos() {		
		return cantidadCampos;
	}
}
