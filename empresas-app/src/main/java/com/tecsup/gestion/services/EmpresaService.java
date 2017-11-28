package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Empresa;

public interface EmpresaService {
	
	List<Empresa> findAll() throws DAOException, EmptyResultException;
	
	List<String> findAllNames() throws DAOException, EmptyResultException;

	Empresa findEmpresa(int empresa_id) throws DAOException, EmptyResultException;
	
	void update(String nombre, String descripcion, int id_empresa) throws DAOException;

	void delete(String nombre) throws DAOException;

	void create(String nombre, String descripcion) throws DAOException;
	
}
