package A2_AplicacionesGraficas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A2_58_EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto miMarco = new MarcoConTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoConTexto extends JFrame{
	public MarcoConTexto() {
		setVisible(true);
		setSize(600,450);
		setLocation(400,200);
		setTitle("Primer Texto");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image imagen = miPantalla.getImage("src/A2_AplicacionesGraficas/IconoPirata.jpg");
		setIconImage(imagen);
		Lamina lamina1 = new Lamina();
		add(lamina1);
		
	}
}

class Lamina extends JPanel{
	//SOBREESCRIBIMOS EL METODO PAITCOMPONENT
	public void paintComponent(Graphics g) {
		//INVOCAMOS AL CONSTRUCTOR DE LA CLASE PADRE, PARA QUE EL M�TODO HAGA LO QUE REALMENTE HACE.
		super.paintComponent(g);
		//DESPU�S LE DECIMOS QUE HAGA LO QUE NOSOTROS QUEREMOS Q HAGA.
		g.drawString("Estamos aprendiendo swing", 100, 100);
	}	
	
}