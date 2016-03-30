package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface PersonaDAO {
	
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesDAO;
	
	public List<TbPersonas> listarTodasPersonas() throws ExcepcionesDAO;
	

}
