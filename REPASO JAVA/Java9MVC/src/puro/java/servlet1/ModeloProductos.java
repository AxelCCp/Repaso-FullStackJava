package puro.java.servlet1;

import java.sql.Connection;
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
	
	//VARIABLE DONDE SE ALMACENARÁ EL POOL DE CONEXIÓN
	private DataSource origenDatos;
}
