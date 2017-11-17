package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Paradero;

public class ParaderoMapper implements RowMapper<Paradero>{
	
public Paradero mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Paradero prd = new Paradero();
		
		prd.setEmpresa(rs.getString(1));
		prd.setNombre(rs.getString(2));
		prd.setLongitud(rs.getDouble(3));
		prd.setLatitud(rs.getDouble(4));
		
		return prd;
	}

}
