package com.tododeportes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.ngc.PersonaNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/persona")
public class PersonaService {
	@Autowired
	PersonaNGC personaNgc;
	
	TbPersonas persona;
	
	@RequestMapping(value="/guardarPersona", method=RequestMethod.POST)
	public void guardarPersona(@RequestBody TbPersonas persona){
		try {
			personaNgc.guardarPersona(persona);
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/actualizarPersona", method=RequestMethod.PUT)
	public void actualizarPersona(@RequestBody TbPersonas persona){
		try {
			personaNgc.actualizarPersona(persona);
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
	public @ResponseBody List<TbPersonas> listarPersonas() throws Exception{
		return personaNgc.listaPersonas();
	}

}
