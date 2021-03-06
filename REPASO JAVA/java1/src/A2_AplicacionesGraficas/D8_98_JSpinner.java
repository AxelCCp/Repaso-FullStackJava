package A2_AplicacionesGraficas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class D8_98_JSpinner {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSpinner marco1 = new MarcoSpinner();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSpinner extends JFrame{
	public MarcoSpinner() {
		setBounds(350,200,750,350);
		add(new LaminaSpinner());
	}
}

class LaminaSpinner extends JPanel{
	public LaminaSpinner() {
		//
		String[]lista = {"Enero","Febrero","Marzo","Abril"};
		JSpinner control = new JSpinner(new SpinnerListModel(lista));
		control.setPreferredSize(new Dimension(100,20));
		add(control);
		//
		JSpinner control2 = new JSpinner(new SpinnerDateModel()); 
		add(control2);
		//
		String[]lista2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner control3 = new JSpinner(new SpinnerListModel(lista2));
		control3.setPreferredSize(new Dimension(150,20));
		add(control3);
		//
		JSpinner control4 = new JSpinner(new SpinnerNumberModel(5,0,10,1));
		control4.setPreferredSize(new Dimension(150,20));
		add(control4);
	}
}