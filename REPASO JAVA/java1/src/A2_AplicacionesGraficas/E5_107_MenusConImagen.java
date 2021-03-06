package A2_AplicacionesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class E5_107_MenusConImagen {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMenus2 marco1 = new MarcoMenus2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoMenus2 extends JFrame{
	public MarcoMenus2() {
		setBounds(500,300,550,400);
		LaminaMenus2 lamina1 = new LaminaMenus2();
		add(lamina1);
	}
}

class LaminaMenus2 extends JPanel{
	public LaminaMenus2() {
		JMenuBar barra = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edici?n");
		JMenu herramientas = new JMenu("Herramientas");
		barra.add(archivo);
		barra.add(edicion);
		barra.add(herramientas);
		
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem abrir = new JMenuItem("Abrir");
		JMenuItem imprimir = new JMenuItem("Imprimir");
		archivo.add(guardar);
		archivo.add(abrir);
		archivo.add(imprimir);
		
		JMenuItem cortar = new JMenuItem("Cortar",new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_content_cut_black_18dp.png"));
		JMenuItem copiar = new JMenuItem("Copiar",new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_copy_all_black_18dp.png"));
		JMenuItem pegar = new JMenuItem("Pegar",new ImageIcon("src/A2_AplicacionesGraficas/iconos/baseline_content_paste_black_18dp.png"));
		//cortar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenu opciones = new JMenu("Opciones");
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator();
		edicion.add(opciones);
		JMenuItem opcion1 = new JMenuItem("Opci?n1");
		JMenuItem opcion2 = new JMenuItem("Opci?n2");
		opciones.add(opcion1);
		opciones.add(opcion2);
		JMenuItem generales = new JMenuItem("Generales");
		herramientas.add(generales);
		add(barra);
	}
}