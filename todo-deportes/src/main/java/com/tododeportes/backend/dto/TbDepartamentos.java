package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbDepartamentos generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbDepartamentos implements java.io.Serializable {

	private int iddepartamento;
	private String nombre;
	
	private String mensajeError;


	/**
	 * Constructor
	 */
	public TbDepartamentos() {
		super();
	}

	/**
	 * @param iddepartamento
	 * @param nombre
	 */
	public TbDepartamentos(int iddepartamento, String nombre) {
		super();
		this.iddepartamento = iddepartamento;
		this.nombre = nombre;
	}

	/**
	 * @return the iddepartamento
	 */
	public int getIddepartamento() {
		return iddepartamento;
	}

	/**
	 * @param iddepartamento the iddepartamento to set
	 */
	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
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
