package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbTiposDocumento generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbTiposDocumento implements java.io.Serializable {

	private int idtipoDocumento;
	private String descripcion;
	private String abreviado;
	
	public TbTiposDocumento() {
	}

	public TbTiposDocumento(int idtipoDocumento) {
		this.idtipoDocumento = idtipoDocumento;
	}

	public TbTiposDocumento(int idtipoDocumento, String descripcion, String abreviado) {
		this.idtipoDocumento = idtipoDocumento;
		this.descripcion = descripcion;
		this.abreviado = abreviado;
	}

	public int getIdtipoDocumento() {
		return this.idtipoDocumento;
	}

	public void setIdtipoDocumento(int idtipoDocumento) {
		this.idtipoDocumento = idtipoDocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviado() {
		return this.abreviado;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}
}