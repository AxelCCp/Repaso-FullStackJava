package A2_AplicacionesGraficas;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class D7_97_JSlider2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSlider2 marco1 = new MarcoSlider2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSlider2 extends JFrame{
	public MarcoSlider2() {
		setBounds(550,400,550,350);
		LaminaSlider2 lamina = new LaminaSlider2();
		add(lamina);
	}
}

class LaminaSlider2 extends JPanel{
	public LaminaSlider2() {
		setLayout(new BorderLayout());
		rotulo = new JLabel("En un lugar de la Mancha...."); 
		add(rotulo,BorderLayout.CENTER);
		control = new JSlider(8,68,12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);//PINTA LAS RAYAS
		control.setPaintLabels(true);//PINTA LOS R?TULOS
		control.setFont(new Font("Serif",Font.ITALIC,10));
		control.addChangeListener(new EventoSlider());
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control);
		add(laminaSlider,BorderLayout.NORTH);
	}
	private class EventoSlider implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			contador++;
			System.out.println("Est?s manipulando el JSlider " + contador);
			System.out.println("Est?s manipulando el JSlider " + control.getValue());
			rotulo.setFont(new Font("Serif",Font.PLAIN,control.getValue()));
		}
	}
	private JLabel rotulo;
	private JSlider control;
	private static int contador;
}