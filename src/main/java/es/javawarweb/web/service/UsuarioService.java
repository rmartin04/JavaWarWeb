package es.javawarweb.web.service;

import java.util.List;

import es.javawarweb.web.dao.UsuarioDAO;
import es.javawarweb.web.dao.UsuarioDAOImpl;
import es.javawarweb.web.dto.UsuarioDTO;
import es.javawarweb.web.entities.UsuarioEntity;
import excepciones.HibernateSessionException;

public class UsuarioService {

	private final UsuarioDAO dao = new UsuarioDAOImpl();
	
	public List<UsuarioEntity> consultarUsuarios() throws HibernateSessionException {
		return dao.findAll();
	}
	
	public UsuarioEntity conexLogin(UsuarioDTO dto) throws HibernateSessionException {
		
		UsuarioEntity usuario = dao.findUser(dto.getContrasenia(), dto.getEmail());
		return usuario;
		
	}
}
