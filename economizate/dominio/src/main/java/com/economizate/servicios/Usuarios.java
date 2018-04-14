package com.economizate.servicios;

import com.economizate.entidades.Cuenta;
import com.economizate.entidades.Usuario;

public interface Usuarios {
	
	public Usuario buscarUsuarioPorEmail(String email);
	
	public Cuenta obtenerSaldoUsuario(Usuario usuario);

}
