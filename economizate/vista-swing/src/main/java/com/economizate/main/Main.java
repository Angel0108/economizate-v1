package com.economizate.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.UsuariosImpl;
import com.economizate.vistas.Home;

public class Main {
	
	Usuarios usuarios = new UsuariosImpl();
	
	public void vistaPrueba() {
		JFrame f=new JFrame();//creating instance of JFrame  
        
		JButton b=new JButton("quien soy");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		f.add(b);//adding button in JFrame  
		          
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
	}

	public static void main(String[] args) {

		new Home().iniciarVista();

	}
}
