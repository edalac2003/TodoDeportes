package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.PersonaDAO;
import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.ngc.PersonaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class PersonaNGCImpl implements PersonaNGC {
	
	ExcepcionesNGC expNgc;
	
	PersonaDAO personaDao;
	

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	@Override
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesNGC {
		TbPersonas persona = null;
		
		if(!idDocumento.isEmpty()){
			try {
				persona = personaDao.obtenerPersonaxDocumento(idDocumento);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id Documento no es válido.");
			throw expNgc;			
		}
		
		return persona;
	}

	@Override
	public List<TbPersonas> listaPersonas() throws ExcepcionesNGC {
		List<TbPersonas> listaPersonas = null;
		
		try {
			listaPersonas = personaDao.listarTodasPersonas();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaPersonas;
	}

}
