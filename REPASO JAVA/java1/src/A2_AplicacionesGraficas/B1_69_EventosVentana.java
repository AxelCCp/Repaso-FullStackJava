//CON CLASE ADAPTADORA WINDOWADAPTER
package A2_AplicacionesGraficas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class B1_69_EventosVentana {
	public static void main(String[]xxx) {
		MarcoVentana2 marco1 =new MarcoVentana2();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setTitle("Ventana 1");
		marco1.setBounds(200, 300, 500, 350);
		MarcoVentana2 marco2 = new MarcoVentana2();
		marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		marco2.setTitle("Ventana 2");
		marco2.setBounds(800, 300, 500, 350);	
	}
}

class MarcoVentana2 extends JFrame{
	public MarcoVentana2() {
		//setTitle("Respondiendo");
		//setBounds(300,300,500,350);
		setVisible(true);
		//M_Ventana2 oyenteVentana = new M_Ventana2();
		//addWindowListener(oyenteVentana);	
		addWindowListener(new M_Ventana());
	}
}


class M_Ventana2 extends WindowAdapter{

	@Override
	public void windowIconified(WindowEvent arg0) {
		System.out.println("Ventana minimizada");
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("Ventana abierta");
	}	
}