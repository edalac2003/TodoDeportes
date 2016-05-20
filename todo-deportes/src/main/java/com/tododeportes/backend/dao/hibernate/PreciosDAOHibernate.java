package com.tododeportes.backend.dao.hibernate;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.PreciosDAO;
import com.tododeportes.backend.dto.TbPreciosCancha;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class PreciosDAOHibernate extends HibernateDaoSupport implements PreciosDAO {
	
	ExcepcionesDAO expDao;

	@Override
	public double obtenerPrecio(Date fechaInicio) throws ExcepcionesDAO {
		return 0;
	}

	@Override
	public double obtenerPrecio(String diaSemana, Time horaInicio, Time horaFin) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void guardarPrecio(TbPreciosCancha precio) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(precio);
			tx.commit();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el Registro de Precios x Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}

	}

	@Override
	public List<TbPreciosCancha> listarRegistrosPrecios() throws ExcepcionesDAO {
		Session session = null;
		List<TbPreciosCancha> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbPreciosCancha.class);
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Listar Registros de Precios x Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

	@Override
	public TbPreciosCancha obtenerRegistroPrecio(int id) throws ExcepcionesDAO {
		Session session = null;
		TbPreciosCancha precio = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbPreciosCancha.class).add(Restrictions.eq("idtablaPrecios", id));
			criteria.setMaxResults(1);
			precio = (TbPreciosCancha)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener Registro de Precios x Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return precio;
	}

}
