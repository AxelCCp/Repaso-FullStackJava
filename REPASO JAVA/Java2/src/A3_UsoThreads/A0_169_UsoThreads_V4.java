package A3_UsoThreads;
//-------168
//PROGRAMA ORIGINAL
//-------168 CREAR HILO
//MÉTODO SLEEP() DENTRO DEL MÉTODO COMIENZA_EL_JUEGO()
//CREAMOS CLASE QUE IMPLEMENTA RUNNABLE, CREAMOS METODO RUN() Y PONEMOS EL FOR DENTRO. 
//-------169 INTERRUMPIR HILO
//METODOS STOP() E INTERRUPT()
//-------169 INTERRUMPIR HILO
//MÉTODOS INTERRUPTED() Y ELIMINAMOS EL MÉTODO SLEEP() 

//-------
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class A0_169_UsoThreads_V4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

//CREAMOS CLASE QUE IMPLEMENTA INTERFAZ RUNNABLE.
//ESTA CLASE IMPLEMENTA RUNNABLE, PARA QUE LAS INSTANCIAS DE ESTA CLASE PUEDAN SER EJECUTADAS..
//..POR UN THREAD.
//RUN()EN ESTE MÉTODO VA EL CÓDIGO DE LA TAREA PRINCIPAL.
class PelotaHilos implements Runnable {
	//CONTRUCTOR RECIBE POR PARÁMETRO (OBJ PELOTA, LAMINA DONDE LA PELOTA VA A REBOTAR)
	public PelotaHilos(Pelota unaPelota,Component unComponente) {
		pelota=unaPelota;
		componente=unComponente;
	}
	
	@Override
	public void run() {
		//CAMBIAMOS EL BUCLE FOR POR UN WHILE, PARA QUE SE LA PELOTA SE MUEVA INDEFINIDAMENTE
		//MIENTRAS(NO HAYA SIDO INTERRUMPIDO EL HILO)
		while(!Thread.interrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
		}
	}
	private Pelota pelota;
	private Component componente;
}


//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	//EL MÉTODO RECIBE POR PARAMETRO LOS LÍMITESDEL RECTANGULO DE LA LAMINA.
	public void mueve_pelota(Rectangle2D limites){	
		x+=dx;
		y+=dy;
		if(x<limites.getMinX()){
			x=limites.getMinX();
			dx=-dx;
		}
	
		if(x + TAMX>=limites.getMaxX()){		
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
	}
	
	//Forma de la pelota en su posición inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}	
	
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	public void add(Pelota b){
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b: pelotas){
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		setBounds(600,300,400,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}	
		});
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				System.exit(0);
			}
		});
		//CREAMOS BOTÓN DETENER
		ponerBoton(laminaBotones, "Detener", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener();
			}
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	//AÑADE LA PELOTA A LA LÁMINA, CREA INSTANCIA QUE HEREDA DE RUNNABLE, SE LA PASAMOS AL HILO Y LE DAMOS START: 
	public void comienza_el_juego (){	
			Pelota pelota=new Pelota();
			lamina.add(pelota);
			//CREAMOS INSTANCIA DE CLASE QUE IMPLEMENTA RUNNABLE Y LE PASAMOS LOS ARGUMENTOS..
			//..AL CONSTRUCTOR
			PelotaHilos r = new PelotaHilos(pelota,lamina);
			//INSTANCIAMOS "t" DE CLASE THREAD Y LE PASAMOS "r"
			t = new Thread(r);
			//CON EL OBJ THREAD LE DECIMOS QUE COMIENCE EL HILO 
			t.start();
	}
	
	public void detener() {
		//t.stop();//OBSOLETO PQ CORTA EL HILO.
		
		//SOLICITUD DE DETENCIÓN DEL HILO/GENERA UN ERROR DE INTERRUPCIÓN EN EL BUCLE FOR DE RUN()
		t.interrupt();
	}
	
	private LaminaPelota lamina;	
	private Thread t;
}