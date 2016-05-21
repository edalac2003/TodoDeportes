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
import com.tododeportes.backend.dto.TbTiposDocumento;
import com.tododeportes.backend.dto.maestros.MaestroPersona;
import com.tododeportes.backend.ngc.PersonaNGC;

@RestController
@RequestMapping("/persona")
public class PersonaService {
	@Autowired
	PersonaNGC personaNgc;
	
	@RequestMapping(value="/guardarPersona", method=RequestMethod.POST)
	public void guardarPersona(@RequestBody MaestroPersona persona)throws Exception{
		personaNgc.guardarPersona(persona);
	}
		
	@RequestMapping(value="/obtenerPersonaxId", method=RequestMethod.GET)
	public @ResponseBody TbPersonas obtenerPersonaxId(@RequestParam(value="id")String id)throws Exception{
		return personaNgc.obtenerPersonaxDocumento(id);		
	}
	
	@RequestMapping(value="/listarPersonas", method=RequestMethod.GET)
	public @ResponseBody List<TbPersonas> listarPersonas()throws Exception{
		return personaNgc.listaPersonas();
	}
	
	@RequestMapping(value="/listarTipoDocumento", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbTiposDocumento> listarTipoDocumento()throws Exception{
		return personaNgc.listarTipoDocumento();
	}

}
