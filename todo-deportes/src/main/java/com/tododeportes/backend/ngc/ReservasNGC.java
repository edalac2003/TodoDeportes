package com.tododeportes.backend.ngc;

import java.util.List;

import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public interface ReservasNGC {

	public void guardarReserva(TbReservas reserva) throws ExcepcionesNGC;
	
	public void actualizarReserva(TbReservas reserva) throws ExcepcionesNGC;
	
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesNGC;
	
	public TbReservas obtenerReservaxUsuario(String login) throws ExcepcionesNGC;
	
	public List<TbReservas> listarReservasxFechaxEstado(String fechaInicio, String fechaFin, String estado) throws ExcepcionesNGC;
}
