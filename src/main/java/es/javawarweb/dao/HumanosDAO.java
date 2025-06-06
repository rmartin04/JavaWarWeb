package es.javawarweb.dao;

import java.util.List;

import es.javawarweb.entities.Humanos;

public interface HumanosDAO {
	// CRUD operations for Humanos
	void insertar(Humanos humanos);

	void eliminar(Long id);

	void actualizar(Humanos humanos);

	List<Humanos> consultar(Long id);

}
