package A2_AplicacionesGraficas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class B5_72_EventosMouse {
	public static void main(String []xxx) {
		MarcoRaton2 marco1 = new MarcoRaton2();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoRaton2 extends JFrame{
	public MarcoRaton2() {
		setVisible(true);
		setBounds(300,300,500,350);
		addMouseListener(new EventosDeRaton2());
	}
}

class EventosDeRaton2 extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		System.out.println("Haz hecho click");
		System.out.println("Coordenada X: " + e.getX()  + " Coordenada Y: " + e.getY());
		System.out.println("N�mero de Clicks: " + e.getClickCount());
	}	
	
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getModifiersEx());
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK)System.out.println("haz pulsado el bot�n izquierdo");
		else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK)System.out.println("haz pulsado la rueda del rat�n");
		else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK)System.out.println("haz pulsado el bot�n derecho");
		System.out.println("-----------");
		
	}
	
}