package es.javawarweb.web.dao;

import es.javawarweb.web.entities.Humanos;

public interface HumanosDAO {
	// CRUD operations for Humanos
	void insertar(Humanos humanos);

	void eliminar(Long id);

	void actualizar(Humanos humanos);

	Humanos consultar(Long id);

}
