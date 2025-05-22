package es.javawarweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.entities.Tanque;
import es.javawarweb.utils.HibernateUtil;

public class TanqueDAOImpl implements TanqueDAO {

	private Session session;
	private Transaction tx;

	public TanqueDAOImpl() {

		session = HibernateUtil.getSession();
	}

	@Override
	public void insertar(Tanque tanque) {
		try {
			tx = session.beginTransaction();
			session.persist(tanque);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void eliminar(Long id) {
		try {
			tx = session.beginTransaction();
			Tanque tanque = session.find(Tanque.class, id);
			if (tanque != null) {
				session.remove(tanque);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void actualizar(Tanque tanque) {
		try {
			tx = session.beginTransaction();
			session.merge(tanque);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public List<Tanque> consultar(Long id) {
		List<Tanque> tanques = null;
		try {
			tx = session.beginTransaction();
			 tanques = session.createQuery("FROM Tanque t WHERE t.id = :id", Tanque.class)
					.setParameter("id", id).list();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

		return tanques;
	}
}
