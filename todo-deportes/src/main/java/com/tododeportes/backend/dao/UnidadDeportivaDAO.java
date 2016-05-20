package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface UnidadDeportivaDAO {

	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesDAO;
	
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(TbLocalidades localidad) throws ExcepcionesDAO;
	
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id)  throws ExcepcionesDAO;
	
	public void guardarUnidadDeportiva(TbUnidadesDeportivas unidadDeportiva) throws ExcepcionesDAO;
	
	public List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(TbUnidadesDeportivas unidadDeportiva) throws ExcepcionesDAO;
	
	
}
