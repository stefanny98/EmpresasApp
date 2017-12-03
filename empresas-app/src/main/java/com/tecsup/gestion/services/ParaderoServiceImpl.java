package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.ParaderoDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Paradero;

@Service
public class ParaderoServiceImpl implements ParaderoService{
	@Autowired
	private ParaderoDAO paraderoDAO;
	
	@Override
	public List<Paradero> findAllParaderos() throws DAOException, EmptyResultException {
		
		List<Paradero> prd = paraderoDAO.findAllParaderos();

		return prd;
	}
	
	@Override
	public List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException {
		
		List<Paradero> paraderos = paraderoDAO.findParaderosByEmpresa(nombre);

		return paraderos;
	}
	
	@Override
	public List<Paradero> findAll() throws DAOException, EmptyResultException {
		
		List<Paradero> prds = paraderoDAO.findAll();
	
		return prds;
	}

	@Override
	public Paradero find(int id_empresa) throws DAOException, EmptyResultException {
		Paradero prd = paraderoDAO.findParadero(id_empresa);

		return prd;
		
	}
	

	@Override
	public void update(String nombre, Double latitud, Double longitud, int id_empresa) throws DAOException {
		paraderoDAO.update(nombre, latitud,longitud, id_empresa);
		
	}

	@Override
	public void delete(String nombre) throws DAOException {
		paraderoDAO.delete(nombre);
		
	}

	@Override
	public void create(String nombre, Double latitud, Double longitud) throws DAOException {
		paraderoDAO.create(nombre,latitud,longitud);
		
	}



}