package A2_AplicacionesGraficas;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class F2_115_DisposicionesAvanzadasBox1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCaja marco1 = new MarcoCaja();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoCaja extends JFrame{
	public MarcoCaja() {
		setTitle("Marco en la caja");
		setBounds(600,350,200,200);
		//CREAMOS COMPONENTES DE CAJAS HORIZONTALES
		JLabel rotulo1 = new JLabel("Nombre");
		JTextField texto1 = new JTextField(10);
		texto1.setMaximumSize(texto1.getPreferredSize());
		Box cajaH1 = Box.createHorizontalBox();
		cajaH1.add(rotulo1);
		cajaH1.add(Box.createHorizontalStrut(10));
		cajaH1.add(texto1);
		//
		JLabel rotulo2 = new JLabel("Contraseņa");
		JTextField texto2 = new JTextField(10);
		texto2.setMaximumSize(texto2.getPreferredSize());
		Box cajaH2 = Box.createHorizontalBox();
		cajaH2.add(rotulo2);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(texto2);
		//
		JButton boton1 = new JButton("ok");
		JButton boton2 = new JButton("cancelar");
		Box cajaH3 = Box.createHorizontalBox();
		cajaH3.add(boton1);
		cajaH3.add(Box.createGlue());
		cajaH3.add(boton2);
		//CREAMOS BOXVERTICAL GRANDE QUE CONTENGA A LOS 3 BOX HORIZONTALES
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(cajaH1);
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		add(cajaVertical,BorderLayout.CENTER);	
	}
}
