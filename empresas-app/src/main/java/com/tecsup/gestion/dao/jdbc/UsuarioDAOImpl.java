package com.tecsup.gestion.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.UsuarioDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.UsuarioMapper;
import com.tecsup.gestion.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Usuario find(long id_usuario) throws DAOException, EmptyResultException{

		String query = "SELECT id,username,fullname,email "
				+ " FROM usuarios WHERE id = ?";

		Object[] params = new Object[] { id_usuario };

		try {

			Usuario emp = (Usuario) jdbcTemplate.queryForObject(query, params, new UsuarioMapper());
			
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public void update(String username, String fullname,String email, long id) throws DAOException {


		String query = "UPDATE usuarios SET username = ?, fullname =?, email =? WHERE id = ?";

		Object[] params = new Object[] { username, fullname,email,id};

		
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
