package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Paradero;

public interface ParaderoService {

	List<Paradero> findAllParaderos() throws DAOException, EmptyResultException;

	List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException;
	
	Paradero find(int id_paradero) throws DAOException, EmptyResultException;

	List<Paradero> findAll() throws DAOException, EmptyResultException; 

	void update(String nombre, Double latitud, Double longitud, int id_empresa)
			throws DAOException;

	void delete(String nombre) throws DAOException;

	void create(String nombre, Double latitud, Double longitud) throws DAOException;
}
