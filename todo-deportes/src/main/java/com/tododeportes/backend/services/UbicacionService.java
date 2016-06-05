package com.tododeportes.backend.services;

/**
 * Esta clase contiene las entradas a los servicios relacionados con la entidad TbUbicacion.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/listarCiudadesxDepartamento", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbCiudades> listarCiudadesxDepartamento(@RequestParam(value="id")int idDepartamento) throws Exception{
		return ubicacionNgc.listarCiudadesxDepartamento(idDepartamento);
	}
	
	@RequestMapping(value="/listarLocalidades", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbLocalidades> listarLocalidades() throws Exception{
		return ubicacionNgc.listarLocalidades();
	}
	
	@RequestMapping(value="/listarLocalidadesxCiudad", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<TbLocalidades> listarLocalidadesxCiudad(@RequestParam(value="id")int idCiudad) throws Exception{
		return ubicacionNgc.listarLocalidadesxCiudad(idCiudad);
	}
	
}
