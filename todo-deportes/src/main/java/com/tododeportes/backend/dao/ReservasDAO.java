package com.tododeportes.backend.dao;

import java.util.Date;
import java.util.List;

import com.tododeportes.backend.dto.TbEstados;
import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface ReservasDAO {

	public void guardarReserva(TbReservas reserva) throws ExcepcionesDAO;
	
	public void actualizarReserva(TbReservas reserva) throws ExcepcionesDAO;
	
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesDAO;
	
	public TbReservas obtenerReservaxUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public List<TbReservas> listarReservasxFechaxEstado(Date fechaInicio, Date fechaFin, TbEstados estado) throws ExcepcionesDAO;
}
