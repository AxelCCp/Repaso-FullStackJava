package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A9_67_Eventos3 {
	public static void main(String[]args) {
		MarcoBotones2 marco1 = new MarcoBotones2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}


class MarcoBotones2 extends JFrame{
	
	public MarcoBotones2() {
		setTitle("Botones y eventos");
		setBounds(450,200,500,500);
		LaminaBotones2 miLamina = new LaminaBotones2();
		add(miLamina);
	}
}

class LaminaBotones2 extends JPanel {
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaBotones2() {
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		ColorFondo azul = new ColorFondo(Color.BLUE);
		ColorFondo amarillo = new ColorFondo(Color.YELLOW);
		ColorFondo rojo = new ColorFondo(Color.RED);
		
		botonAzul.addActionListener(azul);
		botonAmarillo.addActionListener(amarillo);
		botonRojo.addActionListener(rojo);
	}
	
	private class ColorFondo implements ActionListener{
		public ColorFondo(Color c) {
			colorDeFondo=c;
		}

		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);	
		}
		
		private Color colorDeFondo;
	}
}




