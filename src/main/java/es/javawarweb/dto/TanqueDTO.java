package es.javawarweb.dto;

import java.util.List;

import es.javawarweb.clases.Guerrero;
import jakarta.persistence.Column;

public class TanqueDTO {
	
	    private Long idTanque;
	    private int puntosVida;	   
	    private String nombreVehiculo;	  
	    private String tipoVehiculo;	  
	    private int ataqueBase;	   
	    private int defensaBase;	  
	    private List<Guerrero> guerreros;
	    
		public TanqueDTO() {}

		public TanqueDTO(int puntosVida, String nombreVehiculo, String tipoVehiculo, int ataqueBase, int defensaBase,
				List<Guerrero> guerreros) {
			super();
			this.puntosVida = puntosVida;
			this.nombreVehiculo = nombreVehiculo;
			this.tipoVehiculo = tipoVehiculo;
			this.ataqueBase = ataqueBase;
			this.defensaBase = defensaBase;
			this.guerreros = guerreros;
		}

		public TanqueDTO(Long idTanque, int puntosVida, String nombreVehiculo, String tipoVehiculo, int ataqueBase,
				int defensaBase, List<Guerrero> guerreros) {
			super();
			this.idTanque = idTanque;
			this.puntosVida = puntosVida;
			this.nombreVehiculo = nombreVehiculo;
			this.tipoVehiculo = tipoVehiculo;
			this.ataqueBase = ataqueBase;
			this.defensaBase = defensaBase;
			this.guerreros = guerreros;
		}

		public Long getIdTanque() {
			return idTanque;
		}

		public void setIdTanque(Long idTanque) {
			this.idTanque = idTanque;
		}

		public int getPuntosVida() {
			return puntosVida;
		}

		public void setPuntosVida(int puntosVida) {
			this.puntosVida = puntosVida;
		}

		public String getNombreVehiculo() {
			return nombreVehiculo;
		}

		public void setNombreVehiculo(String nombreVehiculo) {
			this.nombreVehiculo = nombreVehiculo;
		}

		public String getTipoVehiculo() {
			return tipoVehiculo;
		}

		public void setTipoVehiculo(String tipoVehiculo) {
			this.tipoVehiculo = tipoVehiculo;
		}

		public int getAtaqueBase() {
			return ataqueBase;
		}

		public void setAtaqueBase(int ataqueBase) {
			this.ataqueBase = ataqueBase;
		}

		public int getDefensaBase() {
			return defensaBase;
		}

		public void setDefensaBase(int defensaBase) {
			this.defensaBase = defensaBase;
		}

		public List<Guerrero> getGuerreros() {
			return guerreros;
		}

		public void setGuerreros(List<Guerrero> guerreros) {
			this.guerreros = guerreros;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("TanqueDTO [idTanque=");
			builder.append(idTanque);
			builder.append(", puntosVida=");
			builder.append(puntosVida);
			builder.append(", nombreVehiculo=");
			builder.append(nombreVehiculo);
			builder.append(", tipoVehiculo=");
			builder.append(tipoVehiculo);
			builder.append(", ataqueBase=");
			builder.append(ataqueBase);
			builder.append(", defensaBase=");
			builder.append(defensaBase);
			builder.append(", guerreros=");
			builder.append(guerreros);
			builder.append("]");
			return builder.toString();
		}
		
		
		
		
	    
	    

}
