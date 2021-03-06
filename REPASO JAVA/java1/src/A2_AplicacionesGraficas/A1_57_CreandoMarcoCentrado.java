package A2_AplicacionesGraficas;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class A1_57_CreandoMarcoCentrado {
	public static void main(String[]args) {
		MarcoCentrado marco1 = new MarcoCentrado();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}


class MarcoCentrado extends JFrame{
	public MarcoCentrado() {
		
		//PARA DETECTAR Y ALMACENAR EL SISTEMA NATIVO DE VENTANAS DEL PC.
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		//PARA AVERIGUAR Y ALMACENAR EL TAMA?O DE RESOLUCI?N DE LA VENTANA.
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		//EXTRAEMOS EL LARGO Y ANCHO DE LA PANTALLA 
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		//CREAR MARCO QUE SEA LA MITAD DE ANCHO Y LARGO, RESPECTO A LA PANTALLA
		setSize(anchoPantalla/2,alturaPantalla/2);
		//POSICIONAMOS EL CUADRO EN EL CENTRO
		setLocation(anchoPantalla/4,alturaPantalla/4);
		//T?TULO
		setTitle("Marco Centrado");
		//CAMBIAMOS EL ?CONO DEL MARCO
		Image icono = miPantalla.getImage("src/A2_AplicacionesGraficas/IconoPirata.jpg"); 
		setIconImage(icono);
	}
}
