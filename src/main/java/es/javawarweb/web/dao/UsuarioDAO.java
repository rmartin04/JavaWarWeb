package es.javawarweb.web.dao;

import java.util.List;

import es.javawarweb.web.dto.UsuarioDTO;
import es.javawarweb.web.entities.UsuarioEntity;
import excepciones.HibernateSessionException;

public interface UsuarioDAO {
	
	List<UsuarioEntity> findAll() throws HibernateSessionException;
	
	UsuarioEntity findUser(String usuario, String contrasenia) throws HibernateSessionException;
	
	boolean insert(UsuarioEntity usuario) throws HibernateSessionException;
}
