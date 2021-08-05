package B0_TransaccionesEnBBDD;
//LAS TRANSACCIONESSON INSTRUCCIONES SQL QUE FUNCIONAN COMO BLOQUE
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A0_220_InsertaPedidosClientes {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Connection miConexion=null;
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2", "root", "");				
			
			//HACEMOS QUE LAS INSTRUCCIONES SQL FUNCIONEN COMO BLOQUE. QUE FUNCIONEN TODAS O NINGUNA.
			miConexion.setAutoCommit(false); // CON FALSE LE DECIMO QUE TRATE A LAS INSTRUCCIONES EN BLOQUE. 
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    
		    //USAMOS EL MÉTODO COMMIT PARA DARLE EL OK A TODO EL BLOQUE DE INSTRUCCIONES
		    miConexion.commit();
		    				    
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			
			//SI ALGO VA MAL, LE HACEMOS ROLLBACK A LA BASE DE DATOS
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();	
								
			}
	}
}
