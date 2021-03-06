package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class E6_108_ProcesadorTextoJCheckBoxMenuItem_JRadioButtonMenuItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador4 marco1 = new MarcoProcesador4();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador4 extends JFrame{
	public MarcoProcesador4() {
		setBounds(500,300,550,400);
		LaminaProcesador4 lamina1= new LaminaProcesador4();
		add(lamina1);
	}
}

class LaminaProcesador4 extends JPanel{
	public LaminaProcesador4() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		//
		JMenuBar barra = new JMenuBar();
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tama?o");
		configuraMenu("Arial","Fuente","Arial",9,10,"");
		configuraMenu("Courier","Fuente","Courier",9,10,"");
		configuraMenu("Verdana","Fuente","Verdana",9,10,"");
		//
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_bold_black_18dp.png"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_italic_black_18dp.png"));
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(negrita);
		estilo.add(cursiva);
		//
		ButtonGroup tamanoLetra = new ButtonGroup();
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		tamanoLetra.add(doce);
		tamanoLetra.add(dieciseis);
		tamanoLetra.add(veinte);
		tamanoLetra.add(veinticuatro);
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 24));
		tamano.add(doce);
		tamano.add(dieciseis);
		tamano.add(veinte);
		tamano.add(veinticuatro);
		//
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamano);
		laminaMenu.add(barra);
		add(laminaMenu,BorderLayout.NORTH);
		//
		area = new JTextPane();
		add(area,BorderLayout.CENTER);
	}
	//========================================
	public void configuraMenu(String rotulo,String menu,String tipoLetra, int estilos,int tam,String rutaIcono) {
		JMenuItem elemMenu = new JMenuItem(rotulo,new ImageIcon(rutaIcono));
		
		if(menu=="Fuente") {
			fuente.add(elemMenu);
			if(tipoLetra=="Arial") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Arial"));
			}else if(tipoLetra=="Courier") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Courier"));
			}else if(tipoLetra=="Verdana") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Verdana"));
			}
		}
	}
	//========================================
	private JTextPane area;
	private JMenu fuente, estilo, tamano;
	private Font letras;
}