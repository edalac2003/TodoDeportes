package com.tododeportes.backend.dao;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface UsuariosDAO {

	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public void actualizarUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public void obtenerUsuarioxLogin(String login) throws ExcepcionesDAO;
	
	public void obtenerUsuarioxPersona(TbPersonas persona) throws ExcepcionesDAO;
}
