package com.economizate.servicios.impl;

import com.economizate.entidades.MovimientoMonetario;

public class ConvertToMovimiento {

	
	public static MovimientoMonetario getObject(String LineString, String separator) 
    { 
        String[] stringarray = LineString.split(separator);         
        if(stringarray.length == 4) {
        	return getObjectConCuotas(stringarray);
        } else {
        	return getObjectSinCuotas(stringarray);
        }
    }
	
	private static MovimientoMonetario getObjectConCuotas(String[] stringarray) 
    {       
        MovimientoMonetario movimiento = new MovimientoMonetario(stringarray[0], stringarray[1], 
        		Double.parseDouble(stringarray[2]), (int)Double.parseDouble(stringarray[3])); 
        return movimiento; 
    }
	
	private static MovimientoMonetario getObjectSinCuotas(String[] stringarray) 
    {        
        MovimientoMonetario movimiento = new MovimientoMonetario(stringarray[0], stringarray[1], 
        		Double.parseDouble(stringarray[2])); 
        return movimiento; 
    } 
}
