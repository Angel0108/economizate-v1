package com.economizate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.economizate.entidades.Usuario;
import com.economizate.servicios.impl.UsuariosImpl;

import junit.framework.Assert;

public class UsuarioTest {
	
	@Test
	public void buscarUnUsuarioPorEmailYEncontrarElUsuaioOK() {
		Usuario usuario = new UsuariosImpl().buscarUsuarioPorEmail("pepeGonzalez@gmail.com");
		assertEquals("No encontre el usuario: ", usuario.getEmail(), "pepeGonzalez@gmail.com");
	}
	
}
