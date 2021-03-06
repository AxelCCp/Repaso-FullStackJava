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

public class E3_103_ProcesadorTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador2 marco1 = new MarcoProcesador2();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoProcesador2 extends JFrame{
	public MarcoProcesador2() {
		setBounds(500,300,550,400);
		LaminaProcesador2 lamina1= new LaminaProcesador2();
		add(lamina1);
	}
}

class LaminaProcesador2 extends JPanel{
	public LaminaProcesador2() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		//
		JMenuBar barra = new JMenuBar();
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tama?o");
		configuraMenu("Arial","Fuente","Arial",9,10);
		configuraMenu("Courier","Fuente","Courier",9,10);
		configuraMenu("Verdana","Fuente","Verdana",9,10);
		//
		configuraMenu("Negrita","Estilo","",Font.BOLD,1);
		configuraMenu("Cursiva","Estilo","",Font.ITALIC,1);
		//
		configuraMenu("12","Tama?o","",9,12);
		configuraMenu("16","Tama?o","",9,16);
		configuraMenu("20","Tama?o","",9,20);
		configuraMenu("24","Tama?o","",9,24);
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
	public void configuraMenu(String rotulo,String menu,String tipoLetra, int estilos,int tam) {
		JMenuItem elemMenu = new JMenuItem(rotulo);
		if(menu=="Fuente") fuente.add(elemMenu);
		else if(menu=="Estilo")estilo.add(elemMenu);
		else if(menu=="Tama?o")tamano.add(elemMenu);
		elemMenu.addActionListener(new GestionaEventos(rotulo,tipoLetra,estilos,tam));
	}
	//========================================
	private class GestionaEventos implements ActionListener{
		String tipoTexto,menu;
		int estiloLetra, tamanoLetra;
		GestionaEventos(String elemento,String texto2, int estilo2, int tamLetra){
			tipoTexto=texto2;
			estiloLetra=estilo2;
			tamanoLetra=tamLetra;
			menu=elemento;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			letras= area.getFont(); //PARA ALMACENAR EL TIPO DE LETRA QUE HAY EN AREA.
			//PARA MANTENER TIPO DE LETRA, MIENTRAS SE PULSAN BOTONES EN EL MEN?.
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				estiloLetra=letras.getStyle();
				tamanoLetra= letras.getSize();
			}else if(menu=="Cursiva" || menu=="Negrita") {
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estiloLetra=3;//mantener negrita y cursiva a la vez.
				}
				tipoTexto=letras.getFontName();
				tamanoLetra= letras.getSize();
			}else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") {
				estiloLetra=letras.getStyle();
				tipoTexto=letras.getFontName();
			}
			area.setFont(new Font(tipoTexto,estiloLetra,tamanoLetra));
			System.out.println("Tipo: " + tipoTexto + " Estilo: " + estiloLetra + " Tama?o: " + tamanoLetra);
		}
	}
	//========================================
	private JTextPane area;
	private JMenu fuente, estilo, tamano;
	private Font letras;
}