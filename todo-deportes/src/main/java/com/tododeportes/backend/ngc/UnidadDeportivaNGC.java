package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UnidadDeportivaNGC {

	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesNGC;
	
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(String nombreLocalidad) throws ExcepcionesNGC;
	
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id) throws ExcepcionesNGC;
	
	public void guardarUnidadDeportiva(TbUnidadesDeportivas unidadDeportiva) throws ExcepcionesNGC;
}
