package com.tododeportes.backend.ngc.impl;

import java.util.List;

import com.tododeportes.backend.dao.TipoEscenariosDAO;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.ngc.TipoEscenarioNGC;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

public class TipoEscenarioNGCImpl implements TipoEscenarioNGC {

	ExcepcionesNGC expNgc;
	
	TipoEscenariosDAO tipoEscenarioDao;
	
	
	public void setTipoEscenarioDao(TipoEscenariosDAO tipoEscenarioDao) {
		this.tipoEscenarioDao = tipoEscenarioDao;
	}
	

	@Override
	public TbTipoEscenario obtenerTipoEscenario(int id) throws ExcepcionesNGC {
		TbTipoEscenario tipoEscenario = null;
		
		if(id > 0){
			try {
				tipoEscenario = tipoEscenarioDao.obtenerTipoEscenario(id);
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
		
		return tipoEscenario;
	}

	@Override
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesNGC {
		List<TbTipoEscenario> listaTipoEscenarios = null;
		
		try {
			listaTipoEscenarios = tipoEscenarioDao.listarTipoEscenario();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoEscenarios;
	}

}
