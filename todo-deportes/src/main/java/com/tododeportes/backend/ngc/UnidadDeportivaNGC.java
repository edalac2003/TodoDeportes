package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.dto.maestros.MaestroUnidadDeportiva;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UnidadDeportivaNGC {

	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesNGC;
	
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(Long idLocalidad) throws ExcepcionesNGC;
	
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id)  throws ExcepcionesNGC;
	
	public void guardarUnidadDeportiva(MaestroUnidadDeportiva unidadDeportiva) throws ExcepcionesNGC;
	
	public List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(Long idUnidadDeportiva) throws ExcepcionesNGC;
	
}
