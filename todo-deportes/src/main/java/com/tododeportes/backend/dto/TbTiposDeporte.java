package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbTiposDeporte generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbTiposDeporte implements java.io.Serializable {

	private int idtipoDeporte;
	private String nombre;

	private String mensajeError;
	
	/**
	 * Constructor
	 */
	public TbTiposDeporte() {
		super();
	}

	
	/**
	 * @param mensajeError
	 */
	public TbTiposDeporte(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}


	/**
	 * @return the idtipoDeporte
	 */
	public int getIdtipoDeporte() {
		return idtipoDeporte;
	}

	/**
	 * @param idtipoDeporte the idtipoDeporte to set
	 */
	public void setIdtipoDeporte(int idtipoDeporte) {
		this.idtipoDeporte = idtipoDeporte;
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
