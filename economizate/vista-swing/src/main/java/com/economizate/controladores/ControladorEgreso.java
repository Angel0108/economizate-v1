package com.economizate.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.economizate.entidades.Saldo;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.Saldos;
import com.economizate.servicios.impl.SaldosImpl;
import com.economizate.vistas.Egreso;
import com.economizate.vistas.Home;
import com.economizate.vistas.Ingreso;

public class ControladorEgreso implements ActionListener{
	
	Saldos saldosService = new SaldosImpl();
	
	private Usuario  model;
	private Egreso vista;
	private Home home;
	
	public ControladorEgreso() {
	}
	
	public ControladorEgreso(Usuario usuario, Egreso vista, Home home) {
		this.vista = vista;
		this.model = usuario;
		this.home = vista.getVentanaHome();
		
	}

	public void actionPerformed(ActionEvent e) {
		//lo cambio en la "base"
		saldosService.cambiarSaldoTotal(Double.parseDouble(vista.getImporteTextFieldValue()));
		//model.getSaldo().setTotal(Double.parseDouble(vista.getImporteTextFieldValue()) + model.getSaldo().getTotal());
		
		//actualizo las vistas
		vista.getSaldoUsuario().setText("Saldo: " + String.valueOf(saldosService.obtenerSaldoTotal()));
		home.setSaldoUsuario("Saldo: " + String.valueOf(saldosService.obtenerSaldoTotal()));
		 
		//volver Home
		vista.getVentana().setVisible(false);
		home.getVentana().setVisible(true);
	}

	public Usuario getModel() {
		return model;
	}

	public void setModel(Usuario model) {
		this.model = model;
	}

	public Egreso getVista() {
		return vista;
	}

	public void setVista(Egreso vista) {
		this.vista = vista;
	}
	
	

}
