package es.javawarweb.web.dto;

public class UsuarioDTO {
	
	private Long id;
	private String nombre;
	private String email;
	private String contrasenia;
	
	// Constructores
	public UsuarioDTO() {}
	
	public UsuarioDTO(String email, String contrasenia) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	public UsuarioDTO(String email, String contrasenia, String nombre) {
		this(email, contrasenia);
		this.nombre = nombre;
	}
	
	// Getter and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Email: ").append(email).append("\n");
		sb.append("Contraseña: ").append(contrasenia);
		return sb.toString();
	}
}
