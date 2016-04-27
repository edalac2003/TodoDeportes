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
	public void guardarPersona(TbPersonas persona) throws ExcepcionesNGC {
		if(persona == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Persona no puede ser Null.");
			throw expNgc;
		}
		
		if(persona.getTbCiudades() == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("La Ciudad de la Persona no puede ser Null.");
			throw expNgc;
		}
		if(persona.getTbTiposDocumento() == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Tipo de Documento de la Persona no puede ser Null.");
			throw expNgc;
		}
		
		if((persona.getNumeroDocumento() == null) || (persona.getApellidos() == null) || (persona.getApellidos() == null)){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("Se requieren datos importantes de la persona que no puede ser Null.");
			throw expNgc;
		}
		
		//Se comprueba que el registro de persona NO EXISTA.
		TbPersonas existePersona = obtenerPersonaxDocumento(persona.getNumeroDocumento());
		
		if(existePersona != null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("La Persona que desea guardar ya EXISTE en la Base de Datos.");
			throw expNgc;
		}
		
		try {
			personaDao.guardarPersona(persona);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
	}



	@Override
	public void actualizarPersona(TbPersonas persona) throws ExcepcionesNGC {
		if(persona == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Persona no puede ser Null.");
			throw expNgc;
		}
		
		if(persona.getTbCiudades() == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("La Ciudad de la Persona no puede ser Null.");
			throw expNgc;
		}
		if(persona.getTbTiposDocumento() == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Tipo de Documento de la Persona no puede ser Null.");
			throw expNgc;
		}
		
		if((persona.getNumeroDocumento() == null) || (persona.getApellidos() == null) || (persona.getApellidos() == null)){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("Se requieren datos importantes de la persona que no puede ser Null.");
			throw expNgc;
		}
		
		//Se comprueba que el registro de persona EXISTA.
		TbPersonas existePersona = obtenerPersonaxDocumento(persona.getNumeroDocumento());
		
		if(existePersona == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("La Persona que desea guardar NO EXISTE en la Base de Datos.");
			throw expNgc;
		}
		
		try {
			personaDao.actualizarPersona(persona);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
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
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id Documento no es v&aacutelido.");
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
