package A2_AplicacionesGraficas;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

//ESTE ARRAY NOS DEVUELVE LOS TIPOS DE LETRA QUE TENEMOS EN EL PC
public class A6_62_TiposDeLetrasEnPC {
	public static void main(String []args) {
		
		String fuente = JOptionPane.showInputDialog("Ingresa una fuente");
		boolean estaLaFuente = false;
		
		//getLocalGraphicsEnvironment(): devuelve el entorto gr?fico local
		String []nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	
		for(String nombreFuente: nombresDeFuentes) {
			if(nombreFuente.equals(fuente)) {estaLaFuente=true;} 
		}
		
		if(estaLaFuente==true) System.out.println("S? est? la fuente");
		else System.out.println("No est? la fuente");
	}
}
