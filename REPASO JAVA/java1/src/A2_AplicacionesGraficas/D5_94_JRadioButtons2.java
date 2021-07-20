package A2_AplicacionesGraficas;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class D5_94_JRadioButtons2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadio3 marco1 = new MarcoRadio3();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoRadio3 extends JFrame{
	public MarcoRadio3() {
		setBounds(550,300,500,350);
		LaminaRadio3 lamina1 = new LaminaRadio3();
		add(lamina1);
	}
}

class LaminaRadio3 extends JPanel{
	public LaminaRadio3() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha....");
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		add(texto,BorderLayout.CENTER);
		laminaBotones = new JPanel();
		miGrupo = new ButtonGroup();
		colocarBotones("Pequeno",false,10);
		colocarBotones("Mediano",true,12);
		colocarBotones("Grande",false,18);
		colocarBotones("MuyGrande",false,24);
		add(laminaBotones,BorderLayout.SOUTH);	
	}
	public void colocarBotones(String nombre, boolean seleccionado, final int tamagno) {
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		miGrupo.add(boton);//TODOS LOS BOTONES Q CONTRUYA EL METODO SE AGREGARÁN AL GRUPO.
		laminaBotones.add(boton);
		//INSTANCIAMOS DIRECTAMENTE LA INTERFAZ ACTIONLISTENER
		ActionListener miEvento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texto.setFont(new Font("Serif",Font.PLAIN,tamagno));
			}	
		};
		boton.addActionListener(miEvento);
	}
	
	
	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
	private ButtonGroup miGrupo;
	private JPanel laminaBotones;
}