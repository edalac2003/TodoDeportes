package com.tododeportes.backend.services;

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
import com.tododeportes.backend.ngc.CanchaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping(value="/cancha")
public class CanchasServices {
	
	@Autowired
	CanchaNGC canchaNgc;
	
	private List<TbTipoEscenario> listaEscenarios = null;
	private List<TbTiposDeporte> listaDeporte = null;
	private List<TbCanchas> listaCanchas = null;
	private TbCanchas cancha = null;
	
	
	@RequestMapping(value="/guardarCancha", method=RequestMethod.POST)
	public void guardarCancha(@RequestBody TbCanchas cancha){
		try {
			canchaNgc.guardarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/actualizarCancha", method=RequestMethod.POST)
	public void actualizarCancha(@RequestBody TbCanchas cancha){
		try {
			canchaNgc.actualizarCancha(cancha);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listarTipoDeporte", method=RequestMethod.GET)
	public @ResponseBody List<TbTiposDeporte> listarTipoDeporte(){
		try {
			listaDeporte = canchaNgc.listarTipoDeporte();
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
		return listaDeporte;
	}
	
	@RequestMapping(value="/listarTipoEscenario", method=RequestMethod.GET)
	public @ResponseBody List<TbTipoEscenario> listarTipoEscenario(){
		try {
			listaEscenarios = canchaNgc.listarTipoEscenario();
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}		
		return listaEscenarios;
	}
	
	
	@RequestMapping(value="/obtenerCanchaxId", method=RequestMethod.GET)
	public @ResponseBody TbCanchas obtenerCanchaxId(@RequestParam(value="id")int id){
		try {
			cancha = canchaNgc.obtenerCanchaxId(id);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}		
		return cancha;
	}
	
	
	@RequestMapping(value="/listarCanchasTodas", method=RequestMethod.GET)
	public @ResponseBody List<TbCanchas> listarCanchasTodas(){
		try {
			listaCanchas = canchaNgc.listarCanchasTodas();
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
		return listaCanchas;
	}
	
}
