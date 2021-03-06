package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbCanchas generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbCanchas implements java.io.Serializable {

	private int idcancha;
	private TbTipoEscenario tbTipoEscenario;
	private TbTiposDeporte tbTiposDeporte;
	private String nombre;

	private String mensajeError;
	
	/**
	 * 
	 */
	public TbCanchas() {
		super();
	}


	/**
	 * @param mensajeError
	 */
	public TbCanchas(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}

	/**
	 * @return the idcancha
	 */
	public int getIdcancha() {
		return idcancha;
	}

	/**
	 * @param idcancha the idcancha to set
	 */
	public void setIdcancha(int idcancha) {
		this.idcancha = idcancha;
	}

	/**
	 * @return the tbTipoEscenario
	 */
	public TbTipoEscenario getTbTipoEscenario() {
		return tbTipoEscenario;
	}

	/**
	 * @param tbTipoEscenario the tbTipoEscenario to set
	 */
	public void setTbTipoEscenario(TbTipoEscenario tbTipoEscenario) {
		this.tbTipoEscenario = tbTipoEscenario;
	}

	/**
	 * @return the tbTiposDeporte
	 */
	public TbTiposDeporte getTbTiposDeporte() {
		return tbTiposDeporte;
	}

	/**
	 * @param tbTiposDeporte the tbTiposDeporte to set
	 */
	public void setTbTiposDeporte(TbTiposDeporte tbTiposDeporte) {
		this.tbTiposDeporte = tbTiposDeporte;
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
