package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface PersonaNGC {
	
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesNGC;
	
	public List<TbPersonas> listaPersonas() throws ExcepcionesNGC;

}
