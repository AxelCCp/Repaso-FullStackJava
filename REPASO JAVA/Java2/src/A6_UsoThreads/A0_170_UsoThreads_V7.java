package A6_UsoThreads;
//-------168
//PROGRAMA ORIGINAL
//-------168 CREAR HILO
//MÉTODO SLEEP() DENTRO DEL MÉTODO COMIENZA_EL_JUEGO()
//CREAMOS CLASE QUE IMPLEMENTA RUNNABLE, CREAMOS METODO RUN() Y PONEMOS EL FOR DENTRO. 
//-------169 INTERRUMPIR HILO
//METODOS STOP() E INTERRUPT()
//-------169 INTERRUMPIR HILO
//MÉTODOS INTERRUPTED() Y ELIMINAMOS EL MÉTODO SLEEP() 
//-------169 INTERRUMPIR HILO
//MÉTODOS currentThreads() y ISINTERRUPTED()
//-------170 INTERRUMPIR VARIOS HILOS
//VUELVE MÉTODO SLEEP(), Y DETENEMOS EL HILO EN EL CATCH DEL MÉTODO SLEEP(). 
//-------170 INTERRUMPIR VARIOS HILOS
//ELIMINAMOS MÉTODO QUE FORMABA BOTONES Y BOTONES A LA ESCUCHA,.. 
//...,CREAMOS BOTONES PARA VARIOS HILOS(BOTONES PARA EMPEZAR Y DETENER EL HILO) 
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class A0_170_UsoThreads_V7 {

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
		
		//IMPRIME EL ESTADO DEL HILO 
		System.out.println(Thread.currentThread().isInterrupted());
		
		//CAMBIAMOS EL BUCLE FOR POR UN WHILE, PARA QUE SE LA PELOTA SE MUEVA INDEFINIDAMENTE
		//currentThread() DEVULVE LA REFERENCIA DEL HILO QUE ESTÁ EJECUTANDOSE.
		//MIENTRAS(EL HILO NO ESTÉ INTERRUMPIDO)
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			//COMO EL MÉTODO SLEEP() LANZA UN EXCEPCIÓN AL SER INTERRUMPIDO EL HILO, Y NO..
			//..ES POSIBLE DETENERLO, LO DETENEMOS EN EL CATCH
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				//e.printStackTrace();
			}
		}
		//IMPRIME EL ESTADO DEL HILO 
				System.out.println(Thread.currentThread().isInterrupted());
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
		setBounds(600,300,600,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();
		
		//BOTONES PARA CADA HILO
		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				comienza_el_juego(arg0);//RECIBE UN ARGUMENTO ACTIONEVENT, PARA SABER Q BOTÓN SE PULSÓ.
			}
		});
		laminaBotones.add(arranca1);
		//----
		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				comienza_el_juego(arg0);
			}
		});
		laminaBotones.add(arranca2);
		//----
		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				comienza_el_juego(arg0);
			}
		});
		laminaBotones.add(arranca3);
		
		//BOTONES QUE DETIENEN LOS HILOS
		detener1 = new JButton("DetenerHilo1");
		detener1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				detener(arg0);
			}
		});
		laminaBotones.add(detener1);
		//----
		detener2 = new JButton("DetenerHilo2");
		detener2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				detener(arg0);
			}
		});
		laminaBotones.add(detener2);
		//----
		detener3 = new JButton("DetenerHilo3");
		detener3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				detener(arg0);
			}
		});
		laminaBotones.add(detener3);
		//----
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//AÑADE LA PELOTA A LA LÁMINA, CREA INSTANCIA QUE HEREDA DE RUNNABLE, SE LA PASAMOS AL ... 
	//... HILO Y LE DAMOS START: 
	public void comienza_el_juego (ActionEvent arg){	
			Pelota pelota=new Pelota();
			lamina.add(pelota);
			//CREAMOS INSTANCIA DE CLASE QUE IMPLEMENTA RUNNABLE Y LE PASAMOS LOS ARGUMENTOS..
			//..AL CONSTRUCTOR
			PelotaHilos r = new PelotaHilos(pelota,lamina);
			
			if(arg.getSource().equals(arranca1)) {
				//INSTANCIAMOS "t" DE CLASE THREAD Y LE PASAMOS "r"
				//CON EL OBJ THREAD LE DECIMOS QUE COMIENCE EL HILO 
				t1 = new Thread(r);
				t1.start();
			}
			else if(arg.getSource().equals(arranca2)) {
				t2 = new Thread(r);
				t2.start();
			}
			else if(arg.getSource().equals(arranca3)) {
				t3 = new Thread(r);
				t3.start();
			}
			
	}
	
	public void detener(ActionEvent arg) {
		if(arg.getSource().equals(detener1)) t1.interrupt();
		else if (arg.getSource().equals(detener2)) t2.interrupt();
		else if (arg.getSource().equals(detener3)) t3.interrupt();	
	}
	
	private LaminaPelota lamina;	
	private Thread t1,t2,t3; //3 HILOS
	private JButton arranca1, arranca2,arranca3;
	private JButton detener1,detener2, detener3;
}