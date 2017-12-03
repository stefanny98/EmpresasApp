package com.tecsup.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.ParaderoDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.Empresa_ParaderoMapper;
import com.tecsup.gestion.mapper.ParaderoMapper;
import com.tecsup.gestion.model.Paradero;

@Repository
public class ParaderoDAOImpl implements ParaderoDAO{
	private static final Logger logger = LoggerFactory.getLogger(ParaderoDAOImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Paradero> findAllParaderos() throws DAOException, EmptyResultException {

		String query = "select e.nombre, p.nombre, p.longitud, p.latitud from empresas e, paraderos p, empresas_has_paraderos where empresas_id_empresa = id_empresa and paraderos_id_paradero= id_paradero";

		try {

			List<Paradero> paraderos = jdbcTemplate.query(query, new Empresa_ParaderoMapper());
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
	public List<Paradero> findParaderosByEmpresa(String nombre) throws DAOException, EmptyResultException {
	

		String query = "select e.nombre, p.nombre, p.longitud, p.latitud from empresas e, paraderos p, empresas_has_paraderos where (empresas_id_empresa = id_empresa and paraderos_id_paradero= id_paradero) and e.nombre = ?";
		
		Object[] params = new Object[] { nombre };
		
		try {

			List<Paradero> paraderos = jdbcTemplate.query(query, params, new Empresa_ParaderoMapper());
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
	public Paradero findParadero(int id_paradero) throws DAOException, EmptyResultException {

		String query = "SELECT id_paradero,nombre, latitud, longitud "
				+ " FROM paraderos WHERE id_paradero = ?";

		Object[] params = new Object[] { id_paradero };

		try {

			Paradero prd = (Paradero) jdbcTemplate.queryForObject(query, params, new ParaderoMapper());
			//
			return prd;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	@Override
	public List<Paradero> findAll() throws DAOException, EmptyResultException {
		String query = "SELECT id_paradero,nombre,latitud,longitud FROM paraderos";

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
	public void create(String nombre, Double latitud, Double longitud) throws DAOException {

		String query = "INSERT INTO paraderos (nombre,latitud,longitud)  VALUES ( ?,?,?)";

		Object[] params = new Object[] { nombre,latitud,longitud};

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

		String query = "DELETE FROM  paraderos WHERE nombre = ? ";

		Object[] params = new Object[] { nombre };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(String nombre, Double latitud, Double longitud, int id_empresa) throws DAOException {

		String query = "UPDATE paraderos SET nombre = ?, latitud =?, longitud =? WHERE id_paradero = ?";

		Object[] params = new Object[] { nombre,latitud, longitud, id_empresa};

		
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}