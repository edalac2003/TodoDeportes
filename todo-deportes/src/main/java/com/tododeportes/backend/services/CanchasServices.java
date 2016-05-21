package com.tododeportes.backend.services;

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
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.dto.maestros.MaestroCanchaxUnidad;
import com.tododeportes.backend.ngc.CanchaNGC;
import com.tododeportes.backend.ngc.TipoDeporteNGC;
import com.tododeportes.backend.ngc.TipoEscenarioNGC;
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
	
	
	private List<TbTipoEscenario> listaEscenarios = null;
	private List<TbTiposDeporte> listaDeporte = null;
	private List<TbCanchas> listaCanchas = null;
	private TbCanchas cancha = null;
	
	
	@RequestMapping(value="/guardarCancha", method=RequestMethod.POST, consumes="application/JSON")
	public void guardarCancha(@RequestBody MaestroCanchas cancha) throws Exception{
		try {
			canchaNgc.guardarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	public void guardarCanchaxUnidad(MaestroCanchaxUnidad cancha) throws Exception{
		
	}
	
	@RequestMapping(value="/actualizarCancha", method=RequestMethod.POST)
	public void actualizarCancha(@RequestBody MaestroCanchas cancha) throws Exception{
		try {
			canchaNgc.actualizarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listarTipoDeporte", method=RequestMethod.GET)
	public @ResponseBody List<TbTiposDeporte> listarTipoDeporte() throws Exception{
		try {
			listaDeporte = tipoDeporteNgc.listarTipoDeporte();
		} catch (ExcepcionesNGC e) {
			listaDeporte = new ArrayList<>();
			listaDeporte.add(new TbTiposDeporte(e.getMensajeUsuario()));
		}
		return listaDeporte;
	}
	
	@RequestMapping(value="/listarTipoEscenario", method=RequestMethod.GET)
	public @ResponseBody List<TbTipoEscenario> listarTipoEscenario() throws Exception{
		try {
			listaEscenarios = tipoEscenarioNgc.listarTipoEscenario();
		} catch (ExcepcionesNGC e) {
			listaEscenarios = new ArrayList<>();
			listaEscenarios.add(new TbTipoEscenario(e.getMensajeUsuario()));
		}		
		return listaEscenarios;
	}
	
	
	@RequestMapping(value="/obtenerCanchaxId", method=RequestMethod.GET)
	public @ResponseBody TbCanchas obtenerCanchaxId(@RequestParam(value="id")int id) throws Exception{
		try {
			cancha = canchaNgc.obtenerCanchaxId(id);
		} catch (ExcepcionesNGC e) {
			cancha.setMensajeError(e.getMensajeUsuario());
		}		
		return cancha;
	}
	
	
	@RequestMapping(value="/listarCanchasTodas", method=RequestMethod.GET)
	public @ResponseBody List<TbCanchas> listarCanchasTodas() throws Exception{
		try {
			listaCanchas = canchaNgc.listarCanchasTodas();
		} catch (ExcepcionesNGC e) {
			listaCanchas = new ArrayList<>();
			listaCanchas.add(new TbCanchas(e.getMensajeUsuario()));
		}
		return listaCanchas;
	}
	
}
