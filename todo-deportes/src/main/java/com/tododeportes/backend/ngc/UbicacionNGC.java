package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UbicacionNGC {

	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesNGC;
	
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesNGC;
	
	public List<TbDepartamentos> listarDepartamentos() throws ExcepcionesNGC;
	
	public List<TbCiudades> listarCiudades() throws ExcepcionesNGC; 
	
	public List<TbLocalidades> listarLocalidades() throws ExcepcionesNGC;
}
