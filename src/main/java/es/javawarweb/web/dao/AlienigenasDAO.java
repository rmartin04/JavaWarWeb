package es.javawarweb.web.dao;

import es.javawarweb.web.entities.Alienigenas;

public interface AlienigenasDAO {
	    // CRUD operations for Alienigenas
		void insertar(Alienigenas alienigenas);
		void eliminar(Long id);
		void actualizar(Alienigenas alienigenas);
		void consultar(Long id);

}
