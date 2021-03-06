//UN CONTENEDOR (MARCO) CON DOS LAMINAS SUPERPUESTAS, CADA LAMINA CON DIFERENTE DISPOSICI?N LAYOUT
package A2_AplicacionesGraficas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C5_82_LayoutsDiferentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout3 marco1 = new MarcoLayout3();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoLayout3 extends JFrame{
	public MarcoLayout3() {
		setTitle("Layout");
		setBounds(600,350,600,300);
		LaminaLayout3 lamina1 = new LaminaLayout3();
		add(lamina1,BorderLayout.NORTH);//PARA QUE NO TAPE A LA OTRA L?MINA
		LaminaLayout4 lamina2 = new LaminaLayout4();
		add(lamina2,BorderLayout.SOUTH);//PARA QUE NO TAPE A LA OTRA L?MINA
	}
}

//L?MINA CON DISPOSICI?N LEFT
class LaminaLayout3 extends JPanel{
	public LaminaLayout3() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		
	}
}

class LaminaLayout4 extends JPanel{
	public LaminaLayout4() {
		setLayout(new BorderLayout());
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.EAST);
		add(new JButton("Naranjo"),BorderLayout.CENTER);
	}
}