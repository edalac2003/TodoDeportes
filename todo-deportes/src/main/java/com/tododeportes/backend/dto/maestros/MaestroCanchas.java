package com.tododeportes.backend.dto.maestros;

import java.util.Date;

public class MaestroCanchas {

	private Long idCancha;
	private Long tipoDeporte;
	private Long tipoEscenario;
	private Long localidad;
	private Long unidadDeportiva;
	private String nombre;
	private Date disponibleInicio;
	private Date disponibleFin;
	
	public MaestroCanchas() {		
	}


	/**
	 * @return the idCancha
	 */
	public Long getIdCancha() {
		return idCancha;
	}


	/**
	 * @param idCancha the idCancha to set
	 */
	public void setIdCancha(Long idCancha) {
		this.idCancha = idCancha;
	}



	/**
	 * @return the tipoDeporte
	 */
	public Long getTipoDeporte() {
		return tipoDeporte;
	}

	/**
	 * @param tipoDeporte the tipoDeporte to set
	 */
	public void setTipoDeporte(Long tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	/**
	 * @return the tipoEscenario
	 */
	public Long getTipoEscenario() {
		return tipoEscenario;
	}

	/**
	 * @param tipoEscenario the tipoEscenario to set
	 */
	public void setTipoEscenario(Long tipoEscenario) {
		this.tipoEscenario = tipoEscenario;
	}

	/**
	 * @return the localidad
	 */
	public Long getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Long localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the unidadDeportiva
	 */
	public Long getUnidadDeportiva() {
		return unidadDeportiva;
	}

	/**
	 * @param unidadDeportiva the unidadDeportiva to set
	 */
	public void setUnidadDeportiva(Long unidadDeportiva) {
		this.unidadDeportiva = unidadDeportiva;
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

	
}
