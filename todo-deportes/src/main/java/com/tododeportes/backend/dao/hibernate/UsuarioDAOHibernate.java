package com.tododeportes.backend.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.UsuariosDAO;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuariosDAO {

	ExcepcionesDAO expDao = null;
	Session session = null;
	Criteria criteria = null;
	
	@SuppressWarnings("deprecation")
	@Override
	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el Registro de Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public TbUsuarios obtenerUsuarioxLogin(String login) throws ExcepcionesDAO {
		TbUsuarios usuario = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbUsuarios.class).add(Restrictions.eq("login", login));
			usuario = (TbUsuarios)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el Registro de Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return usuario;
	}
	

}
