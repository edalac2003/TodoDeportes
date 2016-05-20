package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.maestros.MaestroReservas;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface ReservaNGC {

	public TbReservas guardarReserva(MaestroReservas maestroReserva) throws ExcepcionesNGC;
	
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesNGC;
	
	public List<TbReservas> obtenerReservaxUsuario(String login) throws ExcepcionesNGC;
	
	public List<TbReservas> listarReservasxCancha(int idCancha) throws ExcepcionesNGC;
}
