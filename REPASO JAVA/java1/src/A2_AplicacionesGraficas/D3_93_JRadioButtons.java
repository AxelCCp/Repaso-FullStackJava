package A2_AplicacionesGraficas;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class D3_93_JRadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadio marco1 = new MarcoRadio();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoRadio extends JFrame{
	public MarcoRadio() {
		setBounds(550,300,500,300);
		LaminaRadio lamina1 = new LaminaRadio();
		add(lamina1);
	}
}


class LaminaRadio extends JPanel{
	public LaminaRadio() {
		ButtonGroup grupo1 = new ButtonGroup();
		ButtonGroup grupo2 = new ButtonGroup();
		JRadioButton boton1 = new JRadioButton("Azul",false);
		JRadioButton boton2 = new JRadioButton("Verde",false);
		JRadioButton boton3 = new JRadioButton("Amarillo",false);
		JRadioButton boton4 = new JRadioButton("Masculino",false);
		JRadioButton boton5 = new JRadioButton("Femenino",false);
		grupo1.add(boton1);
		grupo1.add(boton2);
		grupo1.add(boton3);
		grupo2.add(boton4);
		grupo2.add(boton5);
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
	}
}