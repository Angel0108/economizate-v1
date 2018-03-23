package com.economizate.servicios.impl;

import com.economizate.conector.ConectorUsuario;
import com.economizate.entidades.Usuario;
import com.economizate.servicios.Usuarios;

public class UsuariosImpl implements Usuarios{
	
	private ConectorUsuario conector = new ConectorUsuario();

	public Usuario buscarUsuarioPorEmail(String email) {
		return conector.buscarUsuarioPorEmail(email);
	}

}
