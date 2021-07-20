package A2_AplicacionesGraficas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class B4_72_EventosMouse {
	public static void main(String []xxx) {
		MarcoRaton marco1 = new MarcoRaton();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoRaton extends JFrame{
	public MarcoRaton() {
		setVisible(true);
		setBounds(300,300,500,350);
		addMouseListener(new EventosDeRaton());
	}
}



class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Haz hecho click");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de entrar");
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
		System.out.println("Acabas de salir");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de presionar");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de levantar");
	}
}