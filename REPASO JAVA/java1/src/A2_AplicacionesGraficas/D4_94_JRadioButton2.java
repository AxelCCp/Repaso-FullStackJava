package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class D4_94_JRadioButton2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadio2 marco1 = new MarcoRadio2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoRadio2 extends JFrame{
	public MarcoRadio2() {
		setBounds(550,300,500,350);
		LaminaRadio2 lamina1 = new LaminaRadio2();
		add(lamina1);
	}
}

class LaminaRadio2 extends JPanel{
	public LaminaRadio2() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha....");
		add(texto,BorderLayout.CENTER);
		ButtonGroup grupo1 = new ButtonGroup();
		boton1 = new JRadioButton("Peque?o",false);
		boton2 = new JRadioButton("Mediano",true);
		boton3 = new JRadioButton("Grande",false);
		boton4 = new JRadioButton("MuyGrande",false);
		JPanel laminaRadioSur = new JPanel();
		EventoRadio evento = new EventoRadio();
		boton1.addActionListener(evento);
		boton2.addActionListener(evento);
		boton3.addActionListener(evento);
		boton4.addActionListener(evento);
		grupo1.add(boton1);
		grupo1.add(boton2);
		grupo1.add(boton3);
		grupo1.add(boton4);
		laminaRadioSur.add(boton1);
		laminaRadioSur.add(boton2);
		laminaRadioSur.add(boton3);
		laminaRadioSur.add(boton4);
		add(laminaRadioSur,BorderLayout.SOUTH);
	}
	private class EventoRadio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==boton1) texto.setFont(new Font("Serif",Font.PLAIN,10));
			else if(e.getSource()==boton2) texto.setFont(new Font("Serif",Font.PLAIN,12)); 
			else if(e.getSource()==boton3) texto.setFont(new Font("Serif",Font.PLAIN,18));
			else if(e.getSource()==boton4) texto.setFont(new Font("Serif",Font.PLAIN,24)); 
		}	
	}
	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
}