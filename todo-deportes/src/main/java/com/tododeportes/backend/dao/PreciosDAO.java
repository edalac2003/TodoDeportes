package com.tododeportes.backend.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.tododeportes.backend.dto.TbPreciosCancha;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface PreciosDAO {
	
	public double obtenerPrecio(Date fechaInicio) throws ExcepcionesDAO;
	
	public double obtenerPrecio(String diaSemana, Time horaInicio, Time horaFin) throws ExcepcionesDAO;
	
	public void guardarPrecio(TbPreciosCancha precio) throws ExcepcionesDAO;
	
	public List<TbPreciosCancha> listarRegistrosPrecios() throws ExcepcionesDAO;
	
	public TbPreciosCancha obtenerRegistroPrecio(int id) throws ExcepcionesDAO; 

}
