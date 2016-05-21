package com.tododeportes.backend.dto.maestros;

import java.util.Date;

import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;

	public class MaestroCanchaxUnidad {

	private int idCancha;
	private int idUnidadDeportiva;
	private String nombre;
	private Date disponibleInicio;
	private Date disponibleFin;
	private int idEstado;
	private MaestroCanchas cancha;
	private MaestroUnidadDeportiva unidadDeportiva;
	
	public MaestroCanchaxUnidad() {
	}

	public int getIdCancha() {
		return idCancha;
	}

	public void setIdCancha(int idCancha) {
		this.idCancha = idCancha;
	}

	public int getIdUnidadDeportiva() {
		return idUnidadDeportiva;
	}

	public void setIdUnidadDeportiva(int idUnidadDeportiva) {
		this.idUnidadDeportiva = idUnidadDeportiva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDisponibleInicio() {
		return disponibleInicio;
	}

	public void setDisponibleInicio(Date disponibleInicio) {
		this.disponibleInicio = disponibleInicio;
	}

	public Date getDisponibleFin() {
		return disponibleFin;
	}

	public void setDisponibleFin(Date disponibleFin) {
		this.disponibleFin = disponibleFin;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public MaestroCanchas getCancha() {
		return cancha;
	}

	public void setCancha(MaestroCanchas cancha) {
		this.cancha = cancha;
	}

	public MaestroUnidadDeportiva getUnidadDeportiva() {
		return unidadDeportiva;
	}

	public void setUnidadDeportiva(MaestroUnidadDeportiva unidadDeportiva) {
		this.unidadDeportiva = unidadDeportiva;
	}

}
