package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface TipoEscenariosDAO {

	public TbTipoEscenario obtenerTipoEscenario(int id) throws ExcepcionesDAO;
	
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesDAO;
	
}
