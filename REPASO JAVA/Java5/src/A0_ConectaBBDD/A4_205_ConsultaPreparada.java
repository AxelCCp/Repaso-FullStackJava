package A0_ConectaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A4_205_ConsultaPreparada {

	public static void main(String[] args) {
		
		
		try {
			//1.CREAR LA CONEXIÓN
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//2.PREPARAR LA CONSULTA, PARA ESTO USAMOS LA INTERFAZ PREPAREDSTATEMENT
			//?:SON PARÁMETROS
			PreparedStatement miSentencia = miConexion.prepareStatement(
					"SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			//3.ESTABLECER PARÁMETROS DE CONSULTA
								//(N°DE PARÁMETRO,"deportes")
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2,"USA");
			
			//4.EJECUTAR Y RECORRER CONSULTA
			ResultSet rs = miSentencia.executeQuery();
			
			//USAMOS ÍNDICES EN VEZ DEL NOMBRE DE LA COLUMNA. EL ÍNDICE ES EL N° DE COLUMNA, DE IZQUIERDA A DERECHA 
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			//LIBERAMOS MEMORIA
			rs.close();
			
			//////////////////////REUTILIZACIÓN DE CONSULTA////////////////////
			
			System.out.println("\nEJECUCIÓN DE SEGUNDA CONSULTA\n");
			
			//3.ESTABLECER PARÁMETROS DE CONSULTA
			//(N°DE PARÁMETRO,"deportes")
			miSentencia.setString(1, "cerámica");
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
