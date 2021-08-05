package A9_ProcedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class A1_219_ActualizaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nPrecio = JOptionPane.showInputDialog("Ingresa precio: ");
		String nArticulo = JOptionPane.showInputDialog("Ingresa nombre del art�culo: ");
		
		try {
			//1.CREAR CONEXI�N:::
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			//?,?PAR�METROS 
			CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?,?)}");
			//LE PASAMOS LOS PAR�METROS
			miSentencia.setString(1, nPrecio);
			miSentencia.setString(2, nArticulo);
			//USAMOS M�TODO EXECUTE()
			miSentencia.execute();
			System.out.println("Actualizaci�n ok");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
