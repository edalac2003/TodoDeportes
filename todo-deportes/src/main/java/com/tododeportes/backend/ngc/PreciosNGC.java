package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbPreciosCancha;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface PreciosNGC {
	
	public double obtenerPrecio(String fechaInicio) throws ExcepcionesNGC;
	
	public double obtenerPrecio(String diaSemana, String horaInicio, String horaFin) throws ExcepcionesNGC;
	
	public void guardarPrecio(TbPreciosCancha precio) throws ExcepcionesNGC;
	
	public List<TbPreciosCancha> listarRegistrosPrecios() throws ExcepcionesNGC;
	
	public TbPreciosCancha obtenerRegistroPrecio(int id) throws ExcepcionesNGC;
}
