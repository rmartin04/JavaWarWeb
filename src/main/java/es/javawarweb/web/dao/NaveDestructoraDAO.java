package es.javawarweb.web.dao;

import es.javawarweb.web.entities.NaveDestructora;

public interface NaveDestructoraDAO {
	
	// CRUD operations for NaveDestructora
	void insertar(NaveDestructora naveDestructora);

	void eliminar(Long id);

	void actualizar(NaveDestructora naveDestructora);

	NaveDestructora consultar(Long id);

}
