//UNA FUENTE Y VARIOS OYENTES
package A2_AplicacionesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//-----------------------------------------------------------------------------------------
public class C1_80_MultiplesOyentes {
	public static void main(String[]args) {
		MarcoPrincipal marco1 = new MarcoPrincipal();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//-----------------------------------------------------------------------------------------
class MarcoPrincipal extends JFrame{
	public MarcoPrincipal(){
		setTitle("Prueba varios");
		setBounds(900,100,300,200);
		LaminaPrincipal lamina = new LaminaPrincipal();
		add(lamina);
	}
}

//-----------------------------------------------------------------------------------------
class LaminaPrincipal extends JPanel{
	public LaminaPrincipal() {
		JButton botonNuevo = new JButton("Nuevo");
		add(botonNuevo);
		botonCerrar = new JButton("Cerrar todo");
		add(botonCerrar);
		OyenteNuevo oyente = new OyenteNuevo();
		botonNuevo.addActionListener(oyente);
		
	}
	private class OyenteNuevo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			MarcoEmergente marco = new MarcoEmergente(botonCerrar);
		}
	}
	JButton botonCerrar;
}

//-----------------------------------------------------------------------------------------
class MarcoEmergente extends JFrame{	
	public MarcoEmergente(JButton boton_de_principal) {
		contador++;
		setTitle("Ventana" + contador);
		setBounds(40*contador,40*contador,300,150);
		setVisible(true);
		CierraTodos oyenteCerrar = new CierraTodos();
		boton_de_principal.addActionListener(oyenteCerrar);
	}
	//PARA CERRAR TODAS LAS VENTANAS, CREAMOS LA CLASE INTERNA QUE LE PUEDA DAR LA ORDEN DE CERRAR TODAS
	//LAS VENTANAS, A LA CLASE MARCOEMERGENTE 
	private class CierraTodos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();//MÉTODO DE JFRAME QUE HEREDA DE WINDOW. DIPOSE CIERRA TODOS LOS OBJ'S.
		}
		
	}
	private static int contador=0;
}
//-----------------------------------------------------------------------------------------



