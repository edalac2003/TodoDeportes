package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface ReservaDAO {

	public void guardarReserva(TbReservas reserva) throws ExcepcionesDAO;
	
	public void actualizarReserva(TbReservas reserva) throws ExcepcionesDAO;
	
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesDAO;
	
	public List<TbReservas> obtenerReservaxUsuario(TbUsuarios usuario) throws ExcepcionesDAO;
	
	public List<TbReservas> listarReservasxCancha(TbCanchasxunidadDeportiva cancha) throws ExcepcionesDAO;
}
