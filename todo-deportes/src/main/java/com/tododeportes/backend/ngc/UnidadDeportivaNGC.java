package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.dto.maestros.MaestroCanchaxUnidad;
import com.tododeportes.backend.dto.maestros.MaestroUnidadDeportiva;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface UnidadDeportivaNGC {

	public void guardarUnidadDeportiva(MaestroUnidadDeportiva unidadDeportiva) throws ExcepcionesNGC;
	
	public void guardarCanchaxUnidad(MaestroCanchaxUnidad maestroCanchaxUnidad) throws ExcepcionesNGC;
	
	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesNGC;
		
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(Long idLocalidad) throws ExcepcionesNGC;
	
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id)  throws ExcepcionesNGC;
		
	public List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(int idUnidadDeportiva) throws ExcepcionesNGC;
	
}
