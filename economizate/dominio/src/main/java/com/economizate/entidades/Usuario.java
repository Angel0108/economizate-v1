package com.economizate.entidades;

import java.util.logging.Logger;

public class Usuario extends java.util.Observable{
	
	private static Logger logger = Logger.getLogger(Saldo.class.getName());
	
	private String nombre;
	private String apellido;
	private String email;
	private Saldo saldo;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}
	
	

}
