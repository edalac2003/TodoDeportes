package com.tododeportes.backend.dao;

import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface UsuariosDAO {

	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public TbUsuarios obtenerUsuarioxLogin(String login) throws ExcepcionesDAO;
	
}
