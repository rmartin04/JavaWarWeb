package es.javawarweb.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.warsrpingbootjava.WarSpringJava.entities.Alienigenas;

import es.javawarweb.entities.UsuarioEntity;
import es.javawarweb.excepciones.HibernateSessionException;
import es.javawarweb.utils.HibernateUtil;

public class AlienigenasDAOImpl implements AlienigenasDAO {
	private Session session;
	private Transaction tx;

	public AlienigenasDAOImpl(){
		session = HibernateUtil.getSession();
	}
	// Implement the CRUD operations for Alienigenas here
	@Override
	public void insertar(Alienigenas alienigenas) throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			session.persist(alienigenas);
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al insertar, error: " + e.getMessage());
		}
	}

	@Override
	public void eliminar(Long id) throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			Alienigenas alienigenas = session.find(Alienigenas.class, id);
			if (alienigenas != null) {
				session.remove(alienigenas);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new HibernateSessionException("Ha habido un error al eliminar, error: " + e.getMessage());
		}
	}

	@Override
	public void actualizar(Alienigenas alienigenas) throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			session.merge(alienigenas);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new HibernateSessionException(
					"Ha habido un error al actualizar, error: " + e.getMessage());
		}
	}
	@Override
	public List<Alienigenas> consultar() throws HibernateSessionException {
		try {
			tx = session.beginTransaction();
			List<Alienigenas> alienigenas = session.createQuery("FROM Alienigenas", Alienigenas.class).list();
			tx.commit();
			return alienigenas; // Assuming you want the first one
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateSessionException(
					"Ha habido un error al consultar los alienigenas, error: " + e.getMessage());
		}
	}

	
	

	}

