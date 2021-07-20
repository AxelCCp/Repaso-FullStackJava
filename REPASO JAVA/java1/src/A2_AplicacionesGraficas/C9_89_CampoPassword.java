package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class C9_89_CampoPassword {

	public static void main(String[] args) {
		MarcoPassword marco1 = new MarcoPassword();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoPassword extends JFrame{
	public MarcoPassword() {
		setBounds(400,300,550,400);
		LaminaPassword lamina1 = new LaminaPassword();
		add(lamina1);
		setVisible(true);
	}
}

class LaminaPassword extends JPanel{
	public LaminaPassword() {
		setLayout(new BorderLayout());
		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new GridLayout(2,2));
		add(laminaSuperior,BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario");
		JLabel etiqueta2 = new JLabel("Contraseña");
		
		JTextField cUsuario = new JTextField(15);
		CompruebaPass miEvento = new CompruebaPass();
		cContra = new JPasswordField(15);
		cContra.getDocument().addDocumentListener(miEvento);//PONEMOS A LA ESCUCHA,CON ESTA CLASE SE PONE A LA ESCUCHA DE MANERA DIFERENTE.
		
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(cUsuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(cContra);
		
		JButton enviar = new JButton("Enviar");
		add(enviar,BorderLayout.SOUTH);
	}
	private class CompruebaPass implements DocumentListener{
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			char[]contrasena;
			contrasena=cContra.getPassword();
			if(contrasena.length<8 || contrasena.length>12) cContra.setBackground(Color.RED);
			else cContra.setBackground(Color.WHITE);
		}
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			char[]contrasena;
			contrasena=cContra.getPassword();
			if(contrasena.length<8 || contrasena.length>12) cContra.setBackground(Color.RED);
			else cContra.setBackground(Color.WHITE);
		}
	}
	JPasswordField cContra; 
}
