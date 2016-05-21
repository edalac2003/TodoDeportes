package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.TipoEscenariosDAO;
import com.tododeportes.backend.dto.TbTipoEscenario;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class TipoEscenarioDAOHibernate extends HibernateDaoSupport implements TipoEscenariosDAO {

	ExcepcionesDAO expDao;

	@SuppressWarnings("deprecation")
	@Override
	public TbTipoEscenario obtenerTipoEscenario(int id) throws ExcepcionesDAO {
		Session session = null;
		TbTipoEscenario tipoEscenario = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbTipoEscenario.class).add(Restrictions.eq("idtipoEscenario", id));
			tipoEscenario = (TbTipoEscenario)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al obtener registro de Tipos de Escenario.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		return tipoEscenario;
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

}
