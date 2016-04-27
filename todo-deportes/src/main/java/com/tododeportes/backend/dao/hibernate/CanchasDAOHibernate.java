/**
 * 
 */
package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.CanchasDAO;
import com.tododeportes.backend.dto.TbCanchas;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.dto.TbTiposDeporte;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

/**
 * @author edalac2003
 *
 */
public class CanchasDAOHibernate extends HibernateDaoSupport implements CanchasDAO {

	ExcepcionesDAO expDao = null;
	
	@SuppressWarnings("deprecation")
	@Override
	public void guardarCancha(TbCanchas cancha) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(cancha);
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
	public void actualizarCancha(TbCanchas cancha) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(cancha);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Actualizar el Registro de Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public TbCanchas obtenerCanchaxId(int idCancha) throws ExcepcionesDAO {
		Session session = null;
		TbCanchas cancha = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCanchas.class).add(Restrictions.eq("idcancha", idCancha));
			cancha = (TbCanchas)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener el Registro de Cancha.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return cancha;
	}

	@Override
	public List<TbCanchas> listarCanchasxTipoDeporte(TbTiposDeporte tipoDeporte) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbCanchas> listarCanchasxTipoEscenario(TbTipoEscenario tipoEscenario) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TbCanchas> listarCanchasTodas() throws ExcepcionesDAO {
		Session session = null;
		List<TbCanchas> listaCanchas = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCanchas.class);
			listaCanchas = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar las Canchas.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaCanchas;
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

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbTipoEscenario> listarTipoEscenario() throws ExcepcionesDAO {
		Session session = null;
		List<TbTipoEscenario> listaEscenarios = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTipoEscenario.class);
			listaEscenarios = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar los Tipos de Escenario.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaEscenarios;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbCanchas> listarTodasCanchas() throws ExcepcionesDAO {
		Session session = null;
		List<TbCanchas> listaCanchas = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbCanchas.class);
			listaCanchas = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar listar .");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}
		return listaCanchas;
	}

	
}
