package A2_AplicacionesGraficas;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D6_95_ComboBox {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCombo marco1 = new MarcoCombo();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoCombo extends JFrame{
	public MarcoCombo() {
		setBounds(550,300,550,400);
		LaminaCombo miLamina = new LaminaCombo();
		add(miLamina);
	}
}

class LaminaCombo extends JPanel{
	public LaminaCombo() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha...");
		texto.setFont(new Font("Serif", Font.PLAIN,18));
		add(texto, BorderLayout.CENTER);
		JPanel laminaNorte = new JPanel();
		miCombo = new JComboBox();
		miCombo.setEditable(true);
		miCombo.addItem("Serif");
		miCombo.addItem("SandsSerif");
		miCombo.addItem("Monospaced");
		miCombo.addItem("Dialog");
		EventoCombo evento = new EventoCombo();
		miCombo.addActionListener(evento);
		laminaNorte.add(miCombo);
		add(laminaNorte,BorderLayout.NORTH);
	}
	private class EventoCombo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			texto.setFont(new Font((String) miCombo.getSelectedItem(),Font.PLAIN,18));
		}
	}
	private JLabel texto;
	private JComboBox miCombo;
}