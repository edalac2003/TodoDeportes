package com.tododeportes.backend.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import com.tododeportes.backend.dao.PersonaDAO;
import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dao.UsuariosDAO;
import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbEstados;
import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbRoles;
import com.tododeportes.backend.dto.TbTiposDocumento;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.dto.maestros.MaestroPersona;
import com.tododeportes.backend.ngc.PersonaNGC;
import com.tododeportes.backend.ngc.UbicacionNGC;
import com.tododeportes.backend.ngc.UsuariosNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class PersonaNGCImpl implements PersonaNGC {
	
	ExcepcionesNGC expNgc;
	
	PersonaDAO personaDao;
	UsuariosNGC usuarioNGC;
	UbicacionNGC ubicacionNgc;;
	

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}
	public void setUsuarioNGC(UsuariosNGC usuarioNGC) {
		this.usuarioNGC = usuarioNGC;
	}
	public void setUbicacionNgc(UbicacionNGC ubicacionNgc) {
		this.ubicacionNgc = ubicacionNgc;
	}

	@Override
	public void guardarPersona(MaestroPersona maestroPersona) throws ExcepcionesNGC {
		TbPersonas persona = null;
		TbUsuarios usuario = null;
		TbTiposDocumento tipoDocumento = null;
		TbCiudades ciudad = null;
		
		if(maestroPersona == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Persona no puede ser Null.");
			persona = new TbPersonas(expNgc.getMensajeUsuario());
			throw expNgc;
		}		
		String mensajeError = validarMaestroPersona(maestroPersona);
		if(!mensajeError.isEmpty()){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("Se requiere información en los siguientes campos. <br>"+mensajeError);
			persona = new TbPersonas(expNgc.getMensajeUsuario());
			throw expNgc;
		}			
		try {
			tipoDocumento = personaDao.obtenerTipoDocumento(maestroPersona.getIdTipoDocumento());
			ciudad = ubicacionNgc.obtenerCiudad(maestroPersona.getIdCiudad());
			
			if(tipoDocumento== null){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se encuentra registro de Tipo Documento asociado al ID suministrado.");
				persona = new TbPersonas(expNgc.getMensajeUsuario());
				throw expNgc;
			}
			if(ciudad == null){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se encuentra registro de Ciudad asociado al ID suministrado.");
				persona = new TbPersonas(expNgc.getMensajeUsuario());
				throw expNgc;
			}			
			
			//Se comprueba si el registro de persona existe.
			persona = personaDao.obtenerPersonaxDocumento(maestroPersona.getNumeroDocumento());
			if(persona == null)
				persona = new TbPersonas();
			
			//Se comprueba si incorpora informacion de login.
			if (maestroPersona.getLogin() != null && !maestroPersona.getLogin().isEmpty()){
				usuario = usuarioNGC.obtenerUsuarioxLogin(maestroPersona.getLogin());
				if(usuario != null){
//					expNgc = new ExcepcionesNGC();
//					expNgc.setMensajeUsuario("No es posible guardar el registro porque el Login ya Existe.");
//					persona.setMensajeError(expNgc.getMensajeUsuario());
					return;
				}                                                        
			}		
			
			persona.setApellidos(maestroPersona.getApellidos());
			persona.setDireccion(maestroPersona.getDireccion());
			persona.setEmail(maestroPersona.getEmail());
			persona.setNombres(maestroPersona.getNombres());
			persona.setNumeroDocumento(maestroPersona.getNumeroDocumento());
			persona.setTelefonoCelular(maestroPersona.getTelefonoCelular());
			persona.setTelefonoFijo(maestroPersona.getTelefonoFijo());
			persona.setTbCiudades(ciudad);
			persona.setTbTiposDocumento(tipoDocumento);
			
			if(usuario == null && !maestroPersona.getLogin().isEmpty()){
				usuario = new TbUsuarios();
				usuario.setLogin(maestroPersona.getLogin());
				usuario.setPassword(maestroPersona.getPassword());
				usuario.setTbEstados(new TbEstados(8));
				usuario.setTbRoles(new TbRoles(2));
				usuario.setTbPersonas(persona);
				personaDao.guardarPersona(persona, usuario);
			}else
				personaDao.guardarPersona(persona);
			
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			persona = new TbPersonas(expNgc.getMensajeUsuario());
			throw expNgc;
		}		
	}


	@Override
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesNGC {
		TbPersonas persona = new TbPersonas();
		
		if(!idDocumento.isEmpty()){
			try {
				persona = personaDao.obtenerPersonaxDocumento(idDocumento);
				if(persona == null)
					persona = new TbPersonas("No se encontró registro de Persona con el numero de Documento "+idDocumento);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				persona.setMensajeError(expNgc.getMensajeUsuario());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id Documento no es v&aacutelido.");
			persona.setMensajeError(expNgc.getMensajeUsuario());
			throw expNgc;			
		}
		
		return persona;
	}

	@Override
	public List<TbPersonas> listaPersonas() throws ExcepcionesNGC {
		List<TbPersonas> listaPersonas = null;
		
		try {
			listaPersonas = personaDao.listarTodasPersonas();
			if(listaPersonas == null){
				listaPersonas = new ArrayList<>();
				listaPersonas.add(new TbPersonas("No se encontraron Registros en la Base de Datos."));
			}				
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			listaPersonas = new ArrayList<>();
			listaPersonas.add(new TbPersonas(expNgc.getMensajeUsuario()));
			throw expNgc;
		}
		
		return listaPersonas;
	}


	/* (non-Javadoc)
	 * @see com.tododeportes.backend.ngc.PersonaNGC#listarTipoDocumento()
	 */
	@Override
	public List<TbTiposDocumento> listarTipoDocumento() throws ExcepcionesNGC {
		List<TbTiposDocumento> lista = null;
		
		try {
			lista = personaDao.listarTipoDocumento();
			if(lista == null){
				lista = new ArrayList<>();
				lista.add(new TbTiposDocumento("No se encontraron Registros."));
			}
		} catch (ExcepcionesDAO e) {expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			lista = new ArrayList<>();
			lista.add(new TbTiposDocumento(e.getMensajeUsuario()));
			throw expNgc;
		}
		
		return lista;
	}

	private String validarMaestroPersona(MaestroPersona maestro){
		StringBuilder mensaje = new StringBuilder();
		
		if(maestro.getIdCiudad() <= 0)
			mensaje.append("");
		if(maestro.getIdTipoDocumento() <= 0)
			mensaje.append("");
		if(maestro.getNumeroDocumento()==null || maestro.getNumeroDocumento().isEmpty())
			mensaje.append("");
		if(maestro.getNombres()==null || maestro.getNombres().isEmpty())
			mensaje.append("");
		if(maestro.getApellidos()== null || maestro.getApellidos().isEmpty())
			mensaje.append("");
		if(maestro.getEmail()==null || maestro.getEmail().isEmpty())
			mensaje.append("");
		return mensaje.toString();		
	}
	
}
