package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C7_86_CuadrosDeTexto {
	public static void main(String[]args) {
		MarcoTexto marco1 = new MarcoTexto();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoTexto extends JFrame{
	public MarcoTexto() {
		setBounds(600,300,600,350);
		LaminaTexto lamina1 = new LaminaTexto();
		add(lamina1);
		setVisible(true);
		
	}
}

class LaminaTexto extends JPanel{
	public LaminaTexto() {
		setLayout(new BorderLayout());
		JPanel lamina2 = new JPanel();
		lamina2.setLayout(new FlowLayout());
		JLabel texto1 = new JLabel("Email: ");
		lamina2.add(texto1);
		resultado = new JLabel("",JLabel.CENTER);
		campo1 = new JTextField(20);
		lamina2.add(campo1);
		JButton boton1 = new JButton("Comprobar");
		DameTexto miEvento = new DameTexto();
		boton1.addActionListener(miEvento);
		lamina2.add(boton1);
		add(resultado,BorderLayout.CENTER);
		add(lamina2,BorderLayout.NORTH);
	}
	private class DameTexto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int correcto = 0;
			String email =  campo1.getText().trim();
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='@') correcto++;
			}
			if(correcto!=1) resultado.setText("Email Incorrecto");
			else resultado.setText("Email Correcto");
		}
		
	}
	JTextField campo1;
	JLabel resultado;
}

