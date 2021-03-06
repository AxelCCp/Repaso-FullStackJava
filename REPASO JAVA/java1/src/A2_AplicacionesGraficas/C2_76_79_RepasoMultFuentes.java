package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class C2_76_79_RepasoMultFuentes {
	public static void main(String[]args ){
		MarcoAccion1 marco1 = new MarcoAccion1();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoAccion1 extends JFrame{
	public MarcoAccion1() {
		setTitle("XXX");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla/2,alturaPantalla/2,anchoPantalla/4,alturaPantalla/4);
		Image icono= miPantalla.getImage("src/A2_AplicacionesGraficas/iconoPirata.jpg");
		setIconImage(icono);
		LaminaAccion1 lamina1 = new LaminaAccion1();
		add(lamina1);
	}
}

class LaminaAccion1 extends JPanel{
	public LaminaAccion1() {
		AccionColor accionAmarillo = new AccionColor("Amarillo",new ImageIcon("Ruta"), Color.YELLOW);
		AccionColor accionAzul = new AccionColor("Azul",new ImageIcon("Ruta"), Color.BLUE);
		AccionColor accionRojo = new AccionColor("Rojo",new ImageIcon("Ruta"),Color.RED);
		JButton botonAmarillo = new JButton(accionAmarillo);
		JButton botonAzul = new JButton(accionAzul);
		JButton botonRojo = new JButton(accionRojo);
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);
		
		InputMap mapaDeEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A"); 
		KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B"); 
		KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R"); 
		//...
		
	}
	
	private class AccionColor extends AbstractAction{
		public AccionColor(String nombreBoton, Icon iconoBoton, Color colorBoton) {
			putValue(Action.NAME,nombreBoton);
			putValue(Action.SMALL_ICON,iconoBoton);
			putValue(Action.SHORT_DESCRIPTION, "Cambia a color " + nombreBoton);
			putValue("ColorDeFondo",colorBoton);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color c = (Color) getValue("ColorDeFondo");
			setBackground(c);
		}
		
	}
	
}
