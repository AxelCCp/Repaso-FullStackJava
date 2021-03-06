package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class E2_101_ProcesadorTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador marco1 = new MarcoProcesador();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador extends JFrame{
	public MarcoProcesador() {
		setBounds(500,300,550,400);
		LaminaProcesador lamina1= new LaminaProcesador();
		add(lamina1);
	}
}

class LaminaProcesador extends JPanel{
	public LaminaProcesador() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		//========================================
		JMenuBar barra = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamano = new JMenu("Tama?o");
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamano);
		//
		JMenuItem arial = new JMenuItem("Arial");
		arial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				area.setFont(new Font("Arial",Font.PLAIN,12));
			}
		});
		JMenuItem verdana = new JMenuItem("Verdana");
		verdana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				area.setFont(new Font("Verdana",Font.PLAIN,12));
			}
		});
		JMenuItem courier = new JMenuItem("Courier");
		courier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				area.setFont(new Font("Courier",Font.PLAIN,12));
			}
		});
		fuente.add(arial);
		fuente.add(verdana);
		fuente.add(courier);
		//
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");
		estilo.add(negrita);
		estilo.add(cursiva);
		//
		JMenuItem tam12 = new JMenuItem("12");
		JMenuItem tam16 = new JMenuItem("16");
		JMenuItem tam20 = new JMenuItem("20");
		JMenuItem tam24 = new JMenuItem("24");
		tamano.add(tam12);
		tamano.add(tam16);
		tamano.add(tam20);
		tamano.add(tam24);
		//
		laminaMenu.add(barra);
		add(laminaMenu,BorderLayout.NORTH);
		//========================================
		area = new JTextPane();
		add(area,BorderLayout.CENTER);
		
	}
	//========================================
	private JTextPane area;
}