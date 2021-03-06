package A2_AplicacionesGraficas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class D9_99_JSpinner2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSpinner2 marco1 = new MarcoSpinner2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSpinner2 extends JFrame{
	public MarcoSpinner2() {
		setBounds(350,200,750,350);
		add(new LaminaSpinner2());
	}
}

class LaminaSpinner2 extends JPanel{
	public LaminaSpinner2() {
		//
		JSpinner control4 = new JSpinner(new ModeloJspinner());
		control4.setPreferredSize(new Dimension(150,20));
		add(control4);
	}
	private class ModeloJspinner extends SpinnerNumberModel{
		public ModeloJspinner() {
			super(5,0,10,1);
		}
		//LE DECIMOS A LOS METODOS QUE FUNCIONEN AL REVES
		public Object getNextValue() {
			return super.getPreviousValue();
		}
		public Object getPreviousValue() {
			return super.getNextValue();
		}
	}
}
