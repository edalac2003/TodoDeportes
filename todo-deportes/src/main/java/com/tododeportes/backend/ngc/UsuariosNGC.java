package com.tododeportes.backend.ngc;

import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UsuariosNGC {

	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesNGC;
	
	public void actualizarUsuario(TbUsuarios usuario) throws ExcepcionesNGC;
	
	public void obtenerUsuarioxLogin(String login) throws ExcepcionesNGC;
	
	public void obtenerUsuarioxPersona(String numeroDocumento) throws ExcepcionesNGC;
}
