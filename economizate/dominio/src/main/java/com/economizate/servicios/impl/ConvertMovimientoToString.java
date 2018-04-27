package com.economizate.servicios.impl;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.IConversorMovimiento;

public class ConvertMovimientoToString {

	public static String getRegistro(MovimientoMonetario movimiento, IConversorMovimiento conversor) 
    { 
        return conversor.convertToString(movimiento);
    }
}
