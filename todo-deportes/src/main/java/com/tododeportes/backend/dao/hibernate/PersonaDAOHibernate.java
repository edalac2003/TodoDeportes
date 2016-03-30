package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.PersonaDAO;
import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {
	
	ExcepcionesDAO expDao = null;

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

	@Override
	public List<TbPersonas> listarTodasPersonas() throws ExcepcionesDAO {
		return null;
	}
}
