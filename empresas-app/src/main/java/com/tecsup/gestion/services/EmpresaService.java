package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.model.Paradero;

public interface EmpresaService {
	
	List<Empresa> findAll() throws DAOException, EmptyResultException;
	
	List<Paradero> findAllParaderos() throws DAOException, EmptyResultException;
	
	List<String> findAllNames() throws DAOException, EmptyResultException;
	
}
