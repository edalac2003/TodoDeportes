package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.TipoDeportesDAO;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class TipoDeportesDAOHibernate extends HibernateDaoSupport implements TipoDeportesDAO {

	ExcepcionesDAO expDao;

	@SuppressWarnings("deprecation")
	@Override
	public TbTiposDeporte obtenerTipoDeporte(int id) throws ExcepcionesDAO {
		Session session = null;
		TbTiposDeporte tipoDeporte = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTiposDeporte.class).add(Restrictions.eq("idtipoDeporte", id));
			tipoDeporte = (TbTiposDeporte)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener registro de Tipos de Deporte.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return tipoDeporte;
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbTiposDeporte> listarTipoDeporte() throws ExcepcionesDAO {
		Session session = null;
		List<TbTiposDeporte> listaTipoDeporte = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTiposDeporte.class);
			listaTipoDeporte = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar los Tipos de Deporte.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaTipoDeporte;
	}

}
