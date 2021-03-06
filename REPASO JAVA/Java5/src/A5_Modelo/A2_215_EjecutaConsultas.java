package A5_Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//CREAMOS CONEXI?N CON LA BBDD Y HACEMOS CONSULTAS PREPARADAS

public class A2_215_EjecutaConsultas {
	
	public A2_215_EjecutaConsultas() {
		miConexion = new A0_211_Conexion(); 
	}
	
	
	//M?TODO QUE HACE LAS CONSULTAS (PARA ALMACENAR SECCI?N, PARA ALMACENAR PA?S) 
	//EL METODO RECIBE LOS ITEMS SELECCIONADOS EN EL JCOMBOBOX.
	public ResultSet fitraBBDD(String seccion, String pais) {
		
		Connection conecta = miConexion.dameConexion();
		rs=null;

		try {
			//"seccion" Y "pais" = ALMACENAN LO QUE QUE EL USUARIO SELECCION? EN EL JCOMBOBOX 
			
		if(!seccion.equals("Todos") && pais.equals("Todos")) {
			enviaConsultaSeccion=conecta.prepareStatement(consultaSeccion);
			enviaConsultaSeccion.setString(1, seccion);
			rs=enviaConsultaSeccion.executeQuery();
		}
		
		else if(seccion.equals("Todos") && !pais.equals("Todos")) {
			enviaConsultaPais= conecta.prepareStatement(consultaPais);
			enviaConsultaPais.setString(1, pais);
			rs=enviaConsultaPais.executeQuery();
		}
		else {
			enviaConsultaTodos=conecta.prepareStatement(consultaTodos);
			enviaConsultaTodos.setString(1, seccion);
			enviaConsultaTodos.setString(2, pais);
			rs=enviaConsultaTodos.executeQuery();
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return rs;
	}
	
	
	private A0_211_Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsultaSeccion;
	private final String consultaSeccion="SELECT NOMBREART?CULO, SECCI?N, PRECIO, PA?SDEORIGEN FROM PRODUCTOS"
										+ " WHERE SECCI?N=?";
	private PreparedStatement enviaConsultaPais;
	private final String consultaPais="SELECT NOMBREART?CULO, SECCI?N, PRECIO, PA?SDEORIGEN FROM PRODUCTOS "
										+ "WHERE PA?SDEORIGEN=?";
	private PreparedStatement enviaConsultaTodos;
	private final String consultaTodos= "SELECT NOMBREART?CULO, SECCI?N, PRECIO, PA?SDEORIGEN FROM PRODUCTOS "
										+ "WHERE SECCI?N=? AND PA?SDEORIGEN=?";
			
}
