package es.javawarweb.servlet;

import java.io.IOException;

import es.javawarweb.dto.UsuarioDTO;
import es.javawarweb.entities.UsuarioEntity;
import es.javawarweb.excepciones.HibernateSessionException;
import es.javawarweb.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/login")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UsuarioService servicio = new UsuarioService();
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");
		String iniciarSesion = request.getParameter("iniciarSesion");
		String crearCuenta = request.getParameter("crearCuenta");
		
		UsuarioDTO dto = new UsuarioDTO(usuario, email, contrasenia);
		UsuarioEntity user = null;
		if ("iniciarSesion".equals(iniciarSesion)) {
			
			 try {
				user = servicio.conexLogin(dto);
				if (user != null) {
	                request.setAttribute("user", user);
	                request.getRequestDispatcher("/insertarGuerrero.html").forward(request, response);
	            } else {
	                // Usuario o contraseña incorrectos
	                request.setAttribute("error", "Usuario o contraseña incorrectos");
	                request.getRequestDispatcher("/login.htlm").forward(request, response);
	            }
			} catch (HibernateSessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            
			
		} else if ("crearCuenta".equals(crearCuenta)) {
			
			try {
				servicio.insertUser(dto);
			} catch (HibernateSessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
