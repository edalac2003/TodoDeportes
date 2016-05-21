package com.tododeportes.backend.dto.maestros;

public class MaestroCanchas {

	private int idCancha;
	private Integer tipoDeporte;
	private Integer tipoEscenario;	
	private String nombre;
	
	public MaestroCanchas() {		
	}

	public int getIdCancha() {
		return idCancha;
	}

	public void setIdCancha(int idCancha) {
		this.idCancha = idCancha;
	}

	public Integer getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(Integer tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public Integer getTipoEscenario() {
		return tipoEscenario;
	}

	public void setTipoEscenario(Integer tipoEscenario) {
		this.tipoEscenario = tipoEscenario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
