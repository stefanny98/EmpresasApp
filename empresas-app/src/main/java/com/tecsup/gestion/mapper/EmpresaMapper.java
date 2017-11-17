package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Empresa;

public class EmpresaMapper implements RowMapper<Empresa>{

	public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Empresa emp = new Empresa();
		
		emp.setId(rs.getInt("id_empresa"));
		emp.setNombre(rs.getString("nombre"));
		emp.setDescripcion(rs.getString("descripcion"));
		
		return emp;
	}
	
}
