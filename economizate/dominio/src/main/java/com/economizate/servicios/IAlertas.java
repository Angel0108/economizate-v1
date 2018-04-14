package com.economizate.servicios;

import com.economizate.entidades.Alerta;

public interface IAlertas {

	public Alerta crearAlerta(); 
	
	public boolean esNecesarioAlerta();
	
	public String getMensaje();
}
