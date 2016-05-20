package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbTiposDocumento;
import com.tododeportes.backend.dto.maestros.MaestroPersona;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface PersonaNGC {
	
	public void guardarPersona(MaestroPersona persona) throws ExcepcionesNGC;
	
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesNGC;
	
	public List<TbPersonas> listaPersonas() throws ExcepcionesNGC;
	
	public List<TbTiposDocumento> listarTipoDocumento() throws ExcepcionesNGC;

}
