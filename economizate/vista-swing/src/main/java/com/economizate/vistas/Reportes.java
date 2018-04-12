package com.economizate.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import com.economizate.controladores.ControladorIngreso;
import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.UsuariosImpl;

public class Reportes implements ActionListener{
	
private static Logger logger = Logger.getLogger(Reportes.class.getName());
	
	private JFrame ventana;
	private JButton botonVolver;
	private JTextPane listaMovimientos;
	
	private Usuarios usuarios;
	
	private String email;
	
	public Reportes() {
		usuarios = new UsuariosImpl();
		iniciarBotones();
	}
	
	public Reportes(String email) {
		usuarios = new UsuariosImpl();
		this.email = email;
		iniciarBotones();
		iniciarJLabels();
	}
	
	public void iniciarVista() {
		ventana = new JFrame();
		
		ventana.add(botonVolver);
		ventana.add(listaMovimientos);
		
		ventana.setTitle("Ingreso");
		ventana.setSize(600,500);
		ventana.setLayout(null); 
		ventana.setVisible(true);
	}
	
	private void iniciarBotones() {
		botonVolver =new JButton("Volver");
		botonVolver.setBounds(50,400,100, 40); 
		botonVolver.addActionListener(this);
	}
	
	private void iniciarJLabels() {
		listaMovimientos = new JTextPane();
		listaMovimientos.setText("Historial movimientos: \n" +
				usuarios
				.buscarUsuarioPorEmail(email)
				.getSaldo()
				.getMovimientos());
		listaMovimientos.setBounds(20, 20, 500, 100);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
