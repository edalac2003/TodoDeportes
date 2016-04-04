package com.tododeportes.backend.dto;
// Generated 26/03/2016 03:44:35 PM by Hibernate Tools 4.3.1.Final

/**
 * TbEstados generated by hbm2java
 */
@SuppressWarnings("serial")
public class TbEstados implements java.io.Serializable {

	private int idestado;
	private String tablaReferencia;
	private String valor;

	public TbEstados() {
	}

	public TbEstados(int idestado) {
		this.idestado = idestado;
	}

	public TbEstados(int idestado, String tablaReferencia, String valor) {
		this.idestado = idestado;
		this.tablaReferencia = tablaReferencia;
		this.valor = valor;
	}

	public int getIdestado() {
		return this.idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getTablaReferencia() {
		return this.tablaReferencia;
	}

	public void setTablaReferencia(String tablaReferencia) {
		this.tablaReferencia = tablaReferencia;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}