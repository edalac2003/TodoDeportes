package com.tododeportes.backend.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tododeportes.backend.dao.UsuariosDAO;
import com.tododeportes.backend.dto.TbLocalidades;
import com.tododeportes.backend.dto.TbPersonas;
import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.util.exception.ExcepcionesDAO;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuariosDAO {

	ExcepcionesDAO expDao = null;
	Session session = null;
	Criteria criteria = null;
	
	@Override
	public void guardarUsuario(TbUsuarios usuario) throws ExcepcionesDAO {
		

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

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<TbUsuarios> obtenerUsuarioxPersona(TbPersonas persona) throws ExcepcionesDAO {
		List<TbUsuarios> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbUsuarios.class).add(Restrictions.eq("tbPersonas", persona));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar Obtener el Registro de Usuario.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

}
