package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.EmpresaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Empresa;

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
	public List<String> findAllNames() throws DAOException, EmptyResultException {
		
		List<String> prd = empresaDAO.findAllNames();

		return prd;
	}

	
	@Override
	public Empresa findEmpresa(int empresa_id) throws DAOException, EmptyResultException {
		
		Empresa empresa = empresaDAO.findEmpresa(empresa_id);

		return empresa;
	}
	
	@Override
	public void update(String nombre, String descripcion, int id_empresa) throws DAOException {
		empresaDAO.update(nombre, descripcion, id_empresa);
		
	}

	@Override
	public void delete(String nombre) throws DAOException {
		empresaDAO.delete(nombre);
		
	}

	@Override
	public void create(String nombre, String descripcion) throws DAOException {
		empresaDAO.create(nombre, descripcion);
		
	}
}
