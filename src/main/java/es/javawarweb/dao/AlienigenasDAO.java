package es.javawarweb.dao;

import java.util.List;

import com.warsrpingbootjava.WarSpringJava.entities.Alienigenas;

import es.javawarweb.excepciones.HibernateSessionException;

public interface AlienigenasDAO {
	    // CRUD operations for Alienigenas
		void insertar(Alienigenas alienigenas) throws HibernateSessionException;
		void eliminar(Long id) throws HibernateSessionException;
		void actualizar(Alienigenas alienigenas) throws HibernateSessionException;
		List<Alienigenas> consultar() throws HibernateSessionException;

}
