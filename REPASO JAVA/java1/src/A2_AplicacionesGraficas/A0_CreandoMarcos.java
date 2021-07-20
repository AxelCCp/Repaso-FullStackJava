package A2_AplicacionesGraficas;
import java.awt.Frame;

import javax.swing.*;
public class A0_CreandoMarcos {

	public static void main(String[] args) {
		MiMarco marco1 = new MiMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MiMarco extends JFrame{
	public MiMarco() {
		//setSize(500,300);
		//setLocation(500,300);
		setBounds(450, 150, 500, 500);
		//setResizable(false);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Mi ventana");
	}	
}


