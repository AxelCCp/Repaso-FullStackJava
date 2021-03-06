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

public class F1_114_ProcesadorTexto_Optimizado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador7 marco1 = new MarcoProcesador7();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador7 extends JFrame{
	public MarcoProcesador7() {
		setBounds(500,300,550,460);
		LaminaProcesador7 lamina1= new LaminaProcesador7();
		add(lamina1);
	}
}

class LaminaProcesador7 extends JPanel{
	public LaminaProcesador7() {
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
		barraHerramientas = new JToolBar();
		//EL M?TODO DEVUELVE UN OBJ DE TIPO JBUTTON, POR LO TANTO PODEMOS USAR INMEDIATAMENTE EL M?TODO ADDACTIONLISTENER()
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_bold_black_18dp.png").addActionListener(new StyledEditorKit.BoldAction());;
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_italic_black_18dp.png").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_underlined_black_18dp.png").addActionListener(new StyledEditorKit.UnderlineAction());
		barraHerramientas.addSeparator();
		configuraBarra("src/A2_AplicacionesGraficas/iconos/Blue Ball.png").addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.BLUE));
		configuraBarra("src/A2_AplicacionesGraficas/iconos/Yellow Ball.png").addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.YELLOW));
		configuraBarra("src/A2_AplicacionesGraficas/iconos/Red Ball.png").addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
		barraHerramientas.addSeparator();
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_align_left_black_18dp.png").addActionListener(new StyledEditorKit.AlignmentAction("aizquierda", 0));
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_align_center_black_18dp.png").addActionListener(new StyledEditorKit.AlignmentAction("aderecha", 1));
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_align_right_black_18dp.png").addActionListener(new StyledEditorKit.AlignmentAction("acentrado", 2));
		configuraBarra("src/A2_AplicacionesGraficas/iconos/baseline_format_align_justify_black_18dp.png").addActionListener(new StyledEditorKit.AlignmentAction("ajustificado", 3));
		barraHerramientas.setOrientation(1);//1 para botones en vertical.
		add(barraHerramientas,BorderLayout.WEST);
	}
	//========================================
	public JButton configuraBarra(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		barraHerramientas.add(boton);
		return boton;
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
	private JButton negritaBarra, cursivaBarra, subraBarra,azulBarra, amarilloBarra, rojoBarra;
	private JButton aIzquierda,aDerecha, aCentrado, aJustificado;
	private JToolBar barraHerramientas;
}