package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Usuario;

public interface UsuarioDAO {
	

	void update(String username, String fullname, String email, long id)throws DAOException;

	Usuario find(long id)throws DAOException, EmptyResultException;

	
	
}
