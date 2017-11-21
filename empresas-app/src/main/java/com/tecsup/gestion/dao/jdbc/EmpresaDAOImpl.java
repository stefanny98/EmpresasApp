package com.tecsup.gestion.dao.jdbc;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tecsup.gestion.dao.EmpresaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.EmpresaMapper;
import com.tecsup.gestion.mapper.ParaderoMapper;
import com.tecsup.gestion.mapper.PruebaMapper;
import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.model.Paradero;

@Repository
public class EmpresaDAOImpl implements EmpresaDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmpresaDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Empresa> findAllEmpresas() throws DAOException, EmptyResultException {

		String query = "SELECT * FROM empresas";

		try {

			List<Empresa> employees = jdbcTemplate.query(query, new EmpresaMapper());
			//
			return employees;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Paradero> findAllParaderos() throws DAOException, EmptyResultException {

		String query = "select e.nombre, p.nombre, p.longitud, p.latitud from empresas e, paraderos p, empresas_has_paraderos where empresas_id_empresa = id_empresa and paraderos_id_paradero= id_paradero";

		try {

			List<Paradero> paraderos = jdbcTemplate.query(query, new ParaderoMapper());
			//
			return paraderos;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<String> findAllNames() throws DAOException, EmptyResultException {
	

		String query = "SELECT nombre FROM empresas";
		
		try {

			List<String> nombres = jdbcTemplate.query(query, new PruebaMapper());
			//
			return nombres;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException {
	

		String query = "select e.nombre, p.nombre, p.longitud, p.latitud from empresas e, paraderos p, empresas_has_paraderos where (empresas_id_empresa = id_empresa and paraderos_id_paradero= id_paradero) and e.nombre = ?";
		
		Object[] params = new Object[] { nombre };
		
		try {

			List<Paradero> paraderos = jdbcTemplate.query(query, params, new ParaderoMapper());
			//
			return paraderos;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public Empresa findEmpresa(int empresa_id) throws DAOException, EmptyResultException {
	

		String query = "select * from empresas where id_empresa = ?";
		
		Object[] params = new Object[] { empresa_id };
		
		try {

			Empresa empresa = (Empresa) jdbcTemplate.queryForObject(query, params, new EmpresaMapper());
			//
			return empresa;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
}
