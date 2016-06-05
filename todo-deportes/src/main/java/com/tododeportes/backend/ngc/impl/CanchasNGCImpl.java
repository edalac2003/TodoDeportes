package com.tododeportes.backend.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import com.tododeportes.backend.dao.CanchasDAO;
import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.ngc.CanchaNGC;
import com.tododeportes.backend.ngc.TipoDeporteNGC;
import com.tododeportes.backend.ngc.TipoEscenarioNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class CanchasNGCImpl implements CanchaNGC {

	ExcepcionesNGC expNgc;
	private TbCanchas cancha;
	private TbTipoEscenario tipoEscenario;
	private TbTiposDeporte tipoDeporte;
	
	
	CanchasDAO canchaDao;
	TipoDeporteNGC tipoDeporteNgc;
	TipoEscenarioNGC tipoEscenarioNgc;
	
	public void setCanchaDao(CanchasDAO canchaDao) {
		this.canchaDao = canchaDao;
	}
	public void setTipoDeporteNgc(TipoDeporteNGC tipoDeporteNgc) {
		this.tipoDeporteNgc = tipoDeporteNgc;
	}

	public void setTipoEscenarioNgc(TipoEscenarioNGC tipoEscenarioNgc) {
		this.tipoEscenarioNgc = tipoEscenarioNgc;
	}


	/**
	 * GuardarCancha.
	 * Se recibe un objeto maestro con los ID's de las entidades relacionadas
	 */
	@Override
	public void guardarCancha(MaestroCanchas maestroCancha) throws ExcepcionesNGC {
		
		if(maestroCancha == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha no puede ser Null.");
			throw expNgc;
		}		
		if(maestroCancha.getTipoDeporte() != null){
			tipoDeporte = tipoDeporteNgc.obtenerTipoDeporte(maestroCancha.getTipoDeporte());
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Tipo de Deporte no pueden ser Null.");
			throw expNgc;
		}
		if(maestroCancha.getTipoEscenario() != null){
			tipoEscenario = tipoEscenarioNgc.obtenerTipoEscenario(maestroCancha.getTipoEscenario());
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Tipo de Escenario no pueden ser Null.");
			throw expNgc;
		}
		if(maestroCancha.getNombre() == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Nombre no pueden ser Null o vacio.");
			throw expNgc;
		}		
		
		cancha = new TbCanchas();
		cancha.setNombre(maestroCancha.getNombre());
		cancha.setTbTipoEscenario(tipoEscenario);
		cancha.setTbTiposDeporte(tipoDeporte);
			
		try {
			canchaDao.guardarCancha(cancha);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
	}

	@Override
	public void actualizarCancha(MaestroCanchas maestroCancha) throws ExcepcionesNGC {
		if(maestroCancha != null){
			if(maestroCancha.getIdCancha() > 0){
				try {
					cancha = canchaDao.obtenerCanchaxId(maestroCancha.getIdCancha());
					if(maestroCancha.getTipoDeporte() != null){
						tipoDeporte = tipoDeporteNgc.obtenerTipoDeporte(maestroCancha.getTipoDeporte());						
						cancha.setTbTiposDeporte(tipoDeporte!=null?tipoDeporte:cancha.getTbTiposDeporte());
					}else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("El Tipo de Deporte no pueden ser Null.");
						throw expNgc;
					}
					if(maestroCancha.getTipoEscenario() != null){
						tipoEscenario = tipoEscenarioNgc.obtenerTipoEscenario(maestroCancha.getTipoEscenario());
						cancha.setTbTipoEscenario(tipoEscenario!=null?tipoEscenario:cancha.getTbTipoEscenario());
					}else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("El Tipo de Escenario no pueden ser Null.");
						throw expNgc;
					}
					if(maestroCancha.getNombre() != null){
						cancha.setNombre(maestroCancha.getNombre()!=null || !maestroCancha.getNombre().isEmpty()?
								maestroCancha.getNombre():cancha.getNombre());
					}else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("El Nombre no pueden ser Null o vacio.");
						throw expNgc;
					}
					//Se realizan las validaciones y luego se actualiza el registro
					canchaDao.actualizarCancha(cancha);
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No es posible actualizar el registro. Ingrese un ID cancha v&aacute;lido.");
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible actualizar el registro porque es Null o esta vacio.");
			throw expNgc;
		}
	}

	
	@Override
	public TbCanchas obtenerCanchaxId(int id) throws ExcepcionesNGC {
		TbCanchas cancha = null;
		
		if(id <= 0){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id de la cancha no es v&aacutelido.");
			throw expNgc;
		}
		
		try {
			cancha = canchaDao.obtenerCanchaxId(id);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			cancha = new TbCanchas(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return cancha;
	}

	
	@Override
	public List<TbCanchas> listarCanchasxTipoDeporte(String nombreDeporte) throws ExcepcionesNGC {
		return null;
	}

	@Override
	public List<TbCanchas> listarCanchasxTipoEscenario(String nombreEscenario) throws ExcepcionesNGC {
		return null;
	}
	

	@Override
	public List<TbCanchas> listarCanchasTodas() throws ExcepcionesNGC {
		List<TbCanchas> listaCanchas = null;
		
		try {
			listaCanchas = canchaDao.listarCanchasTodas();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			listaCanchas = new ArrayList<>();
			listaCanchas.add(new TbCanchas(e.getMensajeUsuario()));
			throw expNgc;
		}
		
		return listaCanchas;
	}

}
