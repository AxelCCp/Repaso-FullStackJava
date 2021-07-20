package A2_AplicacionesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class D0_90_AreasDeTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoArea marco1 = new MarcoArea();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoArea extends JFrame{
	public MarcoArea() {
		setBounds(500,300,500,350);
		LaminaArea lamina1 = new LaminaArea();
		add(lamina1);
		setVisible(true);
		
	}
}


class LaminaArea extends JPanel{
	public LaminaArea() {
		area1 = new JTextArea(8,20);
		JScrollPane laminaBarras = new JScrollPane(area1);
		area1.setLineWrap(true); //PARA QUE NO SE AGRANDE EL CUADRO A MEDIDA EN QUE ESCRIBIMOS.
		add(laminaBarras);
		JButton boton1 = new JButton("Dale");
		boton1.addActionListener(new GestionaArea());	
		add(boton1);
	}
	private class GestionaArea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(area1.getText());
		}
	}
	private JTextArea area1;
}
