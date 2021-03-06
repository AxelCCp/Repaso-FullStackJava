package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A5_61_TrabajandoColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConColor marco1 = new MarcoConColor();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoConColor extends JFrame{
	public MarcoConColor() {
		setTitle("Prueba con colores");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla =miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
		Image icono = miPantalla.getImage("src/A2_AplicacionesGraficas/IconoPirata.jpg"); 
		setIconImage(icono);	
		LaminaConColor lamina1 = new LaminaConColor();
		add(lamina1);
		//lamina1.setBackground(Color.DARK_GRAY);
		lamina1.setBackground(SystemColor.window);
	}
}

class LaminaConColor extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		g2.setPaint(Color.CYAN); //COLOR LINEAS
		g2.fill(rectangulo);     //COLOR RELLENO
		g2.setPaint(Color.GREEN);
		g2.draw(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double(); 
		elipse.setFrame(rectangulo);
		g2.setPaint(new Color(30,140,255).brighter()); //INSTANCIAMOS OBJ COLOR, LE DAMOS BRILLO. 
		g2.fill(elipse);		            		   //COLOR RELLENO
		g2.setPaint(Color.PINK);
		g2.draw(elipse);
		
	}
}