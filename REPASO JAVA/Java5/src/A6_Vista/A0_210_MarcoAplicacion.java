package A6_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import A7_Controlador.A1_212_ControladorCargaMenus;
import A7_Controlador.A2_215_ControladorBotonEjecuta;

public class A0_210_MarcoAplicacion extends JFrame {

	public A0_210_MarcoAplicacion(){
		
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
		
		add(botonConsulta,BorderLayout.SOUTH);
		
		botonConsulta.addActionListener(new A2_215_ControladorBotonEjecuta(this));
		
		addWindowListener(new A1_212_ControladorCargaMenus(this));
	}
	
	public JComboBox secciones;
	
	public JComboBox paises;
	
	public JTextArea resultado;
}
