package A2_AplicacionesGraficas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class F5_118_DisposicionLibreFormulario {
	public static void main(String[]xxx) {
		MarcoLibre2 marco1 = new MarcoLibre2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoLibre2 extends JFrame{
	public MarcoLibre2() {
		setBounds(450,350,600,400);
		LaminaLibre2 lamina1 = new LaminaLibre2();
		add(lamina1);
	}
}


class LaminaLibre2 extends JPanel{
	public LaminaLibre2() {
		//LE DECIMOS A LA L?MINA QUE VAMOS A TRABAJAR CON UNA DISPOSICI?N LIBRE.
		setLayout(null);
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JTextField cNombre = new JTextField(); //NO PONEMOS PAR?METRO DE TAMA?O,YA Q LO PONEMOS EN SETBOUNDS()
		JTextField cApellido = new JTextField();
		nombre.setBounds(20, 17, 80, 10);
		cNombre.setBounds(100, 20, 100, 20);
		apellido.setBounds(20, 60, 80, 15);
		cApellido.setBounds(100, 55, 100, 20);
		add(nombre);
		add(apellido);
		add(cNombre);
		add(cApellido);
		
	}
}
