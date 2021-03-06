package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C6_83_GridLayout_Calculadora {
	public static void main(String[]args) {
		MarcoCalculadora marco1= new MarcoCalculadora();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora lamina1 = new LaminaCalculadora();
		add(lamina1);
		//pack(); //AJUSTA EL TAMA?O DE LA CALCULADORA. 
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		principio = true; //LA PONEMOS EN TRUE, PARA Q PUEDA CAMBIAR A FALSO, SI ES QUE SE EST? INICIANDO EL PROGRAMA.
		setLayout(new BorderLayout()); //ESTALECEMOS DISPOSICION DE L?MINA
		pantalla = new JButton("0");
		pantalla.setEnabled(false); //PARA NO PODER HACER CLICK EN EL BOTON
		add(pantalla,BorderLayout.NORTH); //LO AGREGAMOS EN LA ZONA NORTE
		
		lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(4,4)); //CON DISPOSICI?N GRIDLAYOUT DE 4X4
		ActionListener insertar = new InsertaNumero();
		ActionListener orden = new AccionOrden();
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/",orden);
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("*",orden);
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton("-",orden);
		ponerBoton("0",insertar);
		ponerBoton(".",insertar);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		add(lamina2,BorderLayout.CENTER);
		ultimaOperacion= "=";
	}
	private void ponerBoton(String rotulo,ActionListener oyente) {
		JButton boton = new JButton(rotulo);
		lamina2.add(boton);
		boton.addActionListener(oyente);
	}
	private class InsertaNumero implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String entrada = e.getActionCommand();//M?TODO DE LA CLASE ACTIONEVENT. ALMACENAMOS LA INFO DE LA PANTALLA TRAS PULSAR UN BOT?N.
			
			//PARA QUITAR EL CERO INICIAL DE LA PANTALLA
			if(principio==true) {
				pantalla.setText("");
				principio=false;
			}
			//ESTABLECEMOS EL TEXTO DE "entrada" EN EL OBJETO DEL BOT?N.
			//SE USA GETTEXT() PARA MANTENER LO QUE YA EST? EN LA PANTALLA.
			pantalla.setText(pantalla.getText() + entrada); 
		}
	}
	private class AccionOrden implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//PARA ALMACENAR EL OPERADOR ARITM?TICO QUE SE PULS?.
			String operacion = e.getActionCommand();
			
			//REALIZA LAS OPERACIONES MATEM?TICAS, RECOGIENDO LA INFORMACI?N STRING QUE HAY EN LA PANTALLA,
			//PARA LUEGO CONVERTIRLA EN DOUBLE. 
			calcular(Double.parseDouble(pantalla.getText()));
			// PARA LIMPIAR LA PANTALLA, CADA VEZ QUE INGRESAMOS UN OPERADOR NUM?RICO.
			
			//SE ALMACENAN LAS OPERACIONES QUE EL USUARIO HAGA.
			ultimaOperacion = operacion;
			
			principio = true;
		}
		public void calcular(double x) {
			if(ultimaOperacion.equals("+")){
				resultado+=x;
			}
			else if(ultimaOperacion.equals("-")) {
				resultado -=x;
			}
			else if(ultimaOperacion.equals("*")) {
				resultado *=x;
			}
			else if(ultimaOperacion.equals("/")) {
				resultado /=x;
			}
			else if(ultimaOperacion.equals("=")) {
				resultado =x;
			}
			//PONEMOS EN LA PANTALLA EL RESULTADO. CONCATENAMOS PARA QUE LO ACEPTE COMO STRING
			pantalla.setText("" + resultado);	
		}
		
	}
	JButton pantalla;
	JPanel lamina2;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
	
}