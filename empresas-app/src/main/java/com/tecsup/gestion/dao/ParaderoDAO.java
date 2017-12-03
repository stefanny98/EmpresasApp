package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Paradero;

public interface ParaderoDAO {
	
	List<Paradero> findAllParaderos() throws DAOException, EmptyResultException;
	
	List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException;
	
	List<Paradero> findAll() throws DAOException, EmptyResultException;
	
	Paradero findParadero(int id) throws DAOException, EmptyResultException;
	
	void create(String nombre, Double latitud, Double longitud) throws DAOException;

	void delete(String nombre) throws DAOException;

	void update(String nombre, Double latitud, Double longitud, int id_empresa) throws DAOException;

}
