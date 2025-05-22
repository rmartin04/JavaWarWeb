package es.javawarweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.javawarweb.entities.NaveDestructora;
import es.javawarweb.utils.HibernateUtil;

public class NaveDestructoraDAOImpl implements NaveDestructoraDAO {
	private Session session;
	private Transaction tx;

	public NaveDestructoraDAOImpl() {
		session = HibernateUtil.getSession();
	}
	
	
	@Override
	public void insertar(NaveDestructora naveDestructora) {
		try {
			tx = session.beginTransaction();
			session.persist(naveDestructora);
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
			NaveDestructora naveDestructora = session.find(NaveDestructora.class, id);
			if (naveDestructora != null) {
				session.remove(naveDestructora);
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
	public void actualizar(NaveDestructora naveDestructora) {
		try {
			tx = session.beginTransaction();
			session.merge(naveDestructora);
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
	public List<NaveDestructora> consultar(Long id) {
		List<NaveDestructora> lista = null;
		try {
			tx = session.beginTransaction();
			 lista = session.createQuery("from NaveDestructora", NaveDestructora.class).list();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return lista;
		
	}
	

}
