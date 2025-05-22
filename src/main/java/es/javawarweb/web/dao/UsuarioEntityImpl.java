package es.javawarweb.web.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.web.entities.UsuarioEntity;
import es.javawarweb.web.utils.HibernateUtil;
import excepciones.HibernateSessionException;


public class UsuarioEntityImpl implements UsuarioDAO{
	private Session session;
	private Transaction tx;

	public UsuarioEntityImpl() {
		session = HibernateUtil.getSession();
	}
	
	@Override
	public List<UsuarioEntity> findAll() throws HibernateSessionException {
		
		try {
			tx = session.beginTransaction();
			List<UsuarioEntity> usuario =  session.createQuery("FROM UsuarioEntity u", UsuarioEntity.class).list();
			tx.commit();
			return usuario;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al consultar los usuarios, error: " + e.getMessage());
		}
		
	}

	@Override
	public UsuarioEntity findById(UsuarioEntity usuario) throws HibernateSessionException {
		
		try {
			tx = session.beginTransaction();
			UsuarioEntity usuarioId = session.find(UsuarioEntity.class, usuario);
			tx.commit();
			return usuarioId;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al consultar el usuario, error: " + e.getMessage());
		}
	
	}

	@Override
	public UsuarioEntity insert(UsuarioEntity usuario) throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			session.persist(usuario);
			tx.commit();
			return usuario;
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al insertar el usuario, error: " + e.getMessage());
		}
	}
	
	

}
