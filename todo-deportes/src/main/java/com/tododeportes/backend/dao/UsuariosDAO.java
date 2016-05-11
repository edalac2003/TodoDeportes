package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface UsuariosDAO {

	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public TbUsuarios obtenerUsuarioxLogin(String login) throws ExcepcionesDAO;
	
	public List<TbUsuarios> obtenerUsuarioxPersona(TbPersonas persona) throws ExcepcionesDAO;
}
