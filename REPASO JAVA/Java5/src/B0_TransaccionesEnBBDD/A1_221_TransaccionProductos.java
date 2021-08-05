package B0_TransaccionesEnBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class A1_221_TransaccionProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion=null;
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2", "root", "");				
			
			//HACEMOS QUE LAS INSTRUCCIONES SQL FUNCIONEN COMO BLOQUE. QUE FUNCIONEN TODAS O NINGUNA.
			miConexion.setAutoCommit(false); // CON FALSE LE DECIMO QUE TRATE A LAS INSTRUCCIONES EN BLOQUE. 
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN = 'ITALIA'"; 
		    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300"; 
		    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO = PRECIO*1.15";
		    
		    boolean ejecutar = ejecutarTransaccion();
		    
		    if(ejecutar==true) {
		    	miStatement.executeUpdate(instruccionSql_1);
		    	miStatement.executeUpdate(instruccionSql_2);
		    	miStatement.executeUpdate(instruccionSql_3);
		    	miConexion.commit();
		    	System.out.println("Se ejecutó la transacción correctamente");
		    }else {
		    	System.out.println("No se realizaron cambios en la base de datos");
		    }
		    
		}catch(Exception e) {
			
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Algo salió mal y no se ejecutaron cambio en la base de datos");
		}
	}

	static boolean ejecutarTransaccion() {
		String ejecucion =JOptionPane.showInputDialog("¿Ejecutamos transacción?");
		if(ejecucion.equals("si"))return true;
		else return false;
	}
}
