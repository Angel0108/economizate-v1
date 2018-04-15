package com.economizate.datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.economizate.entidades.Cuenta;
import com.economizate.entidades.Usuario;

public class StringMovimientos {

	private List<String> movimientos;

	public StringMovimientos() {
		super();
		this.movimientos = new ArrayList<>();
	}
	
	@Deprecated
	private List<String> llenarLista(){
		return Arrays.asList(
				"compra;chino;50;5",
				"compra;chino;50b;2" );
	}
	
	public List<String> getMovimientos() {
		return llenarLista();
	}	
	
}
