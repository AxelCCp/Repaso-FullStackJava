package A5_Modelo;
//ESTA CLASE USA LA CONEXI�N, PARA HACER LAS CONSULTAS SQL. 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class A1_211_CargaMenus {
	
	public A1_211_CargaMenus() {
		miConexion = new A0_211_Conexion();
	}
	
	//M�TODO QUE REALIZA LAS CONSULTAS A SECCI�N Y PAISES
	public String ejecutaConsultas() {
		
		A0_211_Productos miProducto = null;
		//LLAMAMOS AL M�TODO QUE CONECTA CON LA BBDD Y ALMACENAMOS LA INFORMACI�N EN UNA VARIABLE Connection
		Connection accesoBBDD = miConexion.dameConexion();
		try {
			
			//LA CLASE STATEMENT ES PARA CONSULTAS NO PREPARADAS. 
			//MIENTRAS QUE  LA CLASE PREPAREDSTATEMENT ES PARA CONSULTAS PREPARADAS.
			Statement secciones = accesoBBDD.createStatement();
			Statement paises = accesoBBDD.createStatement();
			rs=secciones.executeQuery("SELECT DISTINCTROW SECCI�N FROM PRODUCTOS");
			rs2=paises.executeQuery("SELECT DISTINCTROW PA�SDEORIGEN FROM PRODUCTOS");
			
			miProducto = new A0_211_Productos();    //INICIAMOS VARIABLE OBJ DE PRODUCTOS.
			miProducto.setSeccion(rs.getString(1)); //LLAMAMOS AL SETTER DE SECCION Y EN EL PAR�METRO ESTABLECEMOS LA COLUMNA 1, SEG�N LA CONSULTA SQL. 
			miProducto.setpOrigen(rs2.getString(1));
			rs.close();
			rs2.close();
			accesoBBDD.close();
			
		}catch(Exception e) {
			//e.printStackTrace();
		}
		//CON EL GET RESPECTIVO NOS DEVUELVE LAS DIFERENTES SECCIONES "SIN REPETIRLAS", GRACIAS A "DISTINCTROW"
		return miProducto.getSeccion();  
	}
	

	public A0_211_Conexion miConexion;
	public ResultSet rs;
	public ResultSet rs2;
}
