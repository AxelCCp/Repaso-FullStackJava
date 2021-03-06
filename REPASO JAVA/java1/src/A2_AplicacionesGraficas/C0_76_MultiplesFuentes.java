//VARIAS FUENTES Y 1 OYENTE
package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class C0_76_MultiplesFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco1 = new MarcoAccion();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}
}

class MarcoAccion extends JFrame{
	public MarcoAccion() {
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		PanelAccion lamina = new PanelAccion();
		add(lamina);
	}
}

class PanelAccion extends JPanel{
	public PanelAccion() {
		
		//INSTANCIAMOS LA CLASE OYENTE
		AccionColor accionAmarillo = new AccionColor("Amarillo",new ImageIcon("src/A2_AplicacionesGraficas/iconos/Yellow Ball.png"),Color.YELLOW);
		AccionColor accionAzul = new AccionColor("Azul",new ImageIcon("src/A2_AplicacionesGraficas/iconos/Blue Ball.png"),Color.BLUE);
		AccionColor accionRojo = new AccionColor("Rojo",new ImageIcon("src/A2_AplicacionesGraficas/iconos/Red Ball.png"),Color.RED);
		
		//PARA CREAR LOS BOTONES AHORA USAMOS UN CONSTRUCTOR DE JBUTTON QUE ACEPTA UN ARGUMENTO DE TIPO ACTION
		JButton botonAmarillo = new JButton(accionAmarillo);
		add(botonAmarillo);
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		
		//CLASE 79
		//1.-CREAR MAPA DE ENTRADA LE DECIMOS AL PROGRAMA DONDE VAN A INSIDIR LAS COMBINACIONES DE TECLAS.
		//getInputMap DEVULVE UN OBJ INPUTMAP Y PERTENECE A LA CLASE JCOMPONENT.
		//INPUTMAP VINCULA UN EVENTO CON UN OBJ. EN ESTE CASO VINCULA EVENTO CON COMBINACION DE TECLAS.
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//2.-CREAR LA COMBINACION DE TECLAS
		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
		KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B");
		KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");
		//3.-ASIGNAR L COMBINACI?N DE TECLAS A UN OBJ
		mapaEntrada.put(teclaAmarillo, "fondo_amarillo");
		mapaEntrada.put(teclaAzul, "fondo_azul");
		mapaEntrada.put(teclaRojo, "fondo_rojo");
		//4.-ASIGNAR EL OBJ A LA ACCI?N
		ActionMap mapaAccion = getActionMap(); //NOS DEVUELVE UN OBJ DE TIPO ACTIONMAP
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}
	class AccionColor extends AbstractAction{
		public AccionColor(String nombre,Icon icono,Color colorBoton) {
			             //clave:valor
			putValue(Action.NAME,nombre);
			putValue(Action.SMALL_ICON,icono);
			putValue(Action.SHORT_DESCRIPTION,"Poner la l?mina de color " + nombre);
			putValue("Color_de_Fondo",colorBoton); //pareja de clave valor final, que empaqueta al obj.
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//POR MEDIO DE LA CLAVE, ALMACENAMOS EN "C" LA INFORMACI?N DE colorBoton.
			Color c = (Color) getValue("Color_de_Fondo");
			setBackground(c);
			System.out.println("Nombre: " + getValue(Action.NAME));//IMPRIME EL NOMBRE
			System.out.println("Descripci?n: " + getValue(Action.SHORT_DESCRIPTION));//IMPRIME DESCRIPCI?N
			
		}
	}
}


