package com.tododeportes.backend.services;

/**
 * Esta clase contiene las entradas a los servicios relacionados con la entidad TbCancha.
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.dto.maestros.MaestroCanchaxUnidad;
import com.tododeportes.backend.ngc.CanchaNGC;
import com.tododeportes.backend.ngc.TipoDeporteNGC;
import com.tododeportes.backend.ngc.TipoEscenarioNGC;
import com.tododeportes.backend.ngc.UnidadDeportivaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping(value="/cancha")
public class CanchasServices {
	
	@Autowired
	CanchaNGC canchaNgc;
	@Autowired
	TipoDeporteNGC tipoDeporteNgc;
	@Autowired
	TipoEscenarioNGC tipoEscenarioNgc;
	@Autowired
	UnidadDeportivaNGC unidadDeportivaNgc;
	
	
	private List<TbTipoEscenario> listaEscenarios = null;
	private List<TbTiposDeporte> listaDeporte = null;
	private List<TbCanchas> listaCanchas = null;
	private List<TbCanchasxunidadDeportiva> listaCanchaxUnidad = null;
	private List<TbUnidadesDeportivas> listaUnidadDeportiva = null;
	private TbCanchas cancha = null;
	
	
	@RequestMapping(value="/guardarCancha", method=RequestMethod.POST)
	public void guardarCancha(@RequestBody MaestroCanchas cancha) throws Exception{
		try {
			canchaNgc.guardarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
		
	@RequestMapping(value="/actualizarCancha", method=RequestMethod.POST)
	public void actualizarCancha(@RequestBody MaestroCanchas cancha) throws Exception{
		try {
			canchaNgc.actualizarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listarTipoDeporte", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbTiposDeporte> listarTipoDeporte() throws Exception{
		try {
			listaDeporte = tipoDeporteNgc.listarTipoDeporte();
		} catch (ExcepcionesNGC e) {
			listaDeporte = new ArrayList<>();
			listaDeporte.add(new TbTiposDeporte(e.getMensajeUsuario()));
		}
		return listaDeporte;
	}
	
	@RequestMapping(value="/listarTipoEscenario", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbTipoEscenario> listarTipoEscenario() throws Exception{
		try {
			listaEscenarios = tipoEscenarioNgc.listarTipoEscenario();
		} catch (ExcepcionesNGC e) {
			listaEscenarios = new ArrayList<>();
			listaEscenarios.add(new TbTipoEscenario(e.getMensajeUsuario()));
		}		
		return listaEscenarios;
	}
	
	
	@RequestMapping(value="/obtenerCanchaxId", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody TbCanchas obtenerCanchaxId(@RequestParam(value="id")int id) throws Exception{
		try {
			cancha = canchaNgc.obtenerCanchaxId(id);
		} catch (ExcepcionesNGC e) {
			cancha.setMensajeError(e.getMensajeUsuario());
		}		
		return cancha;
	}
	
	
	@RequestMapping(value="/listarCanchasTodas", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbCanchas> listarCanchasTodas(){
		try {
			listaCanchas = canchaNgc.listarCanchasTodas();
		} catch (ExcepcionesNGC e) {
			listaCanchas = new ArrayList<>();
			listaCanchas.add(new TbCanchas(e.getMensajeUsuario()));
		}
		return listaCanchas;
	}
	
	@RequestMapping(value="/listarCanchaxUnidadDeportiva", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(@RequestParam(value="id") int id){		
		try {
			listaCanchaxUnidad = unidadDeportivaNgc.listarCanchaxUnidadDeportiva(id);
		} catch (ExcepcionesNGC e) {
			listaCanchaxUnidad = new ArrayList<>();
			listaCanchaxUnidad.add(new TbCanchasxunidadDeportiva(e.getMensajeUsuario()));			
		}		
		return listaCanchaxUnidad;
	}
	
	@RequestMapping(value="/listarUnidadesDeportivas", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbUnidadesDeportivas> listarUnidadesDeportivas(){
		try {
			listaUnidadDeportiva = unidadDeportivaNgc.listarUnidadesDeportivas();
		} catch (ExcepcionesNGC e) {
			listaUnidadDeportiva=new ArrayList<>();
			listaUnidadDeportiva.add(new TbUnidadesDeportivas(e.getMensajeUsuario()));
		}		
		return listaUnidadDeportiva;
	}
	
}
