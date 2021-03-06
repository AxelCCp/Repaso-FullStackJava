package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class F0_112_ProcesadorDeTexto_BarraDeHerramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador6 marco1 = new MarcoProcesador6();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador6 extends JFrame{
	public MarcoProcesador6() {
		setBounds(500,300,550,450);
		LaminaProcesador6 lamina1= new LaminaProcesador6();
		add(lamina1);
	}
}

class LaminaProcesador6 extends JPanel{
	public LaminaProcesador6() {
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
		ButtonGroup tamanoLetra = new ButtonGroup();
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		//ATAJO DE TECLADO
		veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
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
		//POPUP EMERGENTE
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		area.setComponentPopupMenu(emergente);
		//BARRA DE HERRAMIENTAS  
		JToolBar barraHerramientas = new JToolBar();
		JButton negritaBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_bold_black_18dp.png"));
		JButton cursivaBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_italic_black_18dp.png"));
		JButton subrayaBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_underlined_black_18dp.png"));
		
		JButton azulBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/Blue Ball.png"));
		JButton amarilloBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/Yellow Ball.png"));
		JButton rojoBarra = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/Red Ball.png"));
		
		JButton aIzquierda = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_align_left_black_18dp.png"));
		JButton aCentrado = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_align_center_black_18dp.png"));
		JButton aDerecha = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_align_right_black_18dp.png"));
		JButton aJustificado = new JButton(new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_format_align_justify_black_18dp.png"));
		//
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subrayaBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("poneAzul", Color.BLUE));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("poneAmarillo", Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("poneRojo", Color.RED));
		
		aIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("izquierda",0));
		aCentrado.addActionListener(new StyledEditorKit.AlignmentAction("centrado",1));
		aDerecha.addActionListener(new StyledEditorKit.AlignmentAction("derecha",2));
		aJustificado.addActionListener(new StyledEditorKit.AlignmentAction("justificado",3));
		//
		barraHerramientas.add(negritaBarra);
		barraHerramientas.add(cursivaBarra);
		barraHerramientas.add(subrayaBarra);
		barraHerramientas.add(azulBarra);
		barraHerramientas.add(amarilloBarra);
		barraHerramientas.add(rojoBarra);
		barraHerramientas.add(aIzquierda);
		barraHerramientas.add(aCentrado);
		barraHerramientas.add(aDerecha);
		barraHerramientas.add(aJustificado);
		//
		barraHerramientas.setOrientation(1);//1 para botones en vertical.
		add(barraHerramientas,BorderLayout.WEST);
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
		else if(menu=="Estilo") {
			estilo.add(elemMenu);
			if(estilos==Font.BOLD) {
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			}
			else if (estilos==Font.ITALIC) {
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}
	}
	//========================================
	private JTextPane area;
	private JMenu fuente, estilo, tamano;
	private Font letras;
}