package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbRoles generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbRoles implements java.io.Serializable {

	private int idrol;
	private String nombre;


	/**
	 * Constructor
	 */
	public TbRoles() {
		super();
	}


	/**
	 * @param idrol
	 * @param nombre
	 */
	public TbRoles(int idrol, String nombre) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
	}


	/**
	 * @return the idrol
	 */
	public int getIdrol() {
		return idrol;
	}

	/**
	 * @param idrol the idrol to set
	 */
	public void setIdrol(int idrol) {
		this.idrol = idrol;
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

}
