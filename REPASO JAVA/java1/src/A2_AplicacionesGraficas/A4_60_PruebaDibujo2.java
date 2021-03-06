package A2_AplicacionesGraficas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A4_60_PruebaDibujo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos2 miMarco = new MarcoConDibujos2();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}


class MarcoConDibujos2 extends JFrame{
	public MarcoConDibujos2() {
		setTitle("Prueba de dibujo");
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image icono = miPantalla.getImage("src/A2_AplicacionesGraficas/IconoPirata.jpg");
		setIconImage(icono);
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
		
		LaminaConFiguras2 lamina1 = new LaminaConFiguras2();
		add(lamina1);
	}
}

class LaminaConFiguras2 extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//CONVERTIMOS EL OBJ GRAPHICS EN UN OBJ GRAPHICS2D
		Graphics2D g2 = (Graphics2D)g;
		//INTANCIAMOS LA CLASE Rectangle2D.Double
		//LA CLASE Rectangle2D.Double HEREDA DE RECTANGLE2D,QUE ES ABSTRACTA. 
		//AQU? USAMOS EL PRINCIPIO DE SUSTITUCI?N PARA INSTANCIAR Y LUEGO LE DECIMOS QUE ES IGUAL A UN OBJ DE TIPO Rectangle2D.Double 
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		//USAMOS M?TODO DRAW
		g2.draw(rectangulo);
		
		//--------
		
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		
		//--------
		
		g2.draw(new Line2D.Double(100,100,300,250));
		
		//--------
		
		//CREAMOS CIRCULO QUE ENGLOBE TODO
		double centroEnX = rectangulo.getCenterX();//ALMACENAMOS EL EJE X DEL CENTRO DEL RECT?NGULO. 
		double centroEnY = rectangulo.getCenterY();//ALMACENAMOS EL EJE Y DEL CENTRO DEL RECT?NGULO. 
		double radio = 150; //ESTABLECEMOS EL RADIO.
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(centroEnX,centroEnY,centroEnX+radio,centroEnY+radio);
		g2.draw(circulo);
	}
}