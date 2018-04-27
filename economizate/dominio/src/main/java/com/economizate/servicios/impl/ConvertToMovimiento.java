package com.economizate.servicios.impl;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.IParserRegistro;

public class ConvertToMovimiento {

	
	public static MovimientoMonetario getObject(String LineString, String separator, IParserRegistro parser) 
    { 
        String[] stringarray = LineString.split(separator);         
        return parser.getObjeto(stringarray);
        
    }
}
