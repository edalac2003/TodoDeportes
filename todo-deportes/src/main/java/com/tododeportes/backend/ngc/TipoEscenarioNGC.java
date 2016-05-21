package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface TipoEscenarioNGC {

	public TbTipoEscenario obtenerTipoEscenario(int id) throws ExcepcionesNGC;
	
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesNGC;
	
}
