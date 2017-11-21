package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.EmpresaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.model.Paradero;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Override
	public List<Empresa> findAll() throws DAOException, EmptyResultException {
		
		List<Empresa> emp = empresaDAO.findAllEmpresas();

		return emp;
	}
	
	@Override
	public List<Paradero> findAllParaderos() throws DAOException, EmptyResultException {
		
		List<Paradero> prd = empresaDAO.findAllParaderos();

		return prd;
	}
	
	@Override
	public List<String> findAllNames() throws DAOException, EmptyResultException {
		
		List<String> prd = empresaDAO.findAllNames();

		return prd;
	}

	@Override
	public List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException {
		
		List<Paradero> paraderos = empresaDAO.findParaderosByEmpresa(nombre);

		return paraderos;
	}
	
	@Override
	public Empresa findEmpresa(int empresa_id) throws DAOException, EmptyResultException {
		
		Empresa empresa = empresaDAO.findEmpresa(empresa_id);

		return empresa;
	}
}
