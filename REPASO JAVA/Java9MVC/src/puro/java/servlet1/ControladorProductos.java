package puro.java.servlet1;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//EL INIT() ES CÓMO EL MÉTODO MAIN DE LOS SERVLETS, DESDE EL CUAL ARRANCARÁ LA APP 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		//CONECTAMOS CON EL MODELO PASÁNDOLE, POR PARÁMETRO AL CONSTRUCTOR, LA INFORMACIÓN DEL POOL DE CONEXIÓN
		modeloProductos = new ModeloProductos(miPool);
		}catch(Exception e) {
			//SI NO CONECTA CON EL MODELO, LANZA UNA SERVLET EXCEPTION
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//OBTENER LA LISTA DE PRODUCTOS DESDE EL MODELO
		List<Productos>productos;
		try {
			productos=modeloProductos.getProductos();
		
			//AGREGAMOS LA LISTA DE PRODUCTOS AL REQUEST
			request.setAttribute("LISTAPRODUCTOS", productos);
		
			//ENVIAR ESE REQUEST A LA PÁGINA JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			miDispatcher.forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	//VARIABLE PARA CONECTAR AL SERVLETCONTROLADOR CON EL MODELO
	private ModeloProductos modeloProductos;
	
	//DEFINIMOS EL DATASOURCE, PONEMOS EL NOMBRE DEL POOL DE CONEXIONES Y ALMACENAMOS EL POOL EN UNA VARIABLE DE TIPO DATASOURCE
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	
}
