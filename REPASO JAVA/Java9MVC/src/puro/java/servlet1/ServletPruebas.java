package puro.java.servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DEFINIR EL DATASOURCE / PONEMOS EL NOMBRE DEL POOL DE CONEXIONES
	// Y ALMACENAMOS EL POOL EN UNA VARIABLE DE TIPO DATASOURCE
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CREAR OBJ PRINT WRITER
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		//CREAR CONEXIÓN CON BBDD
		Connection miConexion = null;
		Statement miStatement=null;
		ResultSet miResultset=null;
		try {
			miConexion = miPool.getConnection();
			String miSql="SELECT * FROM PRODUCTOS";
			miStatement = miConexion.createStatement();
			miResultset=miStatement.executeQuery(miSql);
			
			while(miResultset.next()) {
				String nombreArticulo = miResultset.getString(3);
				salida.println(nombreArticulo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
