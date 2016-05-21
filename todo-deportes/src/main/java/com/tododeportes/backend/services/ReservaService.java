package com.tododeportes.backend.services;

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

@RestController
@RequestMapping("/reserva")
public class ReservaService {
	
	@Autowired
	ReservaNGC reservaNGC;

	@RequestMapping(value="/guardarReserva", method=RequestMethod.POST)
	public void guardarReserva(@RequestBody MaestroReservas reserva)throws Exception{
		reservaNGC.guardarReserva(reserva);
	};
	
	@RequestMapping(value="/reservasxUsuario", method=RequestMethod.GET)
	public @ResponseBody List<TbReservas> reservasxUsuario(@RequestParam(value="login")String login) throws Exception{
		return reservaNGC.obtenerReservaxUsuario(login);
	}
	
	@RequestMapping(value="/reservasxCancha", method=RequestMethod.GET)
	public @ResponseBody List<TbReservas> reservasxCancha(@RequestParam(value="id")int id) throws Exception{
		return reservaNGC.listarReservasxCancha(id);
	}
}
