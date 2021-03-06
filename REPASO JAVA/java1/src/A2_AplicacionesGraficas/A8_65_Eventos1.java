package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A8_65_Eventos1 {
	public static void main(String[]args) {
		MarcoBotones marco1 = new MarcoBotones();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}


class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
		setTitle("Botones y eventos");
		setBounds(450,200,500,500);
		LaminaBotones miLamina = new LaminaBotones();
		add(miLamina);
	}
}

class LaminaBotones extends JPanel implements ActionListener{
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaBotones() {
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		botonAzul.addActionListener(this);
		botonAmarillo.addActionListener(this);
		botonRojo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();  //PARA IDENTIFICAR QU? BOT?N SE PULS?(O SEA LA FUENTE).
		if(botonPulsado==botonAzul) setBackground(Color.BLUE);
		else if(botonPulsado==botonAmarillo) setBackground(Color.YELLOW);
		else if(botonPulsado==botonRojo) setBackground(Color.RED);
	}
	
}