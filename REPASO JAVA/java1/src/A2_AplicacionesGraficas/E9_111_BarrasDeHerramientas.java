package A2_AplicacionesGraficas;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class E9_111_BarrasDeHerramientas {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Barra mimarco=new Marco_Barra();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}

class Marco_Barra extends JFrame{
	public Marco_Barra(){
		setTitle("Marco con Barra");
		setBounds(500,300,600,450);
		lamina=new JPanel();
		add(lamina);
		// configuración de acciones
		Action accionAzul=new AccionColor("Azul", new ImageIcon("src/A2_AplicacionesGraficas/iconos/Blue Ball.png"), Color.BLUE);
		Action accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/A2_AplicacionesGraficas/iconos/Yellow Ball.png"), Color.YELLOW);
		Action accionRojo=new AccionColor("Rojo", new ImageIcon("src/A2_AplicacionesGraficas/iconos/Red Ball.png"), Color.RED);	
		Action accionSalir = new AbstractAction("Salir",new ImageIcon("src/A2_AplicacionesGraficas/iconos/Remove.png")) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
		//
		JMenu menu = new JMenu("Color");
		menu.add(accionAmarillo);
		menu.add(accionAzul);
		menu.add(accionRojo);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menu);
		setJMenuBar(barraMenu); //CON ESTE MÉTODO ANCLAMOS LA BARRA DIRECTAMENTE AL MARCO:
		//
		//CONSTRUCCIÓN DE BARRA DE HERRAMIENTAS
		JToolBar barra = new JToolBar();
		barra.add(accionAmarillo);
		barra.add(accionAzul);
		barra.add(accionRojo);
		barra.addSeparator();
		barra.add(accionSalir);
		add(barra,BorderLayout.NORTH);//PARA PODER MOVER LA BARRA, HAY QUE PONERLA EN DISPOSICION BORDERLAYOUT
	}
	
	private class AccionColor extends AbstractAction{
		public AccionColor(String nombre, Icon icono, Color c){
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			putValue("Color", c);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color c=(Color) getValue("Color");
			lamina.setBackground(c);
		}		
	}
	private JPanel lamina;
}



