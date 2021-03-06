package A2_AplicacionesGraficas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class F3_116_DisposicionEnMuelle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle marco1 = new MarcoMuelle();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoMuelle extends JFrame{
	public MarcoMuelle() {
		setBounds(300,400,1000,350);
		LaminaMuelle lamina1 = new LaminaMuelle();
		add(lamina1);
	}
}

class LaminaMuelle extends JPanel{
	public LaminaMuelle() {
		JButton boton1 = new JButton("boton1");
		JButton boton2 = new JButton("boton2");
		JButton boton3 = new JButton("boton3");
		add(boton1);
		add(boton2);
		add(boton3);
		//LE DEDIMOS A LA L?MINA QUE USE UNA DISPOSICI?N DE TIPO SPRINGLAYOUT
		SpringLayout milayout = new SpringLayout();
		setLayout(milayout);
		//ESTABLECEMOS El MUELLE
		Spring miMuelle = Spring.constant(0, 10, 50); //MUELLE FLEXIBLE 
		Spring miMuelle2 = Spring.constant(10); //MUELLE R?GIDO
		//COLOCAMOS EL MUELLE ENTRE LOS BOTONES Y TAMBN LA L?MINA
		milayout.putConstraint(SpringLayout.WEST, boton1, miMuelle2, SpringLayout.WEST, this);
		milayout.putConstraint(SpringLayout.WEST, boton2, miMuelle, SpringLayout.EAST, boton1);
		milayout.putConstraint(SpringLayout.WEST, boton3, miMuelle, SpringLayout.EAST, boton2);
		milayout.putConstraint(SpringLayout.EAST, this, miMuelle2, SpringLayout.EAST, boton3);
	}
}
