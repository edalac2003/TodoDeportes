package com.tododeportes.backend.ngc;

import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UsuariosNGC {

	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesNGC;
	
	public TbUsuarios obtenerUsuarioxLogin(String login) throws ExcepcionesNGC;
	
	public boolean validarUsuario(String login, String password) throws ExcepcionesNGC;
}
