package com.economizate.vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.UsuariosImpl;
import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

public class Reportes extends JFrame implements ActionListener, java.util.Observer {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@SuppressWarnings("unused")
private static Logger logger = Logger.getLogger(Reportes.class.getName());
	
	private JFrame ventana;
	private JButton botonVolver;
	private JTextPane listaMovimientos;
	private JLabel lblFiltrar;
	private JDateChooser dateChooserDesde;
	private JDateChooser dateChooserHasta;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private Home ventanaHome;
	
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
		lblDesde.setBounds(40, 50, 89, 14);
		getContentPane().add(lblDesde);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(258, 50, 56, 14);
		getContentPane().add(lblHasta);
		
		
		
		usuarios = new UsuariosImpl();
		iniciarBotones();
		iniciarJDChoosers();
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
		ventana.getContentPane().add(dateChooserDesde);
		ventana.getContentPane().add(dateChooserHasta);
		ventana.getContentPane().add(lblDesde);
		ventana.getContentPane().add(lblHasta);

		
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
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(258, 50, 37, 14);
		getContentPane().add(lblHasta);
		
		
		

	}
	
	private void iniciarJDChoosers() {
		dateChooserDesde = new JDateChooser();
		dateChooserDesde.setBounds(128, 44, 108, 20);
		getContentPane().add(dateChooserDesde);
		
		
		dateChooserHasta = new JDateChooser();
		dateChooserHasta.setBounds(318, 44, 119, 20);
		getContentPane().add(dateChooserHasta);

		
		

	}
	
	public Home getVentanaHome() {
		return ventanaHome;
	}

	public void setVentanaHome(Home ventanaHome) {
		this.ventanaHome = ventanaHome;
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Apéndice de método generado automáticamente
		
	}
}
