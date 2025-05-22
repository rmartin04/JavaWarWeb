package es.javawarweb.web.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.web.dto.UsuarioDTO;
import es.javawarweb.web.entities.UsuarioEntity;
import es.javawarweb.web.utils.HibernateUtil;
import excepciones.HibernateSessionException;


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
			String query = "FROM UsuarioEntity u WHERE u.usuario = :usuario";
			UsuarioEntity usuarioEntity = session.createQuery(query, UsuarioEntity.class)
					.setParameter("usuario", usuario).uniqueResult();
			
			// Si no lo encuentra nos devolverá null
			if (usuarioEntity == null) {
				tx.commit();
				return null;
			}
			
			if (usuarioEntity.getContrasenia().equals(contrasenia)) {
				tx.commit();
				return usuarioEntity;
			} else {
				// Contraseña inválida
				tx.commit();
				if (tx != null) tx.rollback();
				return null;
			}
			
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
