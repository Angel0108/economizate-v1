package com.economizate.conector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.economizate.entidades.Usuario;

public class ConectorUsuario {
	
	private ConectorMysql conector;

	public ConectorUsuario() {
		conector = new ConectorMysql();
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Usuario usuario = new Usuario();
		PreparedStatement ps;
		try {
			ps = conector.conectar().prepareStatement("select * from usuarios where email = ?");
		
			ps.setString(1, email);
			try {
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setEmail(rs.getString("email"));
				}
			}finally {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	

}
