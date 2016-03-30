package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.ngc.UbicacionNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class UbicacionNGCImpl implements UbicacionNGC {

	ExcepcionesNGC expNgc;
	UbicacionDAO ubicacionDao;
	
	
	/**
	 * @param ubicacionDao the ubicacionDao to set
	 */
	public void setUbicacionDao(UbicacionDAO ubicacionDao) {
		this.ubicacionDao = ubicacionDao;
	}

	@Override
	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesNGC {
		return null;
	}

	@Override
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesNGC {
		return null;
	}

	@Override
	public List<TbDepartamentos> listarDepartamentos() throws ExcepcionesNGC {
		List<TbDepartamentos> listaDepartamentos = null;
		
		try {
			listaDepartamentos = ubicacionDao.listarDepartamentos();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaDepartamentos;
	}

	@Override
	public List<TbCiudades> listarCiudades() throws ExcepcionesNGC {
		List<TbCiudades> listaCiudades = null;
		
		try {
			listaCiudades = ubicacionDao.listarCiudades();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaCiudades;
	}

	@Override
	public List<TbLocalidades> listarLocalidades() throws ExcepcionesNGC {
		List<TbLocalidades> listaLocalidades = null;
		
		try {
			listaLocalidades = ubicacionDao.listarLocalidades();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaLocalidades;
	}
}
