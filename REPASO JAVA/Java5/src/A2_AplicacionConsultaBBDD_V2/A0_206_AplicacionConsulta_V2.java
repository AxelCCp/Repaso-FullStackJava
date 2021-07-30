package A2_AplicacionConsultaBBDD_V2;

//206----------
//CARGAMOS LOS JCOMBOBOX

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class A0_206_AplicacionConsulta_V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//CONEXION CON BBDD
		
		try {
			/////////////CARGA JCOMBOBOX "SECCIONES"////////////////
			
			//1.CREAR CONEXIÓN:::
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
			//2.CREA OBJSTATEMENT:::
			Statement sentencia = miConexion.createStatement();
			
			//3. CON DISTINCTROW NO REPITE LOS TIPOS DE SECCIONES POR PRODUCTO. 
			String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			
			//4.CREAMOS RESULTSET DONDE ALMACENAR LO QUE DEVUELVE LA CONSULTA
			ResultSet rs = sentencia.executeQuery(consulta);
			
			//5.RECORREMOS EL RESULTSET, DONDE ESTÁN LAS CATEGORÍAS DE LA COLUMNA SECCIÓN,...
			//...PARA CARGARLAS EN EL JCOMBOBOX
			while(rs.next()) {
				secciones.addItem(rs.getString(1));
			}
			rs.close();
			
			////////////JCOMBOBOX "PAÍSES"////////////////
			
			//3.
			consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			
			//4.CREAMOS RESULTSET DONDE ALMACENAR LO QUE DEVUELVE LA CONSULTA
			rs = sentencia.executeQuery(consulta);
			
			//5.RECORREMOS EL RESULTSET, DONDE ESTÁN LAS CATEGORÍAS DE LA COLUMNA PAÍSES,...
			//...PARA CARGARLAS EN EL JCOMBOBOX
			while(rs.next()) {
				paises.addItem(rs.getString(1));
			}
			rs.close();
			
		}catch(Exception e){
			System.out.println("NO CONECTA CON LA BBDD");
			e.printStackTrace();
		}
		
		
	}	
		

	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}


