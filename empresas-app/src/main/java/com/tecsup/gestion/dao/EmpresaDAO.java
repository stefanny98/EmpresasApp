package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.model.Paradero;

public interface EmpresaDAO {

	List<Empresa> findAllEmpresas() throws DAOException, EmptyResultException;

	List<Paradero> findAllParaderos() throws DAOException, EmptyResultException;
	
	List<String> findAllNames() throws DAOException, EmptyResultException;

	List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException;

	Empresa findEmpresa(int empresa_id) throws DAOException, EmptyResultException;
}
