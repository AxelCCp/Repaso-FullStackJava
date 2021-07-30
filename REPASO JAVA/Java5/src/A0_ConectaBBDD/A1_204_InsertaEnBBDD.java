package A0_ConectaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class A1_204_InsertaEnBBDD {
	public static void main(String[]args) {
		
		try {
			
			//1.CREAR CONEXI�N:::
			//OBJ DE TIPO INTERFAZ CONNECTION: 
			//CLASE DRIVERMANAGER: SE USAPARAMANEJA LOS JDBC DRIVERS
			//GETCONNECTION(): PIDE (URL,USUARIO,CONTRASE�A). DEVUELVE OBJ CONNECTION.
			//URL...DRIVER:MYSQL//PARA TRABAJAR EN LOCAL:PUERTO/BBDD
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//2.CREA OBJSTATEMENT:::
			//CREATESTATEMENT():CREA OBJ DE TIPO STATEMENT PARA ENVIAR CONSULTAS SQL A LA BBDD.
			Statement miStatement = miConexion.createStatement();
			
			//INSTRUCCI�N PARA INSERTAR EN TABLA PRODUCTOS
			String instruccionSql = "INSERT INTO PRODUCTOS (C�DIGOART�CULO,NOMBREART�CULO,PRECIO) VALUES ('AR77','PANTAL�N','25.35')";
			
			//EJECUTAMOS INSTRUCCI�N
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Datos insertados correctamente");
			
			
		}catch(Exception e){
			System.out.println("NO CONECTA CON LA BBDD");
			e.printStackTrace();
		}
		
	}

}