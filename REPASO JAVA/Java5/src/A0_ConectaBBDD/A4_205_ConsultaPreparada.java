package A0_ConectaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A4_205_ConsultaPreparada {

	public static void main(String[] args) {
		
		
		try {
			//1.CREAR LA CONEXI�N
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//2.PREPARAR LA CONSULTA, PARA ESTO USAMOS LA INTERFAZ PREPAREDSTATEMENT
			//?:SON PAR�METROS
			PreparedStatement miSentencia = miConexion.prepareStatement(
					"SELECT NOMBREART�CULO, SECCI�N, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=? AND PA�SDEORIGEN=?");
			
			//3.ESTABLECER PAR�METROS DE CONSULTA
								//(N�DE PAR�METRO,"deportes")
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2,"USA");
			
			//4.EJECUTAR Y RECORRER CONSULTA
			ResultSet rs = miSentencia.executeQuery();
			
			//USAMOS �NDICES EN VEZ DEL NOMBRE DE LA COLUMNA. EL �NDICE ES EL N� DE COLUMNA, DE IZQUIERDA A DERECHA 
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			//LIBERAMOS MEMORIA
			rs.close();
			
			//////////////////////REUTILIZACI�N DE CONSULTA////////////////////
			
			System.out.println("\nEJECUCI�N DE SEGUNDA CONSULTA\n");
			
			//3.ESTABLECER PAR�METROS DE CONSULTA
			//(N�DE PAR�METRO,"deportes")
			miSentencia.setString(1, "cer�mica");
			miSentencia.setString(2,"China");

			//4.EJECUTAR Y RECORRER CONSULTA
			rs = miSentencia.executeQuery();
 
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
