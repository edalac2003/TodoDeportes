package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbUnidadesDeportivas generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbUnidadesDeportivas implements java.io.Serializable {

	private int idunidadDeportiva;
	private String nombre;
	private String direccion;
	private String telefono;
	private TbLocalidades localidad;
	private String contacto;

	private String mensajeError;
	
	
	/**
	 * Constructor
	 */
	public TbUnidadesDeportivas() {
		super();
	}

	/**
	 * @param mensajeError
	 */
	public TbUnidadesDeportivas(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}

	/**
	 * @return the idunidadDeportiva
	 */
	public int getIdunidadDeportiva() {
		return idunidadDeportiva;
	}

	/**
	 * @param idunidadDeportiva the idunidadDeportiva to set
	 */
	public void setIdunidadDeportiva(int idunidadDeportiva) {
		this.idunidadDeportiva = idunidadDeportiva;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the localidad
	 */
	public TbLocalidades getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(TbLocalidades localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
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
