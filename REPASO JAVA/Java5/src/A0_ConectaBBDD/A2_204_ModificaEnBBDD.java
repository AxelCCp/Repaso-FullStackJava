package A0_ConectaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class A2_204_ModificaEnBBDD {
	public static void main(String[]args) {
		
		try {
			
			//1.CREAR CONEXIÓN:::
			//OBJ DE TIPO INTERFAZ CONNECTION: 
			//CLASE DRIVERMANAGER: SE USAPARAMANEJA LOS JDBC DRIVERS
			//GETCONNECTION(): PIDE (URL,USUARIO,CONTRASEÑA). DEVUELVE OBJ CONNECTION.
			//URL...DRIVER:MYSQL//PARA TRABAJAR EN LOCAL:PUERTO/BBDD
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//2.CREA OBJSTATEMENT:::
			//CREATESTATEMENT():CREA OBJ DE TIPO STATEMENT PARA ENVIAR CONSULTAS SQL A LA BBDD.
			Statement miStatement = miConexion.createStatement();
			
			//INSTRUCCIÓN PARA INSERTAR EN TABLA PRODUCTOS
			String instruccionSql = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
			
			//EJECUTAMOS INSTRUCCIÓN
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Datos MODIFICADOS correctamente");
			
			
		}catch(Exception e){
			System.out.println("NO CONECTA CON LA BBDD");
			e.printStackTrace();
		}
		
	}

}
