package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface UbicacionDAO {
	
	public TbDepartamentos obtenerDepartamento(int idDepartamento) throws ExcepcionesDAO;
	
	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO;
	
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesDAO;
	
	public List<TbDepartamentos> listarDepartamentos() throws ExcepcionesDAO;
	
	public List<TbCiudades> listarCiudades() throws ExcepcionesDAO; 
	
	public List<TbCiudades> listarCiudadesxDepartamento(TbDepartamentos departamento) throws ExcepcionesDAO;
	
	public List<TbLocalidades> listarLocalidades() throws ExcepcionesDAO;
	
	public List<TbLocalidades> listarLocalidadesxCiudad(TbCiudades ciudad) throws ExcepcionesDAO;

}
