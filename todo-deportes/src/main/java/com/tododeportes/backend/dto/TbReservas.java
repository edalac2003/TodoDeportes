package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * TbReservas generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbReservas implements java.io.Serializable {

	private int idreserva;
	private TbCanchasxunidadDeportiva tbCanchasxunidadDeportiva;
	private Date fecha;
	private Date horaInicio;
	private Date horaFin;
	private TbUsuarios tbUsuarios;
	private Integer tiempo;
	private Long valor;
	private TbEstados tbEstados;

	private String mensajeError;
	
	/**
	 * Constructor
	 */
	public TbReservas() {
		super();
	}
	
	
	/**
	 * @param mensajeError
	 */
	public TbReservas(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}



	/**
	 * @return the idreserva
	 */
	public int getIdreserva() {
		return idreserva;
	}

	/**
	 * @param idreserva the idreserva to set
	 */
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	/**
	 * @return the tbCanchasxunidadDeportiva
	 */
	public TbCanchasxunidadDeportiva getTbCanchasxunidadDeportiva() {
		return tbCanchasxunidadDeportiva;
	}

	/**
	 * @param tbCanchasxunidadDeportiva the tbCanchasxunidadDeportiva to set
	 */
	public void setTbCanchasxunidadDeportiva(TbCanchasxunidadDeportiva tbCanchasxunidadDeportiva) {
		this.tbCanchasxunidadDeportiva = tbCanchasxunidadDeportiva;
	}

	

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the tbUsuarios
	 */
	public TbUsuarios getTbUsuarios() {
		return tbUsuarios;
	}

	/**
	 * @param tbUsuarios the tbUsuarios to set
	 */
	public void setTbUsuarios(TbUsuarios tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
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
	 * @return the valor
	 */
	public Long getValor() {
		return valor;
	}


	/**
	 * @param valor the valor to set
	 */
	public void setValor(Long valor) {
		this.valor = valor;
	}


	/**
	 * @return the tbEstados
	 */
	public TbEstados getTbEstados() {
		return tbEstados;
	}

	/**
	 * @param tbEstados the tbEstados to set
	 */
	public void setTbEstados(TbEstados tbEstados) {
		this.tbEstados = tbEstados;
	}


	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}


	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	
}
