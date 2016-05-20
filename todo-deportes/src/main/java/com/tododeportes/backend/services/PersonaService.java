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

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbTiposDocumento;
import com.tododeportes.backend.dto.maestros.MaestroPersona;
import com.tododeportes.backend.ngc.PersonaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/persona")
public class PersonaService {
	@Autowired
	PersonaNGC personaNgc;
	
	TbPersonas persona;
	
	
	@RequestMapping(value="/guardarPersona", method=RequestMethod.POST)
	public void guardarPersona(@RequestBody MaestroPersona persona){
		try {
			personaNgc.guardarPersona(persona);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
		
	@RequestMapping(value="/obtenerPersonaxId", method=RequestMethod.GET)
	public @ResponseBody TbPersonas obtenerPersonaxId(@RequestParam(value="id")String id){
		try {
			persona = personaNgc.obtenerPersonaxDocumento(id);
		} catch (ExcepcionesNGC e) {
			persona = new TbPersonas();
			persona.setMensajeError(e.getMensajeUsuario());
		}
		
		return persona;
	}
	
	@RequestMapping(value="/listarPersonas", method=RequestMethod.GET)
	public @ResponseBody List<TbPersonas> listarPersonas(){
		List<TbPersonas> lista = null;
		try {
			lista = personaNgc.listaPersonas();
		} catch (ExcepcionesNGC e) {
			lista = new ArrayList<>();
			persona = new TbPersonas(e.getMensajeUsuario());
			lista.add(persona);
		}
		return lista;
	}
	
	
	@RequestMapping(value="/listarTipoDocumento", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbTiposDocumento> listarTipoDocumento(){
		List<TbTiposDocumento> lista = null;
		TbTiposDocumento tipoDocumento = null;
		try {
			lista = personaNgc.listarTipoDocumento();
		} catch (ExcepcionesNGC e) {
			tipoDocumento = new TbTiposDocumento();
			tipoDocumento.setMensajeError(e.getMensajeUsuario());
			lista = new ArrayList<>();
			lista.add(tipoDocumento);
		}
		return lista;
	}

}
