package A1_POO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


public class B3_53_PruebaTemporizador2 {

	public static void main(String[]args) {
	
		Reloj miReloj = new Reloj(3000, true);
		miReloj.enMarcha();
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	}
}




class Reloj {
	
	public Reloj(int intervalo, boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
	}
	
	public void enMarcha() {
		ActionListener oyente = new DameLaHora2();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
	
	private int intervalo;
	private boolean sonido;
	
	private class DameLaHora2 implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			Date ahora = new Date();
			System.out.println("Hora cada 3 segundos " + ahora);
			if(sonido)Toolkit.getDefaultToolkit().beep();
		}
	}
}
