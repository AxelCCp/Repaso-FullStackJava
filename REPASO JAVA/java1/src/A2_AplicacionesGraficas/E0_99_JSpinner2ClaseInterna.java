package A2_AplicacionesGraficas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class E0_99_JSpinner2ClaseInterna {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSpinner3 marco1 = new MarcoSpinner3();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSpinner3 extends JFrame{
	public MarcoSpinner3() {
		setBounds(350,200,750,350);
		add(new LaminaSpinner3());
	}
}

class LaminaSpinner3 extends JPanel{
	public LaminaSpinner3() {
		// CON CLASE INTERNA ANÓNIMA
		JSpinner control4 = new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			//LE DECIMOS A LOS METODOS QUE FUNCIONEN AL REVES
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			public Object getPreviousValue() {
				return super.getNextValue();
			}
		});
		control4.setPreferredSize(new Dimension(150,20));
		add(control4);
	}
	
}