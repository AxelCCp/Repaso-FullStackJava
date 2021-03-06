package A3_practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class A1_123_MarcoDialogos extends JFrame {
	public A1_123_MarcoDialogos() {
		setLayout(new BorderLayout());
		setTitle("Prueba de Di?logos");
		setBounds(200,100,600,450);
		JPanel laminaCuadricula = new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		//
		String [] primero = {"Mensaje","Confirmar","Opci?n","Entrada"};
		laminaTipo = new A2_123_LaminaBotones("Tipo",primero);
		laminaCuadricula.add(laminaTipo);
		//
		laminaTipoMensaje = new A2_123_LaminaBotones("Tipo de mensaje", new String[] {
			"ERROR_MESSAGE","INFORMATION_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"
		});
		laminaCuadricula.add(laminaTipoMensaje);
		//
		laminaMensaje = new A2_123_LaminaBotones("Mensaje", new String[] {
			"Cadena","?cono","Componente","Otros","Objects"
		});
		laminaCuadricula.add(laminaMensaje);
		//
		laminaTipoOpcion = new A2_123_LaminaBotones("Confirmar", new String[] {
			"DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"	
		});
		laminaCuadricula.add(laminaTipoOpcion);
		//
		laminaOpciones = new A2_123_LaminaBotones("Opci?n", new String[] {
			"String[]","Icon[]","Object[]"	
		});
		laminaCuadricula.add(laminaOpciones);
		//
		laminaEntrada = new A2_123_LaminaBotones("Entrada", new String[] {
				"Campo de texto","Combo"
		});
		laminaCuadricula.add(laminaEntrada);
		//--------------------------
		add(laminaCuadricula,BorderLayout.CENTER);
		/////////////L?MINA SUR DONDE VA EL BOT?N DE MOSTRAR 
		JPanel laminaMostrar = new JPanel();
		JButton mostrar = new JButton("Mostrar"); 
		mostrar.addActionListener(new AccionMostrar());
		laminaMostrar.add(mostrar);
		add(laminaMostrar,BorderLayout.SOUTH);
	}
	// M?TODOQUE PROPORCIONA EL MENSAJE, SERA DE TIPO OBJECT YA QUE NOS PROPORCIONAR? OBJETOS 
	public Object dameMensaje() {
		String s =laminaMensaje.dameSeleccion();
		if(s.equals("Cadena")) {
			return cadenaMensaje;
		}else if(s.equals("Icono")) {
			return iconoMensaje;
		}else if(s.equals("Componente")){
			return componenteMensaje;
		}else if(s.equals("Otros")) {
			return objMensaje;
		}else if (s.equals("Object[]")){
			return new Object[] {cadenaMensaje,iconoMensaje,componenteMensaje,objMensaje};
		}else {
			return null;
		}
	}
	//=====================================================================
	private class AccionMostrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(laminaTipo.dameSeleccion());
			if(laminaTipo.dameSeleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(A1_123_MarcoDialogos.this, dameMensaje(), "T?tulo", 0);
			}
			else if(laminaTipo.dameSeleccion().equals("Confirmar")) {
				JOptionPane.showConfirmDialog(A1_123_MarcoDialogos.this, dameMensaje(),"T?tulo",0,0);
			}
			else if(laminaTipo.dameSeleccion().equals("Entrada")) {
				JOptionPane.showInputDialog(A1_123_MarcoDialogos.this, dameMensaje(),"T?tulo",0);
			}
			else if(laminaTipo.dameSeleccion().equals("Opci?n")) {
				JOptionPane.showOptionDialog(A1_123_MarcoDialogos.this, dameMensaje(),"T?tulo", 0, 0, null, null, null);
			}
		}
		
	}
	private A2_123_LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje,laminaTipoOpcion, laminaOpciones, laminaEntrada;
	private String cadenaMensaje="Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/A2_AplicacionesGraficas/iconos/Blue Ball.png");
	private Object objMensaje = new Date();
	private Component componenteMensaje = new LaminaEjemplo(); //hace referencia a la l?mina que nos devuelve el JOptionPane
}

class LaminaEjemplo extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		                           //Rectangle2D.Double(0,0,getWidth(),getHeight()) = esta clase ped?a como par?metros en el constructor(eje x, eje y, ancho y alto). 
		Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());
		g2.setPaint(Color.YELLOW); //elegimos color
		g2.fill(rectangulo);       //y pintamos.
		
	}
}
