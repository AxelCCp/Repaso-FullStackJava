package A2_AplicacionesGraficas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class F4_118_DisposicionLibre {
	public static void main(String[]xxx) {
		MarcoLibre marco1 = new MarcoLibre();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoLibre extends JFrame{
	public MarcoLibre() {
		setBounds(450,350,600,400);
		LaminaLibre lamina1 = new LaminaLibre();
		add(lamina1);
	}
}


class LaminaLibre extends JPanel{
	public LaminaLibre() {
		//LE DECIMOS A LA LÁMINAQUE VAMOS A TRABAJAR CON UNA DISPOSICIÓN LIBRE.
		setLayout(null);
		JButton boton1 = new JButton("boton1");
		JButton boton2 = new JButton("boton2");
		boton1.setBounds(50, 50, 150, 150);//USAMOS COORDENADAS
		boton2.setBounds(250, 50, 150, 150);
		add(boton1);
		add(boton2);
	}
}

