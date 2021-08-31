package puro.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroDeUsuarios
 */
@WebServlet("/ServletRegistroDeUsuarios")
public class ServletRegistroDeUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistroDeUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		salida.println("Nombre ingresado: " + request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido ingresado: " + request.getParameter("apellido"));
		salida.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//INDICAMOS QUE EL CONTENIDO DE LA RESPUESTA SERÁ EN HTML
		response.setContentType("text/html");
		
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		salida.println("Nombre ingresado: " + request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido ingresado: " + request.getParameter("apellido"));
		salida.println("</body></html>");
	}

}
