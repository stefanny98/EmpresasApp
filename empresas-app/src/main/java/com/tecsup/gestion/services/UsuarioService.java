package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Usuario;

public interface UsuarioService {


	void update(String username, String fullname,String email, long id)
			throws DAOException;

	Usuario find(Long id) throws DAOException, EmptyResultException;
}
