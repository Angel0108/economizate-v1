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
import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollBar;

public class Reportes extends JFrame implements ActionListener{
	
private static Logger logger = Logger.getLogger(Reportes.class.getName());
	
	private JFrame ventana;
	private JButton botonVolver;
	private JTextPane listaMovimientos;
	private JLabel lblFiltrar;
	private JDateChooser DateChooserDesde;
	private JDateChooser DateChooserHasta;
	private JLabel lblDesde;
	
	private Usuarios usuarios;
	
	private String email;
	
	public Reportes() {
		getContentPane().setLayout(null);
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(186, 406, 89, 23);
		getContentPane().add(botonVolver);
		
		listaMovimientos = new JTextPane();
		listaMovimientos.setBounds(21, 104, 403, 291);
		getContentPane().add(listaMovimientos);
	
		
		lblDesde = new JLabel("Fecha desde:");
		lblDesde.setBounds(40, 50, 119, 14);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(238, 43, 32, 14);
		getContentPane().add(lblHasta);
		
		
		
		usuarios = new UsuariosImpl();
		iniciarBotones();
	}
	
	public Reportes(String email, Usuarios usuarios) {
		this.usuarios = usuarios;
		this.email = email;
		iniciarBotones();
		iniciarJLabels();
		iniciarJDChoosers();
	}
	
	public void iniciarVista() {
		ventana = new JFrame();
		
		ventana.getContentPane().add(botonVolver);
		ventana.getContentPane().add(listaMovimientos);
		ventana.getContentPane().add(lblFiltrar);
		ventana.getContentPane().add(DateChooserDesde);
		ventana.getContentPane().add(DateChooserHasta);
		ventana.getContentPane().add(lblDesde);

		
		ventana.setTitle("Reporte de movimientos");
		ventana.setSize(600,500);
		ventana.getContentPane().setLayout(null); 
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
		listaMovimientos.setBounds(20, 100, 550, 300);
		listaMovimientos.setEditable(false);
		
		lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setBounds(21, 11, 46, 14);
		getContentPane().add(lblFiltrar);
		
		lblDesde = new JLabel("Fecha desde:");
		lblDesde.setBounds(21, 43, 65, 14);
		getContentPane().add(lblDesde);
		
		

	}
	
	private void iniciarJDChoosers() {
		DateChooserDesde = new JDateChooser();
		DateChooserDesde.setBounds(130, 35, 87, 20);
		getContentPane().add(DateChooserDesde);
		
		//falta terminar este ..
		DateChooserHasta = new JDateChooser();
		DateChooserHasta.setBounds(300, 35, 87, 20);
		getContentPane().add(DateChooserHasta);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
