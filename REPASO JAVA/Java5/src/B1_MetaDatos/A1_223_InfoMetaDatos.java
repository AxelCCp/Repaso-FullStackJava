package B1_MetaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A1_223_InfoMetaDatos {
	public static void main (String[]args) {
		mostrarInfoBBDD();
		System.out.println("--------------------------------------------------------------");
		mostrarInfoTablas();
	}
	
	
	static void mostrarInfoBBDD() {
		Connection miConexion=null;
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2", "root", "");	
			//OBTENCIÓN DE METADATOS
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			//MOSTRAMOS LA INFORMACIÓN DE LA BASE DE DATOS
			System.out.println("Gestor BBDD: " + datosBBDD.getDatabaseProductName());
			System.out.println("Versión del gestor: " + datosBBDD.getDatabaseProductVersion());
			System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
			System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//MUESTRA LA INFORMACIÓN DE LA TABLAS QUE HAY DENTRO DE UNA BASE DE DATOS
	static void mostrarInfoTablas() {
		Connection miConexion=null;
		ResultSet miResultset=null;
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2", "root", "");	
			//OBTENCIÓN DE METADATOS
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			//LISTA DE TABLAS 
			System.out.println("Lista de tablas");
			//ALMACENAMOS TODOS LOS DATOS EN LA VARIABLE DE TIPO ResultSet, YA QUE getTables() DEVUELVE UN OBJ DE ESTE TIPO.  
			miResultset = datosBBDD.getTables("pruebas2", null, null, null);
			while(miResultset.next()) {
				//TABLE_NAME ES UNA DE LAS COLUMNAS DE UNA DE LAS TABLAS QUE CONTIENE LOS NOMBRE DE LA TABLAS.
				System.out.println(miResultset.getString("TABLE_NAME"));
			}
			
			//LISTA DE COLUMNAS DE PRODUCTOS
			System.out.println(".........................................");
			System.out.println("Campos de productos");
			miResultset = datosBBDD.getColumns(null, null, "productos", null);
			while(miResultset.next()) {
				
				System.out.println(miResultset.getString("COLUMN_NAME"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



