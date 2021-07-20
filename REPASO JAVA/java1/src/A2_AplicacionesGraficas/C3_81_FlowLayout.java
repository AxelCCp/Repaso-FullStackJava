//DISPOSICION FLOWLAYOUT
package A2_AplicacionesGraficas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C3_81_FlowLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout marco1 = new MarcoLayout();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoLayout extends JFrame{
	public MarcoLayout() {
		setTitle("Layout");
		setBounds(600,350,600,300);
		LaminaLayout lamina1 = new LaminaLayout();
		add(lamina1);
	}
}

class LaminaLayout extends JPanel{
	public LaminaLayout() {
		FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER,75,100);
		setLayout(disposicion);
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		add(new JButton("Azul"));
	}
}