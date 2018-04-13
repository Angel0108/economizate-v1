package com.economizate.datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.economizate.entidades.Saldo;
import com.economizate.entidades.Usuario;

public class ListaUsuarios {
	
	private List<Usuario> usuarios;

	public ListaUsuarios() {
		super();
		this.usuarios = new ArrayList<>();
	}
	
	@Deprecated
	private List<Usuario> llenarLista(){
		return Arrays.asList(
				new Usuario("pepe", "gonzalez", "pepeGonzalez@gmail.com"),
				new Usuario("juan", "sanchez", "juanSanchez@gmail.com"),
				new Usuario("carlos", "gaitan", "elGaita@gmail.com")); 
	}
	
	public void agregarUsuario(Usuario usuario) {
		Saldo saldo = new Saldo();
		usuario.setSaldo(saldo);
		usuarios.add(usuario);
	}
	
	public void agregarUsuario(String nombre, String apellido, String email) {
		Usuario usuario = new Usuario(nombre, apellido, email);
		Saldo saldo = new Saldo();
		usuario.setSaldo(saldo);
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) throws Exception {
		return usuarios
				.stream()
				.filter(usuario -> email.equals(usuario.getEmail()))
				.findFirst().orElseThrow(() -> new Exception("No se encontró el usuario"));
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}	

}
