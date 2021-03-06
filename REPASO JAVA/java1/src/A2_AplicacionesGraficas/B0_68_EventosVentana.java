//CON INTERFAZ WINDOWLISTENER
package A2_AplicacionesGraficas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class B0_68_EventosVentana {
	public static void main(String[]xxx) {
		MarcoVentana marco1 =new MarcoVentana();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setTitle("Ventana 1");
		marco1.setBounds(200, 300, 500, 350);
		MarcoVentana marco2 = new MarcoVentana();
		marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		marco2.setTitle("Ventana 2");
		marco2.setBounds(800, 300, 500, 350);	
	}
}

class MarcoVentana extends JFrame{
	public MarcoVentana() {
		//setTitle("Respondiendo");
		//setBounds(300,300,500,350);
		setVisible(true);
		M_Ventana oyenteVentana = new M_Ventana();
		addWindowListener(oyenteVentana);	
	}
}


class M_Ventana implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("Ventana activada");
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("Ventana cerrada");
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("Cerrando ventana");
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("Ventana desactivada");
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		System.out.println("Ventana restaurada");
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		System.out.println("Ventana minimizada");
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("Ventana abierta");
	}
	
}