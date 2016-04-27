package com.tododeportes.backend.dao;

import java.util.List;

import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public interface CanchasDAO {

	public void guardarCancha(TbCanchas cancha) throws ExcepcionesDAO;
	
	public void actualizarCancha(TbCanchas cancha) throws ExcepcionesDAO;
	
	public TbCanchas obtenerCanchaxId(int idCancha) throws ExcepcionesDAO;
	
	public List<TbCanchas> listarCanchasxTipoDeporte(TbTiposDeporte tipoDeporte) throws ExcepcionesDAO;
	
	public List<TbCanchas> listarCanchasxTipoEscenario(TbTipoEscenario tipoEscenario) throws ExcepcionesDAO;
	
	public List<TbCanchas> listarCanchasTodas() throws ExcepcionesDAO;
		
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesDAO;
	
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesDAO;
	
	public List<TbCanchas> listarTodasCanchas() throws ExcepcionesDAO;
	
}
