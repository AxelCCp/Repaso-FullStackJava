package A2_AplicacionesGraficas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class B6_73_EventosMouse {
	public static void main(String []xxx) {
		MarcoRaton3 marco1 = new MarcoRaton3();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoRaton3 extends JFrame{
	public MarcoRaton3() {
		setVisible(true);
		setBounds(300,300,500,350);
		addMouseMotionListener(new EventosDeRaton3());
	}
}

class EventosDeRaton3 implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Estás arrastrando");
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("Estás moviendo");
		
	}
	
	
}
