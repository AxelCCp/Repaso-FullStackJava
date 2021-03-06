package A2_AplicacionesGraficas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class B9_75_EventosDeFocoVentana extends JFrame implements WindowFocusListener {
	public static void main(String[]args) {
		
		B9_75_EventosDeFocoVentana miv = new B9_75_EventosDeFocoVentana();
		miv.iniciar();
		
	}
	public void iniciar() {
		marco1 = new B9_75_EventosDeFocoVentana();
		marco2 = new B9_75_EventosDeFocoVentana();
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(50,100,600,350);
		marco2.setBounds(700,100,600,350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource()==marco1)marco1.setTitle("Tengo el foco");
		else if(e.getSource()==marco2) marco2.setTitle("Tengo el foco");
		
	}
	@Override
	public void windowLostFocus(WindowEvent e) {
		if(e.getSource()==marco1)marco1.setTitle("No tengo el foco");
		else if(e.getSource()==marco2) marco2.setTitle("No tengo el foco");
		
	}
	B9_75_EventosDeFocoVentana marco1;
	B9_75_EventosDeFocoVentana marco2;
}
