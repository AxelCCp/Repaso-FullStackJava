package A5_Modelo;

//EN EL PAQUETE CONTROLADOR PONEMOS LA CONEXI�N

import java.sql.Connection;
import java.sql.DriverManager;

public class A0_211_Conexion {
	public A0_211_Conexion() {	
	}
	
	//M�TODO QUE CREA LA CONEXI�N 
	public Connection dameConexion() {
		try {
			//1.CREAR CONEXI�N:::
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
		}catch(Exception e) {
			
		}
		return miConexion;
	}
	Connection miConexion=null;
}
