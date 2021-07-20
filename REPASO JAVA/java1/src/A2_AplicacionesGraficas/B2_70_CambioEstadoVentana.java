package A2_AplicacionesGraficas;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

public class B2_70_CambioEstadoVentana {
	public static void main(String[] args) {
		MarcoEstado marco1 = new MarcoEstado();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoEstado extends JFrame{
	public MarcoEstado() {
		setVisible(true);
		setBounds(300,300,500,350);
		addWindowStateListener(new CambiaEstado());
	}
}

class CambiaEstado implements WindowStateListener{
	@Override
	public void windowStateChanged(WindowEvent e) {
		System.out.println("La ventana ha cambiado de estado");
		//System.out.println(e.getNewState());
		if(e.getNewState()==Frame.MAXIMIZED_BOTH)System.out.println("La ventana está a pantalla completa");
		else if(e.getNewState()==Frame.NORMAL)System.out.println("La ventana está normal");
		else if(e.getNewState()==Frame.ICONIFIED)System.out.println("La ventana está minimizada");
	}
}