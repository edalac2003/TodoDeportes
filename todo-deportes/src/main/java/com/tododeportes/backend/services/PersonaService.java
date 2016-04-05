package com.tododeportes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.ngc.PersonaNGC;

@RestController
@RequestMapping("/persona")
public class PersonaService {
	@Autowired
	PersonaNGC personaNgc;
	
	@RequestMapping(value="/obtenerPersonaxId", method=RequestMethod.GET)
	public @ResponseBody TbPersonas obtenerPersonaxId(@RequestParam(value="id")String id) throws Exception{
		return personaNgc.obtenerPersonaxDocumento(id);
	}
	
	@RequestMapping(value="/listarPersonas", method=RequestMethod.GET)
	public @ResponseBody List<TbPersonas> listarPersonas() throws Exception{
		return personaNgc.listaPersonas();
	}

}
