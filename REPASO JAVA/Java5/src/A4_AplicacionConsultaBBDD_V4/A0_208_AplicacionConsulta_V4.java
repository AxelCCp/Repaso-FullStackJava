package A4_AplicacionConsultaBBDD_V4;

//206----------
//CARGAMOS LOS JCOMBOBOX
//207----------
//CREAMOS CONSULTAS PREPARADAS PARA LOS JCOMBOBOX.
//208----------
//RESETEAMOS EL JTEXTAREA PARA QUE NO SE VAYAN SUMANDO LAS CONSULTAS.
//CONFIGURAMOS JCOMBOBOX PAISES
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class A0_208_AplicacionConsulta_V4 {

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
		
		//PONEMOS EL BOTÓN A LA ESCUCHA
		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ejecutaConsulta();//LLAMAMOS AL MÉTODO
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//CONEXION CON BBDD
		
		try {
			/////////////CARGA JCOMBOBOX "SECCIONES"////////////////
			
			//1.CREAR CONEXIÓN:::
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			
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
	
	//MÉTODO QUE REALIZACONSULTA 
	private void ejecutaConsulta() {
		ResultSet rs = null;
		try {
			//
			resultado.setText("");//RESETEAMOS JTEXTAREA
			//ALMACENAMOS ITEM SELECCIONADOS EN JCOMBOBOX 
			String seccion = (String) secciones.getSelectedItem();
			String pais = (String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos")&&pais.equals("Todos")) {
				//CARGAMOS AL OBJ PreparedStatement CON LA CONSULTA PREPARADA 
				enviaConsultaSeccion = miConexion.prepareStatement(consultaSeleccion); 
				//LE PASAMOS EL VALOR DEL PARÁMETRO "?" A LA CONSULTA. ÍNDICE "1" Y LA VARIABLE "seccion"...
				//... YA QUE AQUÍ SE ALMACENA EL ITEM SELECCIONADO.
				enviaConsultaSeccion.setString(1, seccion);
				//REALIZAMOS CONSULTA
				rs = enviaConsultaSeccion.executeQuery();
			
			}else if(seccion.equals("Todos")&& !pais.equals("Todos")) {
				
				enviaConsultaPais = miConexion.prepareStatement(consultaPais); 
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
			
			}else if(!seccion.equals("Todos")&& !pais.equals("Todos")) {
				
				enviaConsultaTodos = miConexion.prepareStatement(consultaTodos); 
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
			}
				
			//RECORREMOS EL RESULTSET
			while(rs.next()) {
				resultado.append(rs.getString(1));//NOMBREARTÍCULO
				resultado.append(", ");
				resultado.append(rs.getString(2));//SECCIÓN
				resultado.append(", ");
				resultado.append(rs.getString(3));//PRECIO
				resultado.append(", ");
				resultado.append(rs.getString(4));//PAÍSDEORIGEN
				resultado.append("\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		
	private Connection miConexion;
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaSeleccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?"; 
	
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS "
										+ "WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	
}


