package com.economizate.servicios.impl;

import java.util.Observer;

import com.economizate.conector.ConectorUsuario;
import com.economizate.entidades.Cuenta;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.Usuarios;

public class UsuariosImpl implements Usuarios{
	
	private ConectorUsuario conector = new ConectorUsuario();
	
	public UsuariosImpl() {
	}
	
	public UsuariosImpl(Observer o) {
		conector.addObserver(o);
	}

	public Usuario buscarUsuarioPorEmail(String email) {
		return conector.usuarioNuevo();
	}

	public Cuenta obtenerSaldoUsuario(Usuario usuario) {
		return conector.obtenerSaldoUsuario(usuario.getEmail());
	}

}
