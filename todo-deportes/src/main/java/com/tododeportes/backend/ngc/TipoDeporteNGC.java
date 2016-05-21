package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface TipoDeporteNGC {

	public TbTiposDeporte obtenerTipoDeporte(int id) throws ExcepcionesNGC;
	
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesNGC;
	
}
