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
	public TbDepartamentos obtenerDepartamento(int idDepartamento) throws ExcepcionesNGC {
		TbDepartamentos departamento = null;
		
		if(idDepartamento <= 0){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id del Departamento no es v&aacutelido.");
			throw expNgc;
		}
		
		try {
			departamento = ubicacionDao.obtenerDepartamento(idDepartamento);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			System.out.println(e.getMensajeTecnico() +"  Error: "+ e.getMessage()+ "-- Producido por: "+e.getCause());
			throw expNgc;
		}		
		
		return departamento;
	}


	@Override
	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesNGC {
		TbCiudades ciudad = null;
		
		try {
			ciudad = ubicacionDao.obtenerCiudad(idCiudad);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return ciudad;
	}

	
	@Override
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesNGC {
		TbLocalidades localidad = null;
		
		try {
			localidad = ubicacionDao.obtenerLocalidad(idLocalidad);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return localidad;
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
			System.out.println(e.getMensajeTecnico() +"  Error: "+ e.getMessage()+ "-- Producido por: "+e.getCause());
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

	
	@Override
	public List<TbCiudades> listarCiudadesxDepartamento(int idDepartamento) throws ExcepcionesNGC {
		List<TbCiudades> listaCiudad = null;
		
		if(idDepartamento <= 0){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id Documento no es v&aacutelido.");
			throw expNgc;
		}
		
		TbDepartamentos departamento = obtenerDepartamento(idDepartamento);
		if(departamento == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Departamento no Existe en la Base de Datos.");
			throw expNgc;
		}
		
		try {
			listaCiudad = ubicacionDao.listarCiudadesxDepartamento(departamento);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaCiudad;
	}

	@Override
	public List<TbLocalidades> listarLocalidadesxCiudad(int idCiudad) throws ExcepcionesNGC {
		List<TbLocalidades> listaLocalidades = null;
		
		if(idCiudad <= 0){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque el Id de Ciudad no es v&aacutelido.");
			throw expNgc;
		}
		
		TbCiudades ciudad = obtenerCiudad(idCiudad);
		if(ciudad == null){
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta porque la Ciudad no Existe en la Base de Datos.");
			throw expNgc;
		}
		
		
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
