package com.tododeportes.backend.dto.maestros;

import java.util.Date;

public class MaestroReservas {
	
	private String login;
	private Date fechaReserva;
	private Date horaInicio;
	private Date horaFin;
	private Long valorHora;
	private Integer tiempo;
	private Integer idCancha;
	/**
	 * 
	 */
	public MaestroReservas() {
		super();
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the fechaReserva
	 */
	public Date getFechaReserva() {
		return fechaReserva;
	}
	/**
	 * @param fechaReserva the fechaReserva to set
	 */
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	/**
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}
	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public Date getHoraFin() {
		return horaFin;
	}
	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	/**
	 * @return the valorHora
	 */
	public Long getValorHora() {
		return valorHora;
	}
	/**
	 * @param valorHora the valorHora to set
	 */
	public void setValorHora(Long valorHora) {
		this.valorHora = valorHora;
	}
	/**
	 * @return the tiempo
	 */
	public Integer getTiempo() {
		return tiempo;
	}
	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	/**
	 * @return the idCancha
	 */
	public Integer getIdCancha() {
		return idCancha;
	}
	/**
	 * @param idCancha the idCancha to set
	 */
	public void setIdCancha(Integer idCancha) {
		this.idCancha = idCancha;
	}	
}
