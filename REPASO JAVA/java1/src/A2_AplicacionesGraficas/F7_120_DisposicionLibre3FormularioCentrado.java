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

public class F7_120_DisposicionLibre3FormularioCentrado {
	public static void main(String[]xxx) {
		MarcoLibre4 marco1 = new MarcoLibre4();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class MarcoLibre4 extends JFrame{
	public MarcoLibre4() {
		setBounds(450,350,600,400);
		LaminaLibre4 lamina1 = new LaminaLibre4();
		add(lamina1);
	}
}
class LaminaLibre4 extends JPanel{
	public LaminaLibre4() {
		//LE DECIMOS A LA L?MINA QUE VAMOS A TRABAJAR CON UNA DISPOSICI?N LIBRE.
		setLayout(new EnColumnas2());
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JLabel telefono = new JLabel("Tel?fono: ");
		JTextField cNombre = new JTextField(); //NO PONEMOS PAR?METRO DE TAMA?O,YA Q LO PONEMOS EN SETBOUNDS()
		JTextField cApellido = new JTextField();
		JTextField cEdad = new JTextField();
		JTextField cTelefono = new JTextField();
		add(nombre);
		add(cNombre);
		add(apellido);
		add(cApellido);
		add(edad);
		add(cEdad);
		add(telefono);
		add(cTelefono);
	}
}

class EnColumnas2 implements LayoutManager{
	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void layoutContainer(Container miContenedor) {
		// TODO Auto-generated method stub
		int d = miContenedor.getWidth();//ALMACENAMOS LAS DIMENSIONES DEL CONTENEDOR.
		x=d/2;//ESTABLECEMOS EL PUNTO CENTRAL DE NUESTRO CONTENEDOR.
		int contador=0;
		int n= miContenedor.getComponentCount();//almacenamos n? de componentes que hemos agregado al contenedor. 
		for(int i=0;i<n;i++) {
			contador++;
			Component c = miContenedor.getComponent(i);
			c.setBounds(x-100, y, 100, 20);
			x+=100;
			if(contador%2==0) {
				x=d/2;
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
	private int x;
	private int y=20;
}
