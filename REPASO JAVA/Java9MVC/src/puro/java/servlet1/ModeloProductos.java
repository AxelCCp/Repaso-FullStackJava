package puro.java.servlet1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

//CONECTA CON LA BASE DE DATOS 
public class ModeloProductos {
	
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos=origenDatos;
	}
	
	//M�TODO QUE OBTIENE LISTADO DE PRODUCTOS DE LA BBDD
	public List <Productos> getProductos() throws Exception{
		//LISTA DONDE SE ALMACENAR� LA INFORMACI�N 
		List<Productos> productos = new ArrayList<>();
		//DECLARAMOS VARIABLES PARA LA CONEXI�N
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultset = null;
		
		//ESTABLECEMOS LA CONEXI�N
		miConexion = origenDatos.getConnection();
		//CREAMOS LA SENTENCIA SQL Y STATEMENT
		String instruccionSql = "SELECT * FROM PRODUCTOS";
		miStatement = miConexion.createStatement();
		//EJECUTAR SENTENCIA
		miResultset = miStatement.executeQuery(instruccionSql);
		//RECORRER EL RESULTSET
		while(miResultset.next()) {
			String c_art = miResultset.getString("C�DIGOART�CULO");
			String seccion = miResultset.getString("SECCI�N");
			String n_art = miResultset.getString("NOMBREART�CULO");
			String precio = miResultset.getString("PRECIO");
			String fecha = miResultset.getString("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String p_orig = miResultset.getString("PA�SDEORIGEN");
			
			//ALMACENAMOS LOS DATOS DE LAS VARIABLES EN LA VARIABLE TEMPORAL temProd
			Productos temProd = new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);
			//CARGAMOS LA LISTA
			productos.add(temProd);
		}
		
		return productos;
	}
	
	//--------------------------------------------------------------
	
	
	//ESTE M�TODO ES LLAMADO DESDE EL CONTROLADOR E INSERTA EL OBJETO QUE LE LLEGA POR PAR�METRO
	public void agregarElNuevoProducto(Productos nuevoProducto) {
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		//OBTENER LA CONEXI�N CON LA BBDD
		try {
			miConexion = origenDatos.getConnection();
		
			
			//CREAR LA INSTRUCCI�N SQL QUE INSERTE EL PRODUCTO
			String sql = "INSERT INTO PRODUCTOS (C�DIGOART�CULO, SECCI�N, NOMBREART�CULO, PRECIO, FECHA, IMPORTADO, PA�SDEORIGEN)" +
						 "VALUES(?,?,?,?,?,?,?)";
			miStatement=miConexion.prepareStatement(sql);
			
			//ESTABLECER LOS PAR�METROS PARA EL PRODUCTO  //EN LA CLASE 258, JUAN HACE CASTING PARA SU TABLA
			miStatement.setString(1, nuevoProducto.getcArt());
			miStatement.setString(2, nuevoProducto.getSeccion());
			miStatement.setString(3, nuevoProducto.getnArt());
			miStatement.setString(4, nuevoProducto.getPrecio());
			miStatement.setString(5, nuevoProducto.getFecha());
			miStatement.setString(6, nuevoProducto.getImportado());
			miStatement.setString(7, nuevoProducto.getpOrig());
			
			//EJECUTAR LA INSTRUCCI�N SQL
			miStatement.execute();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public Productos getProducto(String codigoArticulo) {
		
		Productos elProducto = null;
		Connection miConexion=null;
		PreparedStatement miStatement = null;
		ResultSet miResultset=null;
		String cArticulo=codigoArticulo;
		try {
		//ESTABLECER CONEXI�N CON LA BASE DE DATOS
		miConexion =origenDatos.getConnection();
		//CREAR SQL QUE BUSQUE EL PRODUCTO
		String sql = "SELECT * FROM PRODUCTOS WHERE C�DIGOART�CULO=?";
		//CREAR LA CONSULTA PREPARADA
		miStatement=miConexion.prepareStatement(sql);
		//ESTABLECER LOS PAR�METROS
		miStatement.setString(1, cArticulo);
		//EJECUTAR LA CONSULTA
		miResultset=miStatement.executeQuery();
		//OBTENER LOS DATOS DE RESPUESTA
		if(miResultset.next()) {
			//String c_art = miResultset.getString("C�DIGOART�CULO"); NO LO NECESITAMOS ESTA VEZ.
			String seccion = miResultset.getString("SECCI�N");
			String n_art = miResultset.getString("NOMBREART�CULO");
			String precio = miResultset.getString("PRECIO");
			String fecha = miResultset.getString("FECHA");
			String importado = miResultset.getString("IMPORTADO");
			String p_orig = miResultset.getString("PA�SDEORIGEN");
			
			//ALMACENAMOS LOS DATOS DE LAS VARIABLES EN LA VARIABLE TEMPORAL temProd
			elProducto = new Productos(seccion,n_art,precio,fecha,importado,p_orig);
		}else {
			throw new Exception("No hemos encontrado el producto con c�digo art�culo: " +  cArticulo);
		}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return elProducto;
	}
	
	
	
	
	//VARIABLE DONDE SE ALMACENAR� EL POOL DE CONEXI�N
	private DataSource origenDatos;



	

	
}
