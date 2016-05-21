package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.CanchasDAO;
import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dao.UnidadDeportivaDAO;
import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.dto.maestros.MaestroCanchaxUnidad;
import com.tododeportes.backend.dto.maestros.MaestroUnidadDeportiva;
import com.tododeportes.backend.ngc.UnidadDeportivaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class UnidadDeportivaNGCImpl implements UnidadDeportivaNGC {

	ExcepcionesNGC expNgc;
	List<TbUnidadesDeportivas> lista;
	UnidadDeportivaDAO unidadDeportivaDao;	
	UbicacionDAO ubicacionDao;
	CanchasDAO canchaDao;
	
	String mensajeError;	

	public void setUnidadDeportivaDao(UnidadDeportivaDAO unidadDeportivaDao) {
		this.unidadDeportivaDao = unidadDeportivaDao;
	}
	public void setUbicacionDao(UbicacionDAO ubicacionDao) {
		this.ubicacionDao = ubicacionDao;
	}
	public void setCanchaDao(CanchasDAO canchaDao) {
		this.canchaDao = canchaDao;
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
	public void guardarCanchaxUnidad(MaestroCanchaxUnidad maestroCanchaxUnidad) throws ExcepcionesNGC {
		MaestroCanchas maestroCancha = null;
		MaestroUnidadDeportiva maestroUnidad = null;
		TbCanchas cancha = null;
		TbUnidadesDeportivas unidad = null;
		
		if(maestroCanchaxUnidad != null){
			try{
				//Se comprueba que el campo IdCancha se valido para buscar la cancha asociada
				if(maestroCanchaxUnidad.getIdCancha()>0){
					cancha = canchaDao.obtenerCanchaxId(maestroCanchaxUnidad.getIdCancha());
				}else{
					//En caso que el campo no sea valido se comprueba si hay datos para una cancha es nueva
					if(maestroCanchaxUnidad.getCancha() != null){
						maestroCancha = maestroCanchaxUnidad.getCancha();
					}
				}
				
				if(maestroCanchaxUnidad.getIdUnidadDeportiva() > 0){
					unidad = unidadDeportivaDao.obtenerUnidadDeportivaxId(maestroCanchaxUnidad.getIdUnidadDeportiva());
					if (unidad == null){
						
					}
				}else{
					if(maestroCanchaxUnidad.getUnidadDeportiva() != null){
						maestroUnidad = maestroCanchaxUnidad.getUnidadDeportiva();
					}
				}
			}catch(ExcepcionesDAO e){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}			
		}else{
			
		}
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