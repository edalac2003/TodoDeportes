package com.tododeportes.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.maestros.MaestroReservas;
import com.tododeportes.backend.ngc.ReservaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/reserva")
public class ReservaService {
	
	@Autowired
	ReservaNGC reservaNGC;

	@RequestMapping(value="/guardarReserva", method=RequestMethod.POST)
	public void guardarReserva(@RequestBody MaestroReservas reserva){
		try {
			reservaNGC.guardarReserva(reserva);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	};
	
	@RequestMapping(value="/reservasxUsuario", method=RequestMethod.GET)
	public @ResponseBody List<TbReservas> reservasxUsuario(@RequestParam(value="login")String login){
		List<TbReservas> lista = new ArrayList<>();
		
		try {
			lista = reservaNGC.obtenerReservaxUsuario(login);
		} catch (ExcepcionesNGC e) {
			lista.add(new TbReservas(e.getMensajeUsuario()));
		}
		
		return lista;
	}
	
	@RequestMapping(value="/reservasxUsuario", method=RequestMethod.GET)
	public @ResponseBody List<TbReservas> reservasxCancha(@RequestParam(value="id")int id){
		List<TbReservas> lista = new ArrayList<>();
		
		try {
			lista = reservaNGC.listarReservasxCancha(id);
		} catch (ExcepcionesNGC e) {
			lista.add(new TbReservas(e.getMensajeUsuario()));
		}
		
		return lista;
	}
}
