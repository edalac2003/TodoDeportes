package com.tododeportes.backend.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import com.tododeportes.backend.dao.CanchasDAO;
import com.tododeportes.backend.dao.ReservaDAO;
import com.tododeportes.backend.dao.UnidadDeportivaDAO;
import com.tododeportes.backend.dao.UsuariosDAO;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbEstados;
import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.dto.maestros.MaestroReservas;
import com.tododeportes.backend.ngc.ReservaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class ReservaNGCImpl implements ReservaNGC {

	ExcepcionesNGC expNgc;
	ReservaDAO reservaDao;
	UsuariosDAO usuarioDao;
	CanchasDAO canchaDao;
	UnidadDeportivaDAO unidadDeportivaDao;
	
	/**
	 * @param reservaDao the reservaDao to set
	 */
	public void setReservaDao(ReservaDAO reservaDao) {
		this.reservaDao = reservaDao;
	}

	/**
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuariosDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/**
	 * @param canchaDao the canchaDao to set
	 */
	public void setCanchaDao(CanchasDAO canchaDao) {
		this.canchaDao = canchaDao;
	}

	/**
	 * @param unidadDeportivaDao the unidadDeportivaDao to set
	 */
	public void setUnidadDeportivaDao(UnidadDeportivaDAO unidadDeportivaDao) {
		this.unidadDeportivaDao = unidadDeportivaDao;
	}

	@Override
	public TbReservas guardarReserva(MaestroReservas maestroReserva) throws ExcepcionesNGC {
		TbReservas reserva = new TbReservas();
		TbCanchasxunidadDeportiva cancha = null;
		TbUsuarios usuario = null;
		
		if(maestroReserva != null){
			String mensajeError = validarMaestroReserva(maestroReserva);
			if(mensajeError.isEmpty()){
				try {
					usuario = usuarioDao.obtenerUsuarioxLogin(maestroReserva.getLogin());
					if(usuario != null){
						cancha = canchaDao.obtenerCanchaxUnidadDeportiva(maestroReserva.getIdCancha());
						if(cancha != null){
							reserva.setFecha(maestroReserva.getFechaReserva());
							reserva.setHoraInicio(maestroReserva.getHoraInicio());
							reserva.setHoraFin(maestroReserva.getHoraFin());
							reserva.setTiempo(maestroReserva.getTiempo());
							reserva.setTbCanchasxunidadDeportiva(cancha);
							reserva.setTbUsuarios(usuario);
							reserva.setValor(maestroReserva.getValorHora());
							reserva.setTbEstados(new TbEstados(4));
							reservaDao.guardarReserva(reserva);
						}else{							
							expNgc = new ExcepcionesNGC();
							expNgc.setMensajeUsuario("No se encuentra una cancha asociada al ID suministrado.");
							reserva.setMensajeError(expNgc.getMensajeUsuario());
							throw expNgc;
						}
					}else{
						expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("No se encuentra un Usuario asociado al Login suministrado.");
						reserva.setMensajeError(expNgc.getMensajeUsuario());
						throw expNgc;
					}					
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					reserva.setMensajeError(expNgc.getMensajeUsuario());
					throw expNgc;
				}
				
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(mensajeError);
				reserva.setMensajeError(mensajeError);
				throw expNgc;
			}
			
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible guardar el registro. No hay registros para guardar.");
			reserva.setMensajeError(expNgc.getMensajeUsuario());
			throw expNgc;
		}
		
		return reserva;
	}

	
	@Override
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesNGC {
		TbReservas reserva = new TbReservas();		
		if(id > 0){
			try {
				reserva = reservaDao.obtenerReservaxId(id);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				reserva.setMensajeError(expNgc.getMensajeUsuario());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. El ID debe ser mayor que cero.");
			reserva.setMensajeError(expNgc.getMensajeUsuario());
			throw expNgc;
		}
		
		return reserva;
	}

	
	@Override
	public List<TbReservas> obtenerReservaxUsuario(String login) throws ExcepcionesNGC {
		List<TbReservas> lista = null;
		TbUsuarios usuario = new TbUsuarios();
		
		if(login != null && !login.isEmpty()){
			try {
				usuario = usuarioDao.obtenerUsuarioxLogin(login);
				if (usuario != null){
					lista = reservaDao.obtenerReservaxUsuario(usuario);
				}else{
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("No es posible realizar la consulta. El Login no Existe.");
					lista = new ArrayList<>();
					lista.add(new TbReservas(expNgc.getMensajeUsuario()));
					throw expNgc;
				}				
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				lista = new ArrayList<>();
				lista.add(new TbReservas(expNgc.getMensajeUsuario()));
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. El Login no puede ser NULL o Vacio.");
			lista=new ArrayList<>();
			lista.add(new TbReservas(expNgc.getMensajeUsuario()));
			throw expNgc;
		}		
		return lista;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.tododeportes.backend.ngc.ReservaNGC#listarReservasxCancha(com.tododeportes.backend.dto.TbCanchasxunidadDeportiva)
	 */
	@Override
	public List<TbReservas> listarReservasxCancha(int idCancha) throws ExcepcionesNGC {
		List<TbReservas> lista = null;
		TbCanchasxunidadDeportiva cancha = null;
		
		if(idCancha > 0){
			try {
				cancha = canchaDao.obtenerCanchaxUnidadDeportiva(idCancha);
				if(cancha != null){
					lista = reservaDao.listarReservasxCancha(cancha);					
				}else{
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("No se encuentra una Cancha asociada al ID suministrado.");
					lista=new ArrayList<>();
					lista.add(new TbReservas(expNgc.getMensajeUsuario()));
					throw expNgc;
				}
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				lista=new ArrayList<>();
				lista.add(new TbReservas(expNgc.getMensajeUsuario()));
				throw expNgc;
			}			
		}else{
			
		}
		return lista;
	}

	
	private String validarMaestroReserva(MaestroReservas maestroReserva){
		StringBuilder mensaje = new StringBuilder();
		if(maestroReserva.getLogin() == null || maestroReserva.getLogin().isEmpty())
			mensaje.append("El login es vacio o NuLL. <br>");
		if(maestroReserva.getIdCancha() < 0 || maestroReserva.getIdCancha().toString().isEmpty())
			mensaje.append("El ID de la cancha debe ser mayor que cero. <br>");
		if(maestroReserva.getFechaReserva() == null || maestroReserva.getFechaReserva().toString().isEmpty())
			mensaje.append("La Fecha de la Reserva no debe ser vacio o NuLL. <br>");
		if(maestroReserva.getHoraInicio() == null || maestroReserva.getHoraInicio().toString().isEmpty())
			mensaje.append("La Hora de Inicio de la Reserva no debe ser vacio o NuLL. <br>");
		if(maestroReserva.getHoraFin() == null || maestroReserva.getHoraFin().toString().isEmpty())
			mensaje.append("La Hora de Fin de la Reserva no debe ser vacio o NuLL. <br>");		
		
		return mensaje.toString();
	}

}
