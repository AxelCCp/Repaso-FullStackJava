package B1_MetaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A0_222_InfoMetaDatos {
	public static void main (String[]args) {
		mostrarInfoBBDD();
	}
	
	
	static void mostrarInfoBBDD() {
		Connection miConexion=null;
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2", "root", "");	
			//OBTENCIÓN DE METADATOS
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			//MOSTRAMOS LA INFORMACIÓN DE LA BASE DE DATOS
			//getDatabaseProductName(): DEVUELVE EL NOMBRE DEL PRODUCTO DE LA BBDD.
			System.out.println("Gestor BBDD: " + datosBBDD.getDatabaseProductName());
			//getDatabaseProductVersion(): DEVUELVE LA VERSIÓN.
			System.out.println("Versión del gestor: " + datosBBDD.getDatabaseProductVersion());
			//
			System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
			//
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
}



