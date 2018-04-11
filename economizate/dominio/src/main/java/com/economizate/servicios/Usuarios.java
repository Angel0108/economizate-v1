package com.economizate.servicios;

import com.economizate.entidades.Saldo;
import com.economizate.entidades.Usuario;

public interface Usuarios {
	
	public Usuario buscarUsuarioPorEmail(String email);
	
	public Saldo obtenerSaldoUsuario(Usuario usuario);

}
