package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.UsuarioDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioDAO usuarioDAO;
	

	@Override
	public void update(String username, String fullname,String email, long id) throws DAOException {
		usuarioDAO.update(username,fullname,email,id);
		
	}


	@Override
	public Usuario find(Long id) throws DAOException, EmptyResultException {
		Usuario u1 = usuarioDAO.find(id);
		return u1;
	}

	

}