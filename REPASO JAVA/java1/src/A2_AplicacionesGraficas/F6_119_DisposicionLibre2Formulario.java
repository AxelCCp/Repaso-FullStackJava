package A2_AplicacionesGraficas;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class F6_119_DisposicionLibre2Formulario {
	public static void main(String[]xxx) {
		MarcoLibre3 marco1 = new MarcoLibre3();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class MarcoLibre3 extends JFrame{
	public MarcoLibre3() {
		setBounds(450,350,600,400);
		LaminaLibre3 lamina1 = new LaminaLibre3();
		add(lamina1);
	}
}
class LaminaLibre3 extends JPanel{
	public LaminaLibre3() {
		//LE DECIMOS A LA L�MINA QUE VAMOS A TRABAJAR CON UNA DISPOSICI�N LIBRE.
		setLayout(new EnColumnas());
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JTextField cNombre = new JTextField(); //NO PONEMOS PAR�METRO DE TAMA�O,YA Q LO PONEMOS EN SETBOUNDS()
		JTextField cApellido = new JTextField();
		JTextField cEdad = new JTextField();
		add(nombre);
		add(cNombre);
		add(apellido);
		add(cApellido);
		add(edad);
		add(cEdad);
	}
}

class EnColumnas implements LayoutManager{
	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void layoutContainer(Container miContenedor) {
		// TODO Auto-generated method stub
		int contador=0;
		int n= miContenedor.getComponentCount();//almacenamos n� de componentes que hemos agregado al contenedor. 
		for(int i=0;i<n;i++) {
			contador++;
			Component c = miContenedor.getComponent(i);
			c.setBounds(x, y, 100, 20);
			x+=100;
			if(contador%2==0) {
				x=20;
				y+=40;
			}
		}
	}
	@Override
	public Dimension minimumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dimension preferredLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}
	private int x=20;
	private int y=20;
}

