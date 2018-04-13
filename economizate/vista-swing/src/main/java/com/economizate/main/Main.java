package com.economizate.main;

import com.economizate.vistas.Home;

public class Main {


	public static void main(String[] args) {

		String emailUsuario = "pepeGonzalez@gmail.com"; //sacar a Test!! (-.-)
		
		Home home = new Home(emailUsuario);
		home.iniciarVista();
		
	}
}
