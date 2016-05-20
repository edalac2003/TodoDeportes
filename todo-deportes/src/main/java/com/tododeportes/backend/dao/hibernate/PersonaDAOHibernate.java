package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.PersonaDAO;
import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbTiposDocumento;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {
	
	ExcepcionesDAO expDao = null;

	
	
	@SuppressWarnings("deprecation")
	@Override
	public void guardarPersona(TbPersonas persona) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(persona);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el registro de Persona.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
	}
	


	@SuppressWarnings("deprecation")
	@Override
	public void guardarPersona(TbPersonas persona, TbUsuarios usuario) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(persona);
			session.saveOrUpdate(usuario);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el registro de Persona.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
	}
	


	@SuppressWarnings("deprecation")
	@Override
	public void actualizarPersona(TbPersonas persona) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(persona);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Actualizar el registro de Persona.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}	
	}


	@SuppressWarnings("deprecation")
	@Override
	public TbPersonas obtenerPersonaxDocumento(String idDocumento) throws ExcepcionesDAO {
		TbPersonas persona = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbPersonas.class).add(Restrictions.eq("numeroDocumento", idDocumento));
			persona = (TbPersonas) criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener registro de Persona por ID.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return persona;
	}

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbPersonas> listarTodasPersonas() throws ExcepcionesDAO {
		List<TbPersonas> listaPersonas = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbPersonas.class);
			listaPersonas = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener listado de Personas.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}
		
		return listaPersonas;
	}


	/* (non-Javadoc)
	 * @see com.tododeportes.backend.dao.PersonaDAO#listarTipoDocumento()
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbTiposDocumento> listarTipoDocumento() throws ExcepcionesDAO {
		List<TbTiposDocumento> lista = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTiposDocumento.class);
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener listado de Tipo de Documento.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}
		return lista;
	}



	/* (non-Javadoc)
	 * @see com.tododeportes.backend.dao.PersonaDAO#obtenerTipoDocumento(int)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public TbTiposDocumento obtenerTipoDocumento(int idTipoDocumento) throws ExcepcionesDAO {
		TbTiposDocumento tipoDocumento = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTiposDocumento.class).add(Restrictions.eq("idtipoDocumento", idTipoDocumento));
			tipoDocumento = (TbTiposDocumento)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener registro de Tipo de Documento.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}
		
		return tipoDocumento;
	}
	
}
