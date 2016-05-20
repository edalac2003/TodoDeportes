package com.tododeportes.backend.ngc.impl;

import com.tododeportes.backend.dao.UsuariosDAO;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.ngc.UsuariosNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class UsuariosNGCImpl implements UsuariosNGC {
	
	UsuariosDAO usuariosDao;
	
	ExcepcionesNGC expNgc;
	
	/**
	 * @param usuariosDao the usuariosDao to set
	 */
	public void setUsuariosDao(UsuariosDAO usuariosDao) {
		this.usuariosDao = usuariosDao;
	}

	@Override
	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesNGC {
		TbUsuarios tbUsuario = null;
		if(usuario.getLogin() != null && !usuario.getLogin().isEmpty()){
			if(usuario.getPassword() != null && !usuario.getPassword().isEmpty()){
				try {
					tbUsuario = usuariosDao.obtenerUsuarioxLogin(usuario.getLogin());
					if(tbUsuario == null)
						usuariosDao.guardarUsuario(usuario);
					else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("No es posible guardar el Registro porque el usuario ya Existe.");
						throw expNgc;
					}
						
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}
			}
		}
	}

	@Override
	public TbUsuarios obtenerUsuarioxLogin(String login) throws ExcepcionesNGC {
		TbUsuarios tbUsuario = null;
		try {
			tbUsuario = usuariosDao.obtenerUsuarioxLogin(login);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return tbUsuario;
	}

	@Override
	public boolean validarUsuario(String login, String password) throws ExcepcionesNGC {
		TbUsuarios usuario = null;
		boolean validar = false;
		
		try {
			usuario = usuariosDao.obtenerUsuarioxLogin(login);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		if(usuario != null){
			if(usuario.getPassword().equals(password))
				validar = true;
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No se Encontró el usuario.");
			throw expNgc;
		}
		
		return validar;
	}

}
