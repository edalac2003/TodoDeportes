package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * TbCanchasxunidadDeportiva generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbCanchasxunidadDeportiva implements java.io.Serializable {

	private int idcanchaUnidad;
	private TbCanchas tbCanchas;
	private TbUnidadesDeportivas tbUnidadesDeportivas;
	private String nombre;
	private Date disponibleInicio;
	private Date disponibleFin;
	private TbEstados tbEstados;
	
	public TbCanchasxunidadDeportiva() {
	}

	public TbCanchasxunidadDeportiva(int idcanchaUnidad) {
		this.idcanchaUnidad = idcanchaUnidad;
	}

	public TbCanchasxunidadDeportiva(int idcanchaUnidad, TbCanchas tbCanchas, TbUnidadesDeportivas tbUnidadesDeportivas,
			String nombre, Date disponibleInicio, Date disponibleFin, TbEstados estado) {
		this.idcanchaUnidad = idcanchaUnidad;
		this.tbCanchas = tbCanchas;
		this.tbUnidadesDeportivas = tbUnidadesDeportivas;
		this.nombre = nombre;
		this.disponibleInicio = disponibleInicio;
		this.disponibleFin = disponibleFin;
		this.tbEstados = estado;
	}

	/**
	 * @return the idcanchaUnidad
	 */
	public int getIdcanchaUnidad() {
		return idcanchaUnidad;
	}

	/**
	 * @param idcanchaUnidad the idcanchaUnidad to set
	 */
	public void setIdcanchaUnidad(int idcanchaUnidad) {
		this.idcanchaUnidad = idcanchaUnidad;
	}

	/**
	 * @return the tbCanchas
	 */
	public TbCanchas getTbCanchas() {
		return tbCanchas;
	}

	/**
	 * @param tbCanchas the tbCanchas to set
	 */
	public void setTbCanchas(TbCanchas tbCanchas) {
		this.tbCanchas = tbCanchas;
	}

	/**
	 * @return the tbUnidadesDeportivas
	 */
	public TbUnidadesDeportivas getTbUnidadesDeportivas() {
		return tbUnidadesDeportivas;
	}

	/**
	 * @param tbUnidadesDeportivas the tbUnidadesDeportivas to set
	 */
	public void setTbUnidadesDeportivas(TbUnidadesDeportivas tbUnidadesDeportivas) {
		this.tbUnidadesDeportivas = tbUnidadesDeportivas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the disponibleInicio
	 */
	public Date getDisponibleInicio() {
		return disponibleInicio;
	}

	/**
	 * @param disponibleInicio the disponibleInicio to set
	 */
	public void setDisponibleInicio(Date disponibleInicio) {
		this.disponibleInicio = disponibleInicio;
	}

	/**
	 * @return the disponibleFin
	 */
	public Date getDisponibleFin() {
		return disponibleFin;
	}

	/**
	 * @param disponibleFin the disponibleFin to set
	 */
	public void setDisponibleFin(Date disponibleFin) {
		this.disponibleFin = disponibleFin;
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

	
}
