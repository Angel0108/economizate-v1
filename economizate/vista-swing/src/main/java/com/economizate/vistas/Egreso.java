package com.economizate.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.economizate.controladores.ControladorEgreso;
import com.economizate.controladores.ControladorIngreso;
import com.economizate.entidades.Saldo;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.impl.UsuariosImpl;

public class Egreso implements java.util.Observer{
	
	private static Logger logger = Logger.getLogger(Ingreso.class.getName());
	
	private JFrame ventana;
	private Home ventanaHome;
	
	private JButton botonEgreso;
	private JLabel nombreUsuario;
	
	private JLabel saldoUsuario;
	
	private JLabel descripcionLabel, observacionLabel, importeLabel;
	private JTextField descripcion, observacion, importe;
	
	private String email;
	private double saldo;
	
	public Egreso() {
		
		iniciarBotonEgreso();
		iniciarLabels();
		iniciarTextFields();
	}
	
	public Egreso(Home ventanaHome, String email, double saldo) {
		this.ventanaHome = ventanaHome;
		this.email = email;
		this.saldo = saldo;
		
		iniciarBotonEgreso();
		iniciarLabels();
		iniciarTextFields();
	}
	
	public void iniciarBotonEgreso() {
		botonEgreso =new JButton("Aceptar");
		botonEgreso.setBounds(50,400,100, 40); 
		botonEgreso.addActionListener(
				new ControladorEgreso(new UsuariosImpl().buscarUsuarioPorEmail(email), this, ventanaHome));
	}
	
	public void iniciarLabels() {
		saldoUsuario = new JLabel();
		saldoUsuario.setBounds(280,20, 250,20);  
		saldoUsuario.setText("Saldo: " + saldo);
		
		descripcionLabel = new JLabel("Descripcion");
		descripcionLabel.setBounds(50, 50, 100, 40);
		
		observacionLabel = new JLabel("Observacion");
		observacionLabel.setBounds(50, 150, 100, 40);
		
		importeLabel = new JLabel("Importe");
		importeLabel.setBounds(50, 250, 100, 40);
	}
	
	public void iniciarTextFields() {
		descripcion = new JTextField();
		descripcion.setBounds(150, 50, 200, 40);
		
		observacion = new JTextField();
		observacion.setBounds(150, 150, 200, 40);
		
		importe = new JTextField();
		importe.setBounds(150, 250, 100, 40);
		importe.setText("0");
	}
	
	public void iniciarVista() {
		logger.info("Iniciando vistas de Egresos");
		
		ventana = new JFrame();
	    
		nombreUsuario = new JLabel();
		nombreUsuario.setBounds(50,50, 250,20);    
		          
		ventana.add(botonEgreso); 
		
		ventana.add(nombreUsuario);
		ventana.add(descripcionLabel);
		ventana.add(observacionLabel);
		ventana.add(importeLabel);
		ventana.add(saldoUsuario);
		
		ventana.add(descripcion);
		ventana.add(observacion);
		ventana.add(importe);
		
		ventana.setTitle("Egreso");
		ventana.setSize(400,500);
		ventana.setLayout(null); 
		ventana.setVisible(true);
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void update(Observable o, Object arg) {
		Saldo saldo = (Saldo) o;
		double total = (Double) arg;
		//logger.info("Update como observador : Observable es " + o.getClass() + ", objecto pasado es " + arg.getClass());
		System.out.println("Update como observador : Observable es " + o.getClass() + ", objecto pasado es " + arg.getClass());
		saldoUsuario.setText("Saldo2: " +  saldo);
	}
	
	public String getImporteTextFieldValue() {
		return importe.getText();
	}

	public JLabel getSaldoUsuario() {
		return saldoUsuario;
	}

	public void setSaldoUsuario(JLabel saldoUsuario) {
		this.saldoUsuario = saldoUsuario;
	}
	
	public void addController(ControladorIngreso controlador) {
		botonEgreso.addActionListener(controlador);
	}
	
	public JFrame getVentana() {
		return ventana;
	}

	public Home getVentanaHome() {
		return ventanaHome;
	}

	public void setVentanaHome(Home ventanaHome) {
		this.ventanaHome = ventanaHome;
	}
	
	
	
}
