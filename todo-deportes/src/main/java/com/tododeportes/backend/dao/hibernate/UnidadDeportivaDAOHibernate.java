package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.UnidadDeportivaDAO;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.dto.TbUnidadesDeportivas;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class UnidadDeportivaDAOHibernate extends HibernateDaoSupport implements UnidadDeportivaDAO {

	ExcepcionesDAO expDao;
	Session session;
	Criteria criteria;
	
	List<TbUnidadesDeportivas> lista;
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbUnidadesDeportivas> listarUnidadesDeportivas() throws ExcepcionesDAO {
		session = null;
		lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbUnidadesDeportivas.class);
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar los registros de Unidad Deportiva.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		
		
		return lista;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TbUnidadesDeportivas> listarUnidadDeportivaxLocalidad(TbLocalidades localidad) throws ExcepcionesDAO {
		session = null;
		lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbUnidadesDeportivas.class).add(Restrictions.eq("localidad", localidad));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar los registros de Unidad Deportiva por Localidad.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		
		return lista;
	}

	@SuppressWarnings("deprecation")
	@Override
	public TbUnidadesDeportivas obtenerUnidadDeportivaxId(int id) throws ExcepcionesDAO {
		session = null;
		TbUnidadesDeportivas unidadDeportiva = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbUnidadesDeportivas.class).add(Restrictions.eq("idunidadDeportiva", id));
			unidadDeportiva = (TbUnidadesDeportivas)criteria.uniqueResult();			
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener registro de Unidad Deportiva.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return unidadDeportiva;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void guardarUnidadDeportiva(TbUnidadesDeportivas unidadDeportiva) throws ExcepcionesDAO {
		session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(unidadDeportiva);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar guardar registro de Unidad Deportiva.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbCanchasxunidadDeportiva> listarCanchaxUnidadDeportiva(TbUnidadesDeportivas unidadDeportiva)
			throws ExcepcionesDAO {
		session = null;
		List<TbCanchasxunidadDeportiva> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCanchasxunidadDeportiva.class).add(Restrictions.eq("tbUnidadesDeportivas", unidadDeportiva));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar las canchas por Unidad Deportiva.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		
		return lista;
	}

}
