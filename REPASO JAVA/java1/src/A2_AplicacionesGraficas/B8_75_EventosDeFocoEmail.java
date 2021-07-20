package A2_AplicacionesGraficas;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class B8_75_EventosDeFocoEmail {
	public static void main(String[]xxx) {
		MarcoFoco2 marco1 = new MarcoFoco2();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoFoco2 extends JFrame{
	public MarcoFoco2() {
		setVisible(true);
		setBounds(300,300,600,450);
		add(new LaminaFoco2());
		
	}
}


class LaminaFoco2 extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);//INVALIDAMOS LA COLOCACIÓN POR DEFECTO DE LOS ELEMENTOS.
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		cuadro1.setBounds(120,10,150,20);
		cuadro2.setBounds(120,50,150,20);
		add(cuadro1);
		add(cuadro2);
		LanzaFocos2 elFoco = new LanzaFocos2();
		cuadro1.addFocusListener(elFoco);
	}
										 //TAMBIÉN SE PUEDE USAR LA CLASE FOCUSADAPTER
	private class LanzaFocos2 implements FocusListener{
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void focusLost(FocusEvent e) {
			//CAPTURAMOS EL TEXTO DEL CUADRO1
			String email= cuadro1.getText();
			boolean comprobacion=false;
			for(int i=0;i<email.length();i++ ) {
				if(email.charAt(i)=='@') {
					comprobacion=true;
				}
			}
			if(comprobacion==true)System.out.println("Es Correcto");
			else System.out.println("Es Incorrecto");
		}
	}
	JTextField cuadro1;
	JTextField cuadro2;
}

