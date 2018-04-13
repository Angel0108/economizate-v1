package com.economizate.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.economizate.entidades.Saldo;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.Saldos;
import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.SaldosImpl;
import com.economizate.servicios.impl.UsuariosImpl;
import com.economizate.vistas.Egreso;
import com.economizate.vistas.Home;
import com.economizate.vistas.Ingreso;

public class ControladorEgreso implements ActionListener{
	
	Saldos saldosService;
	Usuarios usuarioService;
	
	private Usuario  model;
	private Egreso vista;
	private Home home;
	
	public ControladorEgreso() {
	}
	
	public ControladorEgreso(Usuario usuario, Egreso vista, Home home, Usuarios usuarios) {
		this.vista = vista;
		this.model = usuario;
		this.home = vista.getVentanaHome();
		
		this.usuarioService = usuarios;
	}

	public void actionPerformed(ActionEvent e) {
		//lo cambio en la "base"
		usuarioService.obtenerSaldoUsuario(model).setTotal(- Double.parseDouble(vista.getImporteTextFieldValue()) 
				+ model.getSaldo().getTotal());
		
		//actualizo las vistas
		vista.getSaldoUsuario().setText("Saldo: " + String.valueOf(usuarioService.obtenerSaldoUsuario(model).getTotal()));
		home.setSaldoUsuario("Saldo: " + String.valueOf(usuarioService.obtenerSaldoUsuario(model).getTotal()));
		 
		//volver Home
		vista.getVentana().setVisible(false);
		home.getVentana().setVisible(true);
	}


}
