package A2_AplicacionesGraficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class A7_62_TrabajndoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes marco1 = new MarcoConFuentes();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoConFuentes extends JFrame{
	public MarcoConFuentes() {
		setTitle("Prueba con Fuentes");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
		Image icono = miPantalla.getImage("src/A2_AplicacionesGraficas/iconoPirata.jpg");
		setIconImage(icono);
		LaminaConFuentes lamina1 = new LaminaConFuentes();
		lamina1.setBackground(SystemColor.window);
		add(lamina1);
		
	}
}

class LaminaConFuentes extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Font miFuente = new Font("Segoe UI", Font.BOLD,45);
		g2.setFont(miFuente);
		g2.drawString("Hi!", 295, 70);
		
		g2.setFont(new Font("Segoe UI", Font.CENTER_BASELINE,18));
		g2.setColor(new Color(30,140,255));
		g2.drawString("loading ...", 290, 300);	
		
		File miImagen = new File("src/A2_AplicacionesGraficas/fox.jpg");
		try {
			imagen = ImageIO.read(miImagen);
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra");
		}
		g.drawImage(imagen, 240, 100, 170,170, null);
		
	}
	
	private Image imagen;
}


