package es.javawarweb.web.dao;

import java.util.List;

import es.javawarweb.web.entities.Alienigenas;
import excepciones.HibernateSessionException;

public interface AlienigenasDAO {
	    // CRUD operations for Alienigenas
		void insertar(Alienigenas alienigenas) throws HibernateSessionException;
		void eliminar(Long id) throws HibernateSessionException;
		void actualizar(Alienigenas alienigenas) throws HibernateSessionException;
		List<Alienigenas> consultar() throws HibernateSessionException;

}
