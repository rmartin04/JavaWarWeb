package es.javawarweb.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.dto.UsuarioDTO;
import es.javawarweb.entities.UsuarioEntity;
import es.javawarweb.excepciones.HibernateSessionException;
import es.javawarweb.utils.HibernateUtil;


public class UsuarioDAOImpl implements UsuarioDAO{
	private Session session;
	private Transaction tx;

	public UsuarioDAOImpl() {
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
	public UsuarioEntity findUser(String usuario, String contrasenia) throws HibernateSessionException {
		
		try {
			tx = session.beginTransaction();
			String query = "FROM UsuarioEntity u WHERE u.usuario = :usuario and u.contrasenia = :contrasenia";
			UsuarioEntity usuarioEntity = session.createQuery(query, UsuarioEntity.class)
					.setParameter("usuario", usuario)
					.setParameter("contrasenia", contrasenia).uniqueResult();
			
			tx.commit();
			return usuarioEntity;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al consultar el usuario, error: " + e.getMessage());
		}
	
	}

	@Override
	public boolean insert(UsuarioEntity usuario) throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			session.persist(usuario);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al insertar el usuario, error: " + e.getMessage());
		}
	}

	
	

}
