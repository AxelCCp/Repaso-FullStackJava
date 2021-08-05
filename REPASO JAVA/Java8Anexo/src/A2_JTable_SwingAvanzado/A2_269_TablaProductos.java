package A2_JTable_SwingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class A2_269_TablaProductos {
	public static void main(String[]args) {
		MarcoProductos marco1 = new MarcoProductos();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}
}


class MarcoProductos extends JFrame{
	public MarcoProductos() {
		setTitle("Productos");
		setBounds(500,300,800,400);
		JPanel superior = new JPanel();
		nombresDeTablas = new JComboBox();
		
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas2","root","");
			
			datosBBDD = miConexion.getMetaData();
			
			rs = datosBBDD.getTables("pruebas2", null, null, null);
			
			while(rs.next()) {
				nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//
		
		nombresDeTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tablaSeleccionada = (String)nombresDeTablas.getSelectedItem();
				String consulta = "SELECT * FROM " + tablaSeleccionada;
				try {
					sentencia = miConexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs = sentencia.executeQuery(consulta);
					/*while(rs.next()) {
						System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getString("CÓDIGOARTÍCULO"));
					}*/
					
					modelo = new ResultSetModeloTabla(rs);
					JTable tabla = new JTable(modelo);
					add(new JScrollPane(tabla),BorderLayout.SOUTH);
					validate(); //usamos esto para que lo pinte ??
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		superior.add(nombresDeTablas);
		add(superior,BorderLayout.NORTH);
		
	}
	private JComboBox nombresDeTablas;
	private DatabaseMetaData datosBBDD;
	private ResultSet rs;
	private Connection miConexion;
	private Statement sentencia;
	private ResultSetModeloTabla modelo;
}




//CLASE QUE CONSTRUYE EL JTABLE CON LOS REGISTROS QUE VIENEN EN E RESULTSET

class ResultSetModeloTabla extends AbstractTableModel{
	
	public ResultSetModeloTabla(ResultSet unRs) {
		rsRegistros=unRs;
		try {
			resmd = rsRegistros.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return resmd.getColumnCount(); //OBTIENE LAS COLUMNAS
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		 try {
			 rsRegistros.last(); //LLEVA AL FINAL DE REGISTRO
			return rsRegistros.getRow();//OBTIENE LAS FILAS.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	//ESTABLECE LOS VALORES DE LOS REGISTROS
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		try {
			rsRegistros.absolute(arg0 + 1);
			return rsRegistros.getObject(arg1 + 1);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String getColumnName(int c) {
		try {
			return resmd.getColumnName(c+1);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private ResultSet rsRegistros;
	private ResultSetMetaData resmd;
}
