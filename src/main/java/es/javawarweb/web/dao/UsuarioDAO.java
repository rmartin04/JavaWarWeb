package es.javawarweb.web.dao;

import java.util.List;

import es.javawarweb.web.entities.UsuarioEntity;
import excepciones.HibernateSessionException;

public interface UsuarioDAO {
	
	List<UsuarioEntity> findAll() throws HibernateSessionException;
	
	UsuarioEntity findById(UsuarioEntity usuario) throws HibernateSessionException;
	
	UsuarioEntity insert(UsuarioEntity usuario) throws HibernateSessionException;
}
