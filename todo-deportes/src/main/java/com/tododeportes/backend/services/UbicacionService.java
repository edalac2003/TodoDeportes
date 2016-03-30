package com.tododeportes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.ngc.UbicacionNGC;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionService {

	@Autowired 
	UbicacionNGC ubicacionNgc;
	
	/**
	 * @param ubicacionNgc the ubicacionNgc to set
	 */
	public void setUbicacionNgc(UbicacionNGC ubicacionNgc) {
		this.ubicacionNgc = ubicacionNgc;
	}


	@RequestMapping(value="/listarDepartamentos", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbDepartamentos> listarDepartamentos() throws Exception{
		return ubicacionNgc.listarDepartamentos();
	}
	
	@RequestMapping(value="/listarCiudades", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbCiudades> listarCiudades() throws Exception{
		return ubicacionNgc.listarCiudades();
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbLocalidades> listarLocalidades() throws Exception{
		return ubicacionNgc.listarLocalidades();
	}
	
}
