package es.javawarweb.dao;

import java.util.List;

import es.javawarweb.entities.NaveDestructora;

public interface NaveDestructoraDAO {
	
	// CRUD operations for NaveDestructora
	void insertar(NaveDestructora naveDestructora);

	void eliminar(Long id);

	void actualizar(NaveDestructora naveDestructora);

	List<NaveDestructora> consultar(Long id);

}
