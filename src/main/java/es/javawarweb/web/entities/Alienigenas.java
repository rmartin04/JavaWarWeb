package es.javawarweb.web.entities;

import es.javawarweb.web.clases.Guerrero;
import excepciones.FuerzaGuerreroException;
import excepciones.FuerzaYResistenciaException;
import excepciones.ResistenciaGuerreroException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ALIENIGENAS")
public class Alienigenas extends Guerrero {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private Long id;
		
	    private int idGuerrero;
	    private String tipoGuerrero;
	    private int fuerzaBase;
	    private int resistencia;


	public Alienigenas() {
		super();
	}
	 public Alienigenas(String tipoGuerrero, int fuerzaBase, int resistencia)
	            throws FuerzaYResistenciaException, FuerzaGuerreroException, ResistenciaGuerreroException {
	        super(tipoGuerrero, fuerzaBase, resistencia);
	    }

	
	

}
