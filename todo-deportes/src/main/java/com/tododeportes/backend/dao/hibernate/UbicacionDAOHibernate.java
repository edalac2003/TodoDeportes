package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.UbicacionDAO;
import com.tododeportes.backend.dto.TbCiudades;
import com.tododeportes.backend.dto.TbDepartamentos;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class UbicacionDAOHibernate extends HibernateDaoSupport implements UbicacionDAO {

	ExcepcionesDAO expDao;
	
	
	@SuppressWarnings("deprecation")
	@Override
	public TbDepartamentos obtenerDepartamento(int idDepartamento) throws ExcepcionesDAO {
		Session session = null;
		TbDepartamentos departamento = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbDepartamentos.class).add(Restrictions.eq("iddepartamento", idDepartamento));
			departamento = (TbDepartamentos)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro del Departamento.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return departamento;
	}

	@SuppressWarnings("deprecation")
	@Override
	public TbCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		Session session = null;
		TbCiudades ciudad = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCiudades.class).add(Restrictions.eq("idciudad", idCiudad));
			ciudad = (TbCiudades)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Ciudades.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return ciudad;
	}

	@SuppressWarnings("deprecation")
	@Override
	public TbLocalidades obtenerLocalidad(int idLocalidad) throws ExcepcionesDAO {
		Session session = null;
		TbLocalidades localidad = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbLocalidades.class);
			localidad = (TbLocalidades)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Localidades.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return localidad;
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

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbCiudades> listarCiudadesxDepartamento(TbDepartamentos departamento) throws ExcepcionesDAO {
		Session session = null;
		List<TbCiudades> listaCiudades = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCiudades.class).add(Restrictions.eq("tbDepartamentos", departamento));
			listaCiudades = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Ciudades por Departamento.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaCiudades;
	}

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbLocalidades> listarLocalidadesxCiudad(TbCiudades ciudad) throws ExcepcionesDAO {
		Session session = null;
		List<TbLocalidades> listaLocalidades = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbLocalidades.class).add(Restrictions.eq("tbCiudades", ciudad));
			listaLocalidades = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Localidades por Ciudad.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaLocalidades;
	}
	
}
