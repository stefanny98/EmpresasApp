package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class NombreMapper implements RowMapper<String>{
	
	public String mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		String nombre = rs.getString(1);
		
		return nombre;
	}

}
