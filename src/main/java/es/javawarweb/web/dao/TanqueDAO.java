package es.javawarweb.web.dao;

import es.javawarweb.web.entities.Tanque;

public interface TanqueDAO {
	// CRUD operations for Tanque
	void insertar(Tanque tanque);

	void eliminar(Long id);

	void actualizar(Tanque tanque);

	Tanque consultar(Long id);

	
}
