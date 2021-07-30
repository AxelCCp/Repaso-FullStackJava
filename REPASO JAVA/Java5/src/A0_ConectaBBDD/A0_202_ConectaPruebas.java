package A0_ConectaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class A0_202_ConectaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		//3.EJECUTAR INSTRUCCIÓN SQL:::
		ResultSet miResultset = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
		
		//4.RECORRER EL RESULTSET:::
		while(miResultset.next()) {
			System.out.println(miResultset.getString("NOMBREARTÍCULO") + "..." + miResultset.getString("CÓDIGOARTÍCULO") + "..." + miResultset.getString("PRECIO") + "..." + miResultset.getString("FECHA"));
		}
		
	}catch(Exception e){
		System.out.println("NO CONECTA CON LA BBDD");
		e.printStackTrace();
	}
		
	}
}
