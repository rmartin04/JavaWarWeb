package es.javawarweb.web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.web.entities.Alienigenas;
import es.javawarweb.web.entities.UsuarioEntity;
import es.javawarweb.web.utils.HibernateUtil;
import excepciones.HibernateSessionException;

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
	public void consultar(Long id) throws HibernateSessionException {
		try {
            tx = session.beginTransaction();
            Alienigenas alienigenas = session.find(Alienigenas.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            throw new HibernateSessionException("Ha habido un error al consultar, error: " + e.getMessage());
        }
    }
	}


