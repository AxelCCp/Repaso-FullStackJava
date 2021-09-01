package puro.java.servlet1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//CONECTA CON LA BASE DE DATOS 
public class ModeloProductos {
	
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos=origenDatos;
	}
	
	//MÉTODO QUE OBTIENE LISTADO DE PRODUCTOS DE LA BBDD
	public List <Productos> getProductos() throws Exception{
		//LISTA DONDE SE ALMACENARÁ LA INFORMACIÓN 
		List<Productos> productos = new ArrayList<>();
		//DECLARAMOS VARIABLES PARA LA CONEXIÓN
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultset = null;
		
		//ESTABLECEMOS LA CONEXIÓN
		miConexion = origenDatos.getConnection();
		//CREAMOS LA SENTENCIA SQL Y STATEMENT
		String instruccionSql = "SELECT * FROM PRODUCTOS";
		miStatement = miConexion.createStatement();
		//EJECUTAR SENTENCIA
		miResultset = miStatement.executeQuery(instruccionSql);
		//RECORRER EL RESULTSET
		while(miResultset.next()) {
			String c_art = miResultset.getString("CÓDIGOARTÍCULO");
			String seccion = miResultset.getString("SECCIÓN");
			String n_art = miResultset.getString("NOMBREARTÍCULO");
			String precio = miResultset.getString("PRECIO");
			String fecha = miResultset.getString("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String p_orig = miResultset.getString("PAÍSDEORIGEN");
			
			//ALMACENAMOS LOS DATOS DE LAS VARIABLES EN LA VARIABLE TEMPORAL temProd
			Productos temProd = new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);
			//CARGAMOS LA LISTA
			productos.add(temProd);
		}
		
		return productos;
	}
	
	//--------------------------------------------------------------
	
	
	//ESTE MÉTODO ES LLAMADO DESDE EL CONTROLADOR E INSERTA EL OBJETO QUE LE LLEGA POR PARÁMETRO
	public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception {
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		//OBTENER LA CONEXIÓN CON LA BBDD
		try {
			miConexion = origenDatos.getConnection();
		
			
			//CREAR LA INSTRUCCIÓN SQL QUE INSERTE EL PRODUCTO
			String sql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)" +
						 "VALUES(?,?,?,?,?,?,?)";
			miStatement=miConexion.prepareStatement(sql);
			
			//ESTABLECER LOS PARÁMETROS PARA EL PRODUCTO  //EN LA CLASE 258, JUAN HACE CASTING PARA SU TABLA
			miStatement.setString(1, nuevoProducto.getcArt());
			miStatement.setString(2, nuevoProducto.getSeccion());
			miStatement.setString(3, nuevoProducto.getnArt());
			miStatement.setString(4, nuevoProducto.getPrecio());
			miStatement.setString(5, nuevoProducto.getFecha());
			miStatement.setString(6, nuevoProducto.getImportado());
			miStatement.setString(7, nuevoProducto.getpOrig());
			
			//EJECUTAR LA INSTRUCCIÓN SQL
			miStatement.execute();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
	
	
	
	public Productos getProducto(String codigoArticulo) {
		
		Productos elProducto = null;
		Connection miConexion=null;
		PreparedStatement miStatement = null;
		ResultSet miResultset=null;
		String cArticulo=codigoArticulo;
		try {
		//ESTABLECER CONEXIÓN CON LA BASE DE DATOS
		miConexion =origenDatos.getConnection();
		//CREAR SQL QUE BUSQUE EL PRODUCTO
		String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		//CREAR LA CONSULTA PREPARADA
		miStatement=miConexion.prepareStatement(sql);
		//ESTABLECER LOS PARÁMETROS
		miStatement.setString(1, cArticulo);
		//EJECUTAR LA CONSULTA
		miResultset=miStatement.executeQuery();
		//OBTENER LOS DATOS DE RESPUESTA
		if(miResultset.next()) {
			String c_art = miResultset.getString("CÓDIGOARTÍCULO"); 
			String seccion = miResultset.getString("SECCIÓN");
			String n_art = miResultset.getString("NOMBREARTÍCULO");
			String precio = miResultset.getString("PRECIO");
			String fecha = miResultset.getString("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String p_orig = miResultset.getString("PAÍSDEORIGEN");
			
			//ALMACENAMOS LOS DATOS DE LAS VARIABLES EN LA VARIABLE TEMPORAL temProd
			elProducto = new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);
		}else {
			throw new Exception("No hemos encontrado el producto con código artículo: " +  cArticulo);
		}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return elProducto;
	}
	
	
	//MÉTODO QUE RECIBE DESDE EL CONTROLADOR, LA INFORMACIÓN DEL PRODUCTO QUE ESTE MÉTODO DEBE ACTUALIZAR
	public void actualizarProducto(Productos productoActualizado) throws Exception {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		//ESTABLECER LA CONEXIÓN CON LA BASE DE DATOS
		try {
		miConexion= origenDatos.getConnection();
		//CREAR SENTENCIA SQL
		String sql = "UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO=?, PRECIO=?, FECHA=?, IMPORTADO=?, PAÍSDEORIGEN=? " +
					 "WHERE CÓDIGOARTÍCULO=?";
		//CREAR CONSULTA PREPARADA
		miStatement=miConexion.prepareStatement(sql);
		//ESTABLECER LOS PARÁMETROS
		miStatement.setString(1, productoActualizado.getSeccion());
		miStatement.setString(2, productoActualizado.getnArt());
		miStatement.setString(3, productoActualizado.getPrecio());
		miStatement.setString(4, productoActualizado.getFecha());
		miStatement.setString(5, productoActualizado.getImportado());
		miStatement.setString(6, productoActualizado.getpOrig());
		miStatement.setString(7, productoActualizado.getcArt());
		//EJECUTAR LA INSTRUCCIÓN SQL
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
		
	}
	
	
	public void eliminarProducto(String codArticulo) throws Exception {
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		//ESTABLECER LA CONEXIÓN CON LA BASE DE DATOS
		try {
		miConexion= origenDatos.getConnection();
		//CREAR INSTRUCCIÓN SQL DE ELIMINACIÓN
		String sql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		//PREPARAR LA CONSULTA
		miStatement=miConexion.prepareStatement(sql);
		//ESTABLECER PARÁMETROS DE CONSULTA. LE PASAMOS codArticulo PQ EL MÉTODO RECIBE EL CÓDIGO Y NO EL OBJ PRODUCTO CM EN LOS OTROS MÉTODOS.
		miStatement.setString(1, codArticulo);
		//EJECUTAR SENTENCIA SQL
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
	
	//VARIABLE DONDE SE ALMACENARÁ EL POOL DE CONEXIÓN
	private DataSource origenDatos;


	




	



	

	
}
