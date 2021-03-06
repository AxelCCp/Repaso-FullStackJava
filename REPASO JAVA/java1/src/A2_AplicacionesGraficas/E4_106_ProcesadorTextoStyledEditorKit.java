package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class E4_106_ProcesadorTextoStyledEditorKit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador3 marco1 = new MarcoProcesador3();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador3 extends JFrame{
	public MarcoProcesador3() {
		setBounds(500,300,550,400);
		LaminaProcesador3 lamina1= new LaminaProcesador3();
		add(lamina1);
	}
}

class LaminaProcesador3 extends JPanel{
	public LaminaProcesador3() {
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
		configuraMenu("Negrita","Estilo","",Font.BOLD,1,"src/A2_AplicacionesGraficas/iconos/baseline_format_bold_black_18dp.png");
		configuraMenu("Cursiva","Estilo","",Font.ITALIC,1,"src/A2_AplicacionesGraficas/iconos/baseline_format_italic_black_18dp.png");
		//
		configuraMenu("12","Tama?o","",9,12,"");
		configuraMenu("16","Tama?o","",9,16,"");
		configuraMenu("20","Tama?o","",9,20,"");
		configuraMenu("24","Tama?o","",9,24,"");
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
		//======================
		if(menu=="Fuente") {
			fuente.add(elemMenu);
			if(tipoLetra=="Arial") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Arial"));
			}else if(tipoLetra=="Courier") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Courier"));
			}else if(tipoLetra=="Verdana") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Verdana"));
			}
		}//======================
		else if(menu=="Estilo") {
			estilo.add(elemMenu);
			if(estilos==Font.BOLD) {
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			}
			else if (estilos==Font.ITALIC) {
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}//======================
		else if(menu=="Tama?o") {
			tamano.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", tam));//FontSizeAction ES UNA CLASE INTERNA DE LA CLASE StyledEditorKit
			}
		}
	//========================================
	private JTextPane area;
	private JMenu fuente, estilo, tamano;
	private Font letras;
}