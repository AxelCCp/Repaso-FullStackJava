//DISPOSICION BORDERLAYOUT
package A2_AplicacionesGraficas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C4_82_BorderLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout2 marco1 = new MarcoLayout2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoLayout2 extends JFrame{
	public MarcoLayout2() {
		setTitle("Layout");
		setBounds(600,350,600,300);
		LaminaLayout2 lamina1 = new LaminaLayout2();
		add(lamina1);
	}
}

class LaminaLayout2 extends JPanel{
	public LaminaLayout2() {
		setLayout(new BorderLayout(10,10));
		add(new JButton("Amarillo"),BorderLayout.NORTH);
		add(new JButton("Rojo"),BorderLayout.SOUTH);
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.EAST);
		add(new JButton("Naranjo"),BorderLayout.CENTER);
	}
}
