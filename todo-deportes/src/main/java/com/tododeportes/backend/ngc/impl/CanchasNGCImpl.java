package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.CanchasDAO;
import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.ngc.CanchaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class CanchasNGCImpl implements CanchaNGC {

	ExcepcionesNGC expNgc;
	
	CanchasDAO canchaDao;
	
	public void setCanchaDao(CanchasDAO canchaDao) {
		this.canchaDao = canchaDao;
	}

	@Override
	public void guardarCancha(TbCanchas cancha) throws ExcepcionesNGC {
		if(cancha == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha no puede ser Null.");
			throw expNgc;
		}
		
		if((cancha.getTbTipoEscenario() == null) || (cancha.getTbTiposDeporte() == null)){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha contiene campos que no pueden ser Null.");
			throw expNgc;
		}
		
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
	public void actualizarCancha(TbCanchas cancha) throws ExcepcionesNGC {
		if((cancha == null) || (cancha.getIdcancha() <= 0)){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha no puede ser Null.");
			throw expNgc;
		}
		
		if((cancha.getTbTipoEscenario() == null) || (cancha.getTbTiposDeporte() == null)){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha contiene campos que no pueden ser Null.");
			throw expNgc;
		}
		
		TbCanchas existeCancha = obtenerCanchaxId(cancha.getIdcancha());
		if(existeCancha == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Registro de la Cancha NO EXISTE en la Base de Datos.");
			throw expNgc;
		}
		
		
		try {
			canchaDao.actualizarCancha(cancha);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
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
			throw expNgc;
		}
		
		return listaCanchas;
	}

	@Override
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesNGC {
		List<TbTiposDeporte> listaTipoDeporte = null;
		
		try {
			listaTipoDeporte = canchaDao.listarTipoDeporte();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoDeporte;
	}

	@Override
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesNGC {
		List<TbTipoEscenario> listaTipoEscenarios = null;
		
		try {
			listaTipoEscenarios = canchaDao.listarTipoEscenario();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoEscenarios;
	}

}
