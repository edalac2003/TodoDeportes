package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.ReservaDAO;
import com.tododeportes.backend.dto.TbCanchasxunidadDeportiva;
import com.tododeportes.backend.dto.TbReservas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class ReservasDAOHibernate extends HibernateDaoSupport implements ReservaDAO {
	
	ExcepcionesDAO expDao;

	@SuppressWarnings("deprecation")
	@Override
	public void guardarReserva(TbReservas reserva) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(reserva);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el Registro de la Reserva.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actualizarReserva(TbReservas reserva) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(reserva);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Guardar el Registro de la Reserva.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public TbReservas obtenerReservaxId(int id) throws ExcepcionesDAO {
		TbReservas reserva = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbReservas.class).add(Restrictions.eq("idreserva", id));
			reserva = (TbReservas)criteria.uniqueResult();			
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener el Registro de la Reserva.");
			expDao.setOrigen(e);
		}finally{
			session.close();
		}		
		return reserva;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbReservas> obtenerReservaxUsuario(TbUsuarios usuario) throws ExcepcionesDAO {
		List<TbReservas> lista = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbReservas.class).add(Restrictions.eq("usuario", usuario));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener los Registros de Reservas por Usuario.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.tododeportes.backend.dao.ReservaDAO#listarReservasxCancha(com.tododeportes.backend.dto.TbCanchasxunidadDeportiva)
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbReservas> listarReservasxCancha(TbCanchasxunidadDeportiva cancha) throws ExcepcionesDAO {
		List<TbReservas> lista = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbReservas.class).add(Restrictions.eq("tbCanchasxunidadDeportiva", cancha));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener los Registros de Reservas por Usuario.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}
	
	

}
