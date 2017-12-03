package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Usuario;


public class UsuarioMapper implements RowMapper<Usuario>{
	
public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Usuario user = new Usuario();
		
		user.setId(rs.getLong(1));
		user.setUsername(rs.getString(2));
		user.setFullname(rs.getString(3));
		user.setEmail(rs.getString(4));
		
		return user;
	}

}