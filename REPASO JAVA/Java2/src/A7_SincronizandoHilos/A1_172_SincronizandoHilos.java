package A7_SincronizandoHilos;
//SINCRONIZAMOS LOS HILOS ENTRE SÍ, PASANDO UN HILO POR PARAMETRO AL CONSTRUCTOR DE LA CLASE DEL..
//..SEGUNDO HILO.

public class A1_172_SincronizandoHilos {

	//AQUÍ HAY 3 HILOS. HILO1, HIL2 Y EL MÉTODO MAIN()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilosVarios1 hilo1 = new HilosVarios1();
		hilo1.start();
		
		HilosVarios2 hilo2 = new HilosVarios2(hilo1);
		hilo2.start();
		
		//HILO DEL MAIN
		System.out.println("Terminadas las tareas");
	}
}


//
class HilosVarios1 extends Thread{
	
	public void run() {
		for(int i=0;i<15;i++) {
			
			System.out.println("Ejecutando hilo " + getName());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//
class HilosVarios2 extends Thread{
	//RECIBE POR PARÁMETRO UN HILO
	public HilosVarios2(Thread hilo) {
		this.hilo=hilo;
	}
	
	//LE DECIMOS QUE ESTA TAREA NO COMIENCE HASTA QUE EL HILO QUE LE PASAMOS POR PARAMETRO AL..
	//..CONSTRUCTOR, NO HAYA TERMINADO SU TAREA.
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0;i<15;i++) {
			System.out.println("Ejecutando hilo " + getName());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private Thread hilo;
}