package A2_AplicacionesGraficas;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class D6_96_JSlider {
	public static void main(String[]args) {
		MarcoSlider marco1 = new MarcoSlider();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSlider extends JFrame{
	public MarcoSlider() {
		setBounds(550,400,550,350);
		LaminaSlider lamina1 = new LaminaSlider();
		add(lamina1);
	}
}

class LaminaSlider extends JPanel{
	public LaminaSlider() {
		JSlider control = new JSlider(SwingConstants.HORIZONTAL,0,100,25);
		//control.setOrientation(SwingConstants.VERTICAL);
		control.setMajorTickSpacing(25);//ESTABLECE LAS MARCAS DEL JSLIDER
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true); //IMPRIME LAS MARCAS
		control.setPaintLabels(true);//IMPRIME ROTULOS (N?MEROS)
		control.setFont(new Font("Serif",Font.ITALIC,12));//FORMATO DE LOS R?TULOS NUM?RICOS.
		control.setSnapToTicks(true); //PARA QUE EL JSLIDER SE ESTABLEZCA SOBRE LA MARCAS DEL JSLIDER.
		add(control);
		
	}
}