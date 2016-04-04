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
	private String localidad;
	private String contacto;

	public TbUnidadesDeportivas() {
	}

	public TbUnidadesDeportivas(int idunidadDeportiva) {
		this.idunidadDeportiva = idunidadDeportiva;
	}

	public TbUnidadesDeportivas(int idunidadDeportiva, String nombre, String direccion, String telefono,
			String localidad, String contacto) {
		this.idunidadDeportiva = idunidadDeportiva;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.localidad = localidad;
		this.contacto = contacto;
	}

	public int getIdunidadDeportiva() {
		return this.idunidadDeportiva;
	}

	public void setIdunidadDeportiva(int idunidadDeportiva) {
		this.idunidadDeportiva = idunidadDeportiva;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}