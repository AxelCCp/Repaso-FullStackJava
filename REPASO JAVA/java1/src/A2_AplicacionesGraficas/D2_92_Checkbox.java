package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D2_92_Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCheck marco1 = new MarcoCheck();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoCheck extends JFrame{
	public MarcoCheck() {
		setBounds(550,300,550,350);
		LaminaCheck lamina1 = new LaminaCheck();
		add(lamina1);	
	}
}

class LaminaCheck extends JPanel{
	public LaminaCheck() {
		setLayout(new BorderLayout());
		Font miLetra = new Font("Serif", Font.PLAIN, 24);
		texto = new JLabel("En un lugar de la mancha........");
		texto.setFont(miLetra);
		JPanel laminaTexto = new JPanel();
		laminaTexto.add(texto);
		add(laminaTexto,BorderLayout.CENTER);
		//
		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");
		//
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		//
		JPanel laminaChecks = new JPanel();
		laminaChecks.add(check1);
		laminaChecks.add(check2);
		add(laminaChecks,BorderLayout.SOUTH);
	}
	private class ManejaChecks implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int tipo=0;
			if(check1.isSelected()) tipo+=Font.BOLD;
			if(check2.isSelected()) tipo+=Font.ITALIC;
			texto.setFont(new Font("Serif", tipo,24));
		}
		
	}
	private JLabel texto;
	private JCheckBox check1;
	private JCheckBox check2;
}