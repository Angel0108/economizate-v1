package com.economizate.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.UsuariosImpl;

public class Home implements ActionListener{
	
	private JFrame ventana;
	private JButton botonIngreso;
	private JLabel nombreUsuario;
	
	Usuarios usuarios = new UsuariosImpl();
	
	public Home() {
	}
	
	public void iniciarVista() {
		ventana = new JFrame();
	    
		botonIngreso =new JButton("Ingreso");
		botonIngreso.setBounds(130,100,100, 40); 
		botonIngreso.addActionListener(this);
		
		nombreUsuario = new JLabel();
		nombreUsuario.setBounds(50,50, 250,20);      
		nombreUsuario.setVisible(false);
		          
		ventana.add(botonIngreso); 
		ventana.add(nombreUsuario);
		
		ventana.setTitle("Economizate");
		ventana.setSize(400,500);
		ventana.setLayout(null); 
		ventana.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent evento) {
		nombreUsuario.setText("Bienvenido: " + 
				usuarios.buscarUsuarioPorEmail("pepeGonzalez@gmail.com").getEmail());
		nombreUsuario.setVisible(true);
		botonIngreso.setVisible(false);
		
		
	}
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
