package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.TipoDeportesDAO;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.ngc.TipoDeporteNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class TipoDeportesNGCImpl implements TipoDeporteNGC {

	ExcepcionesNGC expNgc;
	
	TipoDeportesDAO tipoDeporteDao;
	
	public void setTipoDeporteDao(TipoDeportesDAO tipoDeporteDao) {
		this.tipoDeporteDao = tipoDeporteDao;
	}

	@Override
	public TbTiposDeporte obtenerTipoDeporte(int id) throws ExcepcionesNGC {
		TbTiposDeporte tipoDeporte = null;
		
		if(id > 0){
			try {
				tipoDeporte = tipoDeporteDao.obtenerTipoDeporte(id);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Ingrese un ID válido.");
			throw expNgc;
		}
		
		return tipoDeporte;
	}

	@Override
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesNGC {
		List<TbTiposDeporte> listaTipoDeporte = null;
		
		try {
			listaTipoDeporte = tipoDeporteDao.listarTipoDeporte();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoDeporte;
	}


}
