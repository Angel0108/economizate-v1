package com.economizate.main;

import com.economizate.vistas.Home;

public class Main {


	public static void main(String[] args) {

		String emailUsuario = "pepeGonzalez@gmail.com";
		
		Home home = new Home(emailUsuario);
		/*ControladorIngreso controlador = new ControladorIngreso();
		
		Ingreso vistaIngreso = new Ingreso();
		controlador.setVista(vistaIngreso);
		vistaIngreso.addController(controlador);
		controlador.setModel(new UsuariosImpl().buscarUsuarioPorEmail(emailUsuario));
		*/
		
		home.iniciarVista();
		
	}
}
