package es.javawarweb.web.dao;

import java.util.List;

import es.javawarweb.web.entities.Tanque;

public interface TanqueDAO {
	// CRUD operations for Tanque
	void insertar(Tanque tanque);

	void eliminar(Long id);

	void actualizar(Tanque tanque);

	List<Tanque> consultar(Long id);

	
}
