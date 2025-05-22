package es.javawarweb.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.web.entities.Humanos;
import es.javawarweb.web.utils.HibernateUtil;

public class HumanosDAOImpl implements HumanosDAO {
	private Session session;
	private Transaction tx;

	public HumanosDAOImpl() {
		session = HibernateUtil.getSession();
	}

	// Implement CRUD operations for Humanos
	@Override
	public void insertar(Humanos humanos) {
		try {
			tx = session.beginTransaction();
			session.persist(humanos);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("Error al insertar, error: " + e.getMessage());
		}
	   
	}



	@Override
	public void eliminar(Long id) {
		try {
			tx = session.beginTransaction();
			Humanos humanos = session.find(Humanos.class, id);
			if (humanos != null) {
				session.remove(humanos);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("Error al eliminar, error: " + e.getMessage());
		}
	}

	@Override
	public void actualizar(Humanos humanos) {
		try {
			tx = session.beginTransaction();
			session.merge(humanos);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("Error al actualizar, error: " + e.getMessage());
		}
	}

	@Override
	public List<Humanos> consultar(Long id) {
		try {
			tx = session.beginTransaction();
			List<Humanos> humanos = session.createQuery("FROM Humanos", Humanos.class).list();
			tx.commit();
			return humanos;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("Error al consultar, error: " + e.getMessage());
		}
	}

}
