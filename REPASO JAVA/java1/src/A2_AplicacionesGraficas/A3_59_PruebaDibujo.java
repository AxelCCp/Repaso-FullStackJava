package A2_AplicacionesGraficas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class A3_59_PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos miMarco = new MarcoConDibujos();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}


class MarcoConDibujos extends JFrame{
	public MarcoConDibujos() {
		setTitle("Prueba de dibujo");
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image icono = miPantalla.getImage("src/A2_AplicacionesGraficas/IconoPirata.jpg");
		setIconImage(icono);
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
		
		LaminaConFiguras lamina1 = new LaminaConFiguras();
		add(lamina1);
	}
}

class LaminaConFiguras extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(50, 50, 200, 200);
		g.drawLine(100, 100, 200, 200);
		g.drawArc(50, 100, 100, 200, 120, 150);
		
	}
}