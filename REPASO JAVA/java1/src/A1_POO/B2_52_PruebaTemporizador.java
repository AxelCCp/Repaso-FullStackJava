package A1_POO;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.*;

public class B2_52_PruebaTemporizador {
	
	public static void main(String[]args) {
		DameLaHora oyente = new DameLaHora();
		Timer miTemporizador = new Timer(5000,oyente);
		miTemporizador.start();
		JOptionPane.showMessageDialog(null, "Pulsa aceptar paradetener");
		System.exit(0);
	}
}


class DameLaHora implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Date ahora = new Date();
		System.out.println("Lahora cada 5 segundos "+ ahora);
		Toolkit.getDefaultToolkit().beep(); 
	}
	
}