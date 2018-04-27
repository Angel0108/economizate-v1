package com.economizate.servicios;

import com.economizate.entidades.MovimientoMonetario;

public interface IParserRegistro {

	public MovimientoMonetario getObjeto(String[] stringarray);
	
	public int getCantidadCampos();
}
