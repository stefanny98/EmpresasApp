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
import com.tecsup.gestion.mapper.NombreMapper;
import com.tecsup.gestion.model.Empresa;

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
	public List<String> findAllNames() throws DAOException, EmptyResultException {
	

		String query = "SELECT nombre FROM empresas";
		
		try {

			List<String> nombres = jdbcTemplate.query(query, new NombreMapper());
			
			return nombres;

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
	
	@Override
	public void create(String nombre, String descripcion) throws DAOException {

		String query = "INSERT INTO empresas (nombre, descripcion)  VALUES (?,?)";

		Object[] params = new Object[] { nombre, descripcion};

		//Employee emp = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);

		} catch (Exception e) {
			//logger.error("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}

	@Override
	public void delete(String nombre) throws DAOException {

		String query = "DELETE FROM  empresas WHERE nombre = ? ";

		Object[] params = new Object[] { nombre };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(String nombre, String descripcion, int id_empresa) throws DAOException {

		String query = "UPDATE empresas SET nombre = ?, descripcion =? WHERE id_empresa = ?";

		Object[] params = new Object[] { nombre, descripcion, id_empresa};

		
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
}
