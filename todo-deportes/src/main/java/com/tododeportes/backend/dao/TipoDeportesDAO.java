package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface TipoDeportesDAO {

	public TbTiposDeporte obtenerTipoDeporte(int id) throws ExcepcionesDAO;
	
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesDAO;
	
	
}
