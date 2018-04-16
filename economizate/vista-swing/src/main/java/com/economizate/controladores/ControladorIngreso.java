package com.economizate.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import com.economizate.entidades.Cuenta;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.Saldos;
import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.SaldosImpl;
import com.economizate.vistas.Home;
import com.economizate.vistas.Ingreso;

public class ControladorIngreso implements ActionListener{
	
	private static Logger logger = Logger.getLogger(ControladorIngreso.class.getName());
	
	Usuarios usuarioService;
	
	private Usuario  model;
	private Ingreso vista;
	private Home home;
	
	public ControladorIngreso() {
		this.model.addObserver(vista);
	}
	
	public ControladorIngreso(Usuario usuario, Ingreso vista, Home home, Usuarios usuarios) {
		this.vista = vista;
		this.model = usuario;
		this.home = vista.getVentanaHome();
		
		this.usuarioService = usuarios;
		
		//No es necesario porque se agregan en los constructores de cada servicio
		//this.model.addObserver(home);
		//this.model.addObserver(vista);
	}

	public void actionPerformed(ActionEvent e) {
		logger.info("Ingreso action controlador");
		
		//lo cambio en la "base"
		usuarioService.obtenerSaldoUsuario(model).setTotal(Double.parseDouble(vista.getImporteTextFieldValue())
				+ model.getSaldo().getTotal());
		
		//actualizo las vistas
		vista.getSaldoUsuario().setText("Saldo: " + String.valueOf(usuarioService.obtenerSaldoUsuario(model).getTotal()));
		home.setSaldoUsuario("Saldo: " + String.valueOf(usuarioService.obtenerSaldoUsuario(model).getTotal()));
		home.setServicioUsuario(usuarioService);
		 
		//volver Home
		vista.getVentana().setVisible(false);
		home.getVentana().setVisible(true);
	}
}
