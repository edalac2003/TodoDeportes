package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface CanchaNGC {

	public void guardarCancha(MaestroCanchas cancha) throws ExcepcionesNGC;
	
	public void actualizarCancha(MaestroCanchas cancha) throws ExcepcionesNGC;
	
	public TbCanchas obtenerCanchaxId(int id) throws ExcepcionesNGC;
	
	public List<TbCanchas> listarCanchasxTipoDeporte(String nombreDeporte) throws ExcepcionesNGC;
	
	public List<TbCanchas> listarCanchasxTipoEscenario(String nombreEscenario) throws ExcepcionesNGC;	
	
	public List<TbCanchas> listarCanchasTodas() throws ExcepcionesNGC;
	
}
