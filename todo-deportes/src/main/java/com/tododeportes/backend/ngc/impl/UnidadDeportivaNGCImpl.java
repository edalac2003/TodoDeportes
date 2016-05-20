package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dao.UnidadDeportivaDAO;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.dto.maestros.MaestroUnidadDeportiva;
import com.tododeportes.backend.ngc.UnidadDeportivaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class UnidadDeportivaNGCImpl implements UnidadDeportivaNGC {

	ExcepcionesNGC expNgc;
	List<TbUnidadesDeportivas> lista;
	UnidadDeportivaDAO unidadDeportivaDao;
	
	UbicacionDAO ubicacionDao;
	
	String mensajeError;
	
	/**
	 * @param ubicacionDao the ubicacionDao to set
	 */
	public void setUbicacionDao(UbicacionDAO ubicacionDao) {
		this.ubicacionDao = ubicacionDao;
	}
	

	/**
	 * @param unidadDeportivaDao the unidadDeportivaDao to set
	 */
	public void setUnidadDeportivaDao(UnidadDeportivaDAO unidadDeportivaDao) {
		this.unidadDeportivaDao = unidadDeportivaDao;
	}

	
	@Override
	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesNGC {
		lista = null;
		
		try {
			lista = unidadDeportivaDao.listarUnidadesDeportivas();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return lista;
	}

	@Override
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(Long idLocalidad) throws ExcepcionesNGC {
		lista = null;
		TbLocalidades localidad = null;
		
		if(idLocalidad > 0){
			try {
				localidad = ubicacionDao.obtenerLocalidad(idLocalidad.intValue());
				if(localidad != null){
					lista = unidadDeportivaDao.listarUnidadDeportivaxLocalidad(localidad);
				}else{
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("No se encontro registro de localidad con el ID suministrado.");
					throw expNgc;
				}
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}			
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Ingrese un ID valido.");
			throw expNgc;
		}
		
		return lista;
	}
	

	@Override
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id) throws ExcepcionesNGC {
		TbUnidadesDeportivas unidadDeportiva = null;
				
		if(id > 0){
			try {
				unidadDeportiva = unidadDeportivaDao.obtenerUnidadDeportivaxId(id);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Ingrese un ID valido.");
			throw expNgc;
		}		
		
		return unidadDeportiva;
	}
	

	@Override
	public void guardarUnidadDeportiva(MaestroUnidadDeportiva maestroUnidadDeportiva) throws ExcepcionesNGC {
		TbUnidadesDeportivas unidadDeportiva = null;;
		TbLocalidades localidad = null;		
		
		if(maestroUnidadDeportiva != null){
			mensajeError = validarUnidadDeportiva(maestroUnidadDeportiva);
			if(mensajeError.isEmpty()){
				try {
					localidad = ubicacionDao.obtenerLocalidad(maestroUnidadDeportiva.getIdLocalidad().intValue());
					if (localidad != null){
						unidadDeportiva = new TbUnidadesDeportivas();
						unidadDeportiva.setNombre(maestroUnidadDeportiva.getNombre());
						unidadDeportiva.setLocalidad(localidad);
						unidadDeportiva.setDireccion(maestroUnidadDeportiva.getDireccion());
						unidadDeportiva.setTelefono(maestroUnidadDeportiva.getTelefono());
						unidadDeportiva.setContacto(maestroUnidadDeportiva.getContacto());
						unidadDeportivaDao.guardarUnidadDeportiva(unidadDeportiva);
						
					}else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("No se encontro una Localidad asociada al ID suministrado.");
						throw expNgc;
					}
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}				
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("Debe diligenciar los siguientes datos: <br>"+mensajeError);
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No Existen registros para Guardar.");
			throw expNgc;
		}
	}
	
		

	@Override
	public List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(Long idUnidadDeportiva)
			throws ExcepcionesNGC {
		List<TbCanchasxunidadDeportiva> lista = null;
		TbUnidadesDeportivas unidadDeportiva = null;
		if(idUnidadDeportiva > 0){
			try {
				unidadDeportiva = unidadDeportivaDao.obtenerUnidadDeportivaxId(idUnidadDeportiva.intValue());
				if(unidadDeportiva != null){
					lista = unidadDeportivaDao.listarCanchaxUnidadDeportiva(unidadDeportiva);					
				}else{
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("No Existen registros de unidad deportiva asociado al ID.");
					throw expNgc;
				}
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("Ingrese un ID de Unidad Deportiva válido.");
			throw expNgc;
		}
		
		return lista;
	}
	
	
	private String validarUnidadDeportiva(MaestroUnidadDeportiva unidadDeportiva){
		StringBuilder mensaje = new StringBuilder();
		
		if(unidadDeportiva.getNombre() == null || unidadDeportiva.getNombre().isEmpty())
			mensaje.append("Nombre de Unidad Deportiva. <br>");
		if(unidadDeportiva.getIdLocalidad() == null || unidadDeportiva.getIdLocalidad() <= 0)
			mensaje.append("ID Localidad. <br>");		
		
		return mensaje.toString();
	}

}
