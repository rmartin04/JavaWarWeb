package es.javawarweb.service;

import java.util.List;

import es.javawarweb.dao.UsuarioDAO;
import es.javawarweb.dao.UsuarioDAOImpl;
import es.javawarweb.dto.UsuarioDTO;
import es.javawarweb.entities.UsuarioEntity;
import es.javawarweb.excepciones.HibernateSessionException;

public class UsuarioService {

	private final UsuarioDAO dao = new UsuarioDAOImpl();
	
	public List<UsuarioEntity> consultarUsuarios() throws HibernateSessionException {
		return dao.findAll();
	}
	
	public UsuarioEntity conexLogin(UsuarioDTO dto) throws HibernateSessionException {
		
		UsuarioEntity usuario = dao.findUser(dto.getContrasenia(), dto.getEmail());
		return usuario;
		
	}
	
	public void insertUser(UsuarioDTO dto) throws HibernateSessionException {
		UsuarioEntity usuario = new UsuarioEntity(dto.getUsuario(), dto.getEmail(), dto.getContrasenia());
		dao.insert(usuario);
	}
}
