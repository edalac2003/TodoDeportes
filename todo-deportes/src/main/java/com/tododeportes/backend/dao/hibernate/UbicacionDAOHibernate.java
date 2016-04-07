package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class UbicacionDAOHibernate extends HibernateDaoSupport implements UbicacionDAO {

	ExcepcionesDAO expDao;
	
	@Override
	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		return null;
	}

	@Override
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesDAO {
		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbDepartamentos> listarDepartamentos() throws ExcepcionesDAO {
		Session session = null;
		List<TbDepartamentos> listaDepartamentos = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbDepartamentos.class);
			listaDepartamentos = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Departamentos.");
			expDao.setOrigen(e);
			throw expDao;
		}finally {
			session.close();
		}		
		return listaDepartamentos;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbCiudades> listarCiudades() throws ExcepcionesDAO {
		Session session = null;
		List<TbCiudades> listaCiudades = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCiudades.class);
			listaCiudades = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Ciudades.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaCiudades;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbLocalidades> listarLocalidades() throws ExcepcionesDAO {
		Session session = null;
		List<TbLocalidades> listaLocalidades = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbLocalidades.class);
			listaLocalidades = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Localidades.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaLocalidades;
	}

}
