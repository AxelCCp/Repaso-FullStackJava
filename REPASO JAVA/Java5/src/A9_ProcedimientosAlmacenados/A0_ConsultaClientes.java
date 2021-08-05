package A9_ProcedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class A0_ConsultaClientes {
	public static void main (String [] agrs) {
	
		
		try {
			//1.CREAR CONEXIÓN:::
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//ESTA INTERFAZ SE USA PARA REALIZAR PROCEDIMIENTOS ALMACENADOS SQL
			//CON EL OBJ Connection LLAMAMOS AL PROCEDIMIENTO ALMACENADO.
			CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}");
			ResultSet rs = miSentencia.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("no conecta");
		}
		
	}
}
