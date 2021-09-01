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
	
	//EL INIT() ES C�MO EL M�TODO MAIN DE LOS SERVLETS, DESDE EL CUAL ARRANCAR� LA APP 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		//CONECTAMOS CON EL MODELO PAS�NDOLE, POR PAR�METRO AL CONSTRUCTOR, LA INFORMACI�N DEL POOL DE CONEXI�N
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
		
		//LEER PAR�METRO QUE LE LLEGA DESDE EL FORMULARIO (del hidden!). 
		String elComando = request.getParameter("instruccion");
		//SI NO SE ENV�A EL PAR�METRO, LISTAR PRODUCTOS
		if(elComando==null) elComando="listar";
		
		//REDIRIGIR EL FLUJO DE EJECUCI�N AL M�TODO ADECUADO, M�TODO QUE OBTENGA LOS PRODUCTOS / O QUE INSERTE LOS PRODUCTOS.
		switch(elComando) {
			case "listar":
				obtenerProductos(request,response);	
				break;
				
			case "insertarBBDD":
				agregarProductos(request,response);
				break;
				
			case "cargar":
				try {
					cargaProductos(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case "actualizarBBDD":
				try {
					actualizaProductos(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "eliminar":
				try {
					eliminarProducto(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			default:
				obtenerProductos(request,response);	
		}	
	}

	


	//M�TODO QUE OBTIENE LA INFORMACI�N DE LOS PRODUCTOS DE LA TABLA
	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		//OBTENER LA LISTA DE PRODUCTOS DESDE EL MODELO
		List<Productos>productos;
		try {
			productos=modeloProductos.getProductos();
				
			//AGREGAMOS LA LISTA DE PRODUCTOS AL REQUEST
			request.setAttribute("LISTAPRODUCTOS", productos);
				
			//ENVIAR ESE REQUEST A LA P�GINA JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductosConJspTags.jsp");
			miDispatcher.forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		
		//LEER LA INFORMACION DEL PRODUCTO QUE VIENE DEL FORMULARIO
		//(EN LA CLASE 257, JUAN HACE EL CASTING, YA QUE NO TODOS LOS DATOS DE SU TABLA SON STRING)
		String codArticulo = request.getParameter("CArt");
		String seccion = request.getParameter("seccion");
		String nombreArticulo = request.getParameter("NArt");
		String fecha = request.getParameter("fecha");
		String precio = request.getParameter("precio");
		String importado = request.getParameter("importado");
		String paisDeOrigen = request.getParameter("POrig");
		//CREAR UN OBJ DE TIPO PRODUCTO
		Productos nuevoProducto = new Productos(codArticulo,seccion,nombreArticulo,precio,fecha,importado,paisDeOrigen);
		//ENVIAR EL OBJ AL MODELO Y DESPU�S INSERTAR EL OBJ PRODUCTO EN LA BBDD
		try {
			modeloProductos.agregarElNuevoProducto(nuevoProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//VOLVER A LISTAR LA TABLA DE PRODUCTOS CON EL OBJ INSERTADO
		obtenerProductos(request,response);
	}

	//ESTE M�TODO LANZA UNA EXCEPTION, POR SI ES QUE OCURRE ALG�N FALLO EN LA CONEXI�N 
	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//LEER EL C�DIGOART�CULO QUE VIENE DEL LISTADO
		String codigoArticulo = request.getParameter("CArticulo");
		//COMUNICAR CON EL MODELO, ENVIAMOS EL C�DIGOART�CULO PARA QUE EL MODELO HAGA UNA CONSULTA A LA BBDD 
		Productos elProducto = modeloProductos.getProducto(codigoArticulo);
		//COLOCAR ATRIBUTO CORRESPONDIENTE AL C�DIGOART�CULO
		request.setAttribute("ProductoActualizar", elProducto);
		//ENVIAR PRODUCTO AL FORMULARIO DE ACTUALIZAR
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaProducto.jsp");
		dispatcher.forward(request, response);
	}
	
	//ESTE M�TODO ACTUALIZA LA INFORMACI�N DEL PRODUCTO, SEG�N LOS DATOS QUE CAMBI� EL USUARIO EN ActualizaProductos.jsp 
	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//LEER LOS DATOS QUE VIENE DEL FORMULARIO DE ACTUALIZAR
		String codArticulo = request.getParameter("CArt");
		String seccion = request.getParameter("seccion");
		String nombreArticulo = request.getParameter("NArt");
		String fecha = request.getParameter("fecha");
		String precio = request.getParameter("precio");
		String importado = request.getParameter("importado");
		String paisDeOrigen = request.getParameter("POrig");
		//CREAR UN OBJ DE TIPO PRODUCTO CON LA INFORMACI�N QUE VIENE DEL FORMULARIO
		Productos productoActualizado = new Productos(codArticulo,seccion,nombreArticulo,precio,fecha,importado,paisDeOrigen);
		//ACTUALIZAR LA BASE DE DATOS CON LA INFORMACI�N DEL OBJ PRODUCTO
		modeloProductos.actualizarProducto(productoActualizado);
		//VOLVER AL LISTADO CON LA INFORMACI�N ACTUALIZADA
		obtenerProductos(request,response);
	}
	
	//M�TODO QUE ELIMINA REGISTROS
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// CAPTURAR EL C�DIGO ART�CULO
		String codArticulo = request.getParameter("CArticulo");
		//BORRAR PRODUCTO DE LA BASE DE DATOS
		modeloProductos.eliminarProducto(codArticulo);
		//VOLVER AL LISTADO DE PRODUCTOS
		obtenerProductos(request,response);
	}
	
	

	//VARIABLE PARA CONECTAR AL SERVLETCONTROLADOR CON EL MODELO
	private ModeloProductos modeloProductos;
	
	//DEFINIMOS EL DATASOURCE, PONEMOS EL NOMBRE DEL POOL DE CONEXIONES Y ALMACENAMOS EL POOL EN UNA VARIABLE DE TIPO DATASOURCE
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	
}
