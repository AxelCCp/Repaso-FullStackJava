package B3_AplicacionFinal_V2;


import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

public class A0_224_AplicacionUniversal_V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(350,50,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);		
		
		add(comboTablas, BorderLayout.NORTH);
		
		//LLAMADA A MÉTODOS
		conectarBBDD();
		obtenerTablas();
			
		}
	
	//MÉTODO QUE CONECTA CON LA BASE DE DATOS
	public void conectarBBDD() {
		miConexion=null;
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//MÉTODO QUE CARGA EL JCOMBOBOX CON LAS TABLAS DE LA BASE DE DATOS 
	public void obtenerTablas() {
		ResultSet miResultSet = null;
		try {
			//CREAMOS OBJ DatabaseMetaData, PARA ALMACENAR LOS METADATOS DE LA BBBDD
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			//ALMACENAMOS EN miResultSet LAS TABLAS QUE HAY EN LA BBDD
			miResultSet = datosBBDD.getTables("pruebas2", null, null, null);
			//RECORREMOS EL RESULTSET
			while(miResultSet.next()) {
				//EXTRAEMOS LOS STRING'S
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miConexion;
	
	
	
}

