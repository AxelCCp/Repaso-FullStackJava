package puro.java.servlet;

//ESTE SERVLET ES EL CONTROLADOR QUE COMUNICA CON EL MODELO(LA BASE DE DATOS)
//Y GESTIONA LAS VISTAS JSP PARA EL USUARIO. 


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String[]productos= {"Destornillador", "Serrucho", "Taladro", "Tornillo"};
		//CREAMOS EL ATRIBUTO DE OBJ REQUEST Y ALMACENAMOS LA INFORMACIÓN:
		request.setAttribute("listaProductos", productos);
		//CREAMOS UN DESPACHADOR DE SOLICITUDES:
		RequestDispatcher despachador = request.getRequestDispatcher("/Vista1.jsp");
		//
		despachador.forward(request, response);
		*/
		
		//ESPECIFICAMOS FORMATO DE RESPUESTA ---------------------------------------------------------------
		PrintWriter salida = response.getWriter();
		//GENERAR RESPUESTA DE LA PETICIÓN
		salida.println("<html><body>");
		salida.println("<h1 style='text-aling:center'> Prueba Servlet </h1>");
		salida.println("");
		salida.println("");
		salida.println("");
		salida.println("Fecha y hora actual " + new Date());
		salida.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
