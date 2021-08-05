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
			//OBTENCI�N DE METADATOS
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			//MOSTRAMOS LA INFORMACI�N DE LA BASE DE DATOS
			//getDatabaseProductName(): DEVUELVE EL NOMBRE DEL PRODUCTO DE LA BBDD.
			System.out.println("Gestor BBDD: " + datosBBDD.getDatabaseProductName());
			//getDatabaseProductVersion(): DEVUELVE LA VERSI�N.
			System.out.println("Versi�n del gestor: " + datosBBDD.getDatabaseProductVersion());
			//
			System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
			//
			System.out.println("Versi�n del driver: " + datosBBDD.getDriverVersion());
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



