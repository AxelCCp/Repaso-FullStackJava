//CON CLASE INTERNA LOCAL
package A1_POO;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


public class B4_54_PruebaTemporizador3 {

	public static void main(String[]args) {
	
		Reloj2 miReloj = new Reloj2();
		miReloj.enMarcha(3000, true);
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	}
}




class Reloj2{
	
	
	public void enMarcha(int intervalo, final boolean sonido) {
		
		//CLASE INTERNA LOCAL
		class DameLaHora3 implements ActionListener{
			
			public void actionPerformed(ActionEvent evento) {
				Date ahora = new Date();
				System.out.println("Hora cada 3 segundos " + ahora);
				if(sonido)Toolkit.getDefaultToolkit().beep();
			}
		}
		
		ActionListener oyente = new DameLaHora3();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
	
	
	private class DameLaHora3 implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			Date ahora = new Date();
			System.out.println("Hora cada 3 segundos " + ahora);
			//if(sonido)Toolkit.getDefaultToolkit().beep();
		}
	}
}

