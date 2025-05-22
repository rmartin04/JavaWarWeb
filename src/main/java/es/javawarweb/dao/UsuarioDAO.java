package es.javawarweb.dao;

import java.util.List;

import es.javawarweb.dto.UsuarioDTO;
import es.javawarweb.entities.UsuarioEntity;
import es.javawarweb.excepciones.HibernateSessionException;

public interface UsuarioDAO {
	
	List<UsuarioEntity> findAll() throws HibernateSessionException;
	
	UsuarioEntity findUser(String usuario, String contrasenia) throws HibernateSessionException;
	
	boolean insert(UsuarioEntity usuario) throws HibernateSessionException;
}
