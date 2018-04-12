package com.economizate.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.economizate.entidades.Usuario;
import com.economizate.listeners.EgresoListener;
import com.economizate.listeners.IngresoListener;
import com.economizate.listeners.ReportesListener;
import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.UsuariosImpl;

public class Home implements ActionListener{
	
	private static Logger logger = Logger.getLogger(Home.class.getName());
	
	private JFrame ventana;
	private JButton botonLogin;
	private JButton botonIngreso;
	private JButton botonEgreso;
	private JButton botonEgresosPeriodicos;
	private JButton botonReportes;
	private JLabel nombreUsuario;
	private JLabel saldoUsuario;
	
	private Usuarios usuarios;
	private String email;
	//private Usuario usuario;
	
	public Home() {
		usuarios = new UsuariosImpl();

		ventana = new JFrame();
		iniciarBotones();
		iniciarJLabels();
	}
	
	public Home(String email) {
		this.email = email;
		usuarios = new UsuariosImpl();

		ventana = new JFrame();
		iniciarBotones();
		iniciarJLabels();
		
		//usuario = new UsuariosImpl().buscarUsuarioPorEmail(email);
	}
	
	public void iniciarBotones() {
		iniciarBotonLogin();
		iniciarBotonIngreso();
		iniciarBotonEgreso();
		iniciarBotonEgresoPeriodico();
		iniciarBotonReportes();
	}
	
	public void iniciarBotonLogin() {
		botonLogin =new JButton("Login");
		botonLogin.setBounds(130,100,100, 40); 
		botonLogin.addActionListener(this);
	}
	
	public void iniciarBotonIngreso() {
		botonIngreso =new JButton("Ingreso");
		botonIngreso.setBounds(70,100,100, 40); 
		botonIngreso.addActionListener(
				new IngresoListener(this, email, usuarios.buscarUsuarioPorEmail(email).getSaldo().getTotal()));
	}
	
	public void iniciarBotonEgreso() {
		botonEgreso =new JButton("Egreso");
		botonEgreso.setBounds(250,100,100, 40); 
		botonEgreso.addActionListener(
				new EgresoListener(this, email, usuarios.buscarUsuarioPorEmail(email).getSaldo().getTotal()));
		
	}
	
	public void iniciarBotonEgresoPeriodico() {
		botonEgresosPeriodicos =new JButton("Cuotas");
		botonEgresosPeriodicos.setBounds(70,200,100, 40); 
		botonEgresosPeriodicos.addActionListener(this);
		
	}
	
	public void iniciarBotonReportes() {
		botonReportes =new JButton("Reportes");
		botonReportes.setBounds(250,200,100, 40); 
		botonReportes.addActionListener(new ReportesListener(this, email));
		
	}
	
	public void iniciarJLabels() {
		nombreUsuario = new JLabel();
		nombreUsuario.setBounds(20,50, 250,20);      
		nombreUsuario.setVisible(false);
		
		saldoUsuario = new JLabel();
		saldoUsuario.setBounds(280,50, 250,20);      
		saldoUsuario.setVisible(false);
	}
	
	public void iniciarVista() {
		logger.info("Iniciando Vista Home");
		
		setVisibilidadBotones(false);
		    
		ventana.add(botonLogin); 
		ventana.add(botonIngreso); 
		ventana.add(botonEgreso); 
		ventana.add(botonEgresosPeriodicos); 
		ventana.add(botonReportes); 
		
		ventana.add(nombreUsuario);
		ventana.add(saldoUsuario);
		
		ventana.setTitle("Home");
		ventana.setSize(400,500);
		ventana.setLayout(null); 
		ventana.setVisible(true);
	}
	
	public void setVisibilidadBotones(boolean visible) {
		//botonLogin.setVisible(!visible);
		botonIngreso.setVisible(visible);
		botonEgreso.setVisible(visible);
		botonEgresosPeriodicos.setVisible(visible);
		botonReportes.setVisible(visible);
	}
	

	public void actionPerformed(ActionEvent evento) {
		logger.info("Iniciando Acción Vista Home");
		
		Usuario usuario = usuarios.buscarUsuarioPorEmail(email);
		nombreUsuario.setText("Bienvenido: " +  usuario.getEmail());
		saldoUsuario.setText("Saldo: " + usuario.getSaldo().getTotal());
		nombreUsuario.setVisible(true);
		saldoUsuario.setVisible(true);
		botonLogin.setVisible(false);
		setVisibilidadBotones(true);
	}
	
	public void update(Observable o, Object arg) {
		System.out.println("Update Observable Home");
		//logger.info("Update Observable Home");
		
	}
	
	public JFrame getVentanaHome() {
		return ventana;
	}
	
	public void setSaldoUsuario(String nuevoSaldo) {
		saldoUsuario.setText(nuevoSaldo);
	}
	
	public JFrame getVentana() {
		return ventana;
	}
}
