package A7_SincronizandoHilos;
//SINCRONIZAMOS LOS HILOS PARA ESTABLECER QUE HILO VA 1RO Y CUAL VA DESPUÉS


public class A0_171_SincronizandoHilos {

	//AQUÍ HAY 3 HILOS. HILO1, HIL2 Y EL MÉTODO MAIN()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilosVarios hilo1 = new HilosVarios();
		hilo1.start();
		//CON JOIN()EL HILO1 SE EJECUTARÁ HASTA QUE TERMINE 
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HilosVarios hilo2 = new HilosVarios();
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HILO DEL MAIN
		System.out.println("Terminadas las tareas");
	}
}


//HEREDANDO DE THREAD, ES LA 2DA MANERA DE CREAR HILOS, EN VEZ DE RUNNABLE
class HilosVarios extends Thread{
	//SOBREESCRIBIMOS EL MÉTODO RUN() DE LA INTERFAZ RUNNABLE  
	public void run() {
		for(int i=0;i<15;i++) {
			//getName() DEVUELVE EL NOMBRE DEL HILO
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