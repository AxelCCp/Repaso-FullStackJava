package A2_AplicacionesGraficas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class E7_109_MenusEmergentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPopup marco1 = new MarcoPopup();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPopup extends JFrame{
	public MarcoPopup() {
		setBounds(100,100,300,250);
		LaminaPopup lamina1 = new LaminaPopup();
		add(lamina1);
		
	}
}

class LaminaPopup extends JPanel{
	public LaminaPopup() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		JMenuBar barra = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamano = new JMenu("Tama?o");
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamano);
		laminaMenu.add(barra);
		add(laminaMenu,BorderLayout.NORTH);
		JTextPane area = new JTextPane(); 
		add(area,BorderLayout.CENTER);
		//
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Opci?n1");
		JMenuItem opcion2 = new JMenuItem("Opci?n2");
		JMenuItem opcion3 = new JMenuItem("Opci?n3");
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		area.setComponentPopupMenu(emergente);
		
	}
}