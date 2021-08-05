package B5_AplicacionFinal_V4;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class A0_226_AplicacionUniversal_V4 {

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
		
		//LLAMADA A MÉTODOS
		conectarBBDD();
		obtenerTablas();
		
		//HACEMOS QUE EL JCOMBOBOX RESPONDA A EVENTOS
		comboTablas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ALMACENAMOS EL ITEM SELECCIONADO DEL COMBO
				String nombreTabla =((String)comboTablas.getSelectedItem());
				//LLAMADA AL MÉTODO QUE MUESTRA LAINFORMACIÓN DE LA TABLA
				mostrarInfoTabla(nombreTabla);
			}
		});
		
		add(comboTablas, BorderLayout.NORTH);
		}
	
	//MÉTODO QUE CONECTA CON LA BASE DE DATOS
	public void conectarBBDD() {
		
		miConexion=null;
		//PARA ALMACENAR LAS LÍNEAS DE CONEXIÓN DEL FICHERO DE TEXTO.
		String[]datos = new String [3];
		
		try {
			//USAMOS EL CONSTRUCTOR QUE RECIBE POR PARÁMETRO LA RUTA DEL ARCHIVO DE CONECXIÓN
			entrada = new FileReader("C:/Users/Boo/Downloads/PILDORAS INFORMATICAS/datos_config.txt");
			//CREAMOS FLUJO DE DATOS QUE TRAIGA LA INFORMACIÓN DEL ARCHIVO AL PROGRAMA
			BufferedReader miBuffer = new BufferedReader(entrada);
			//RECORREMOS LA INFORMACIÓN DE miBuffer Y ALMACENAMOS LA INFORMACIÓN EN EL ARRAY. i<=2 PQ SON TRES LÍNEAS LAS QUE HAY QUE LEER. 
			for(int i=0;i<=2;i++) {
				datos[i] = miBuffer.readLine();
			}
			miConexion=DriverManager.getConnection(datos[0],datos[1],datos[2]);
			entrada.close();
		
		}catch (IOException e) {
			JOptionPane.showMessageDialog(this,"No se ha encontrado el archivo de conexión");
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
	
	//MÉTODO QUE MUESTRA LA INFORMACIÓN DE LAS TABLAS
	public void mostrarInfoTabla(String tabla) {
		//CREAMOS UN ARRAYLIST PARA ALMACENAR LA INFORMACION DE LAS TABLAS. HAY QUE CREAR UNO DE ESTOS,...
		//...YA QUE LAS TABLAS DIFIEREN EN LA CANTIDAD DE COLUMNAS.
		ArrayList<String>campos = new ArrayList<String>();
		//CONSULTA CAPÁZ DE LEER CULQUIER TABLA:
		String consulta = "SELECT * FROM " + tabla; 
		
		try {
			areaInformacion.setText("");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery(consulta);
			//CREAMOS UNA VARIABLE DE TIPO ResultSetMetaData,...
			//PARA SABER LA CANTIDAD DE COLUMNAS QUE TIENE UNA TABLA CON getColumnCount().
			//TAMBN PARA SABER CÓMO SE LLAMAN LAS COLUMNAS DE LA TABLA CON getColumnLabel().
			//rsBBDD: ALMACENAMOS LOS METADATOS DEL RESULTSET.
			//for()RECORRERÁ TODOS LOS CAMPOS DE LA TABLA. 
			ResultSetMetaData rsBBDD = miResultSet.getMetaData();
			
			for(int i=1; i<=rsBBDD.getColumnCount();i++) {
				//ALMACENAMOS LOS NOMBRES DE LAS COLUMNAS AL ARRAYLIST
				campos.add(rsBBDD.getColumnLabel(i));
			}
			
			//EXTRAEMOS VUELTA A VUELTA LOS NOMBRES DE LOS CAMPOS
			while(miResultSet.next()) {
				for(String nombreCampo : campos) {
					//EXTRAEMOS LOS REGISTROS Y AGREGAMOS AL AREA DE TEXTO LA INFORMACIÓN DE LOS CAMPOS.
					areaInformacion.append(miResultSet.getString(nombreCampo) + " ");
				}
				//SALTO DE LÍNEA PARA GENERAR LAS FILAS DE LA TABLA.
				areaInformacion.append("\n");		
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miConexion;
	private FileReader entrada; 

	
	
}

