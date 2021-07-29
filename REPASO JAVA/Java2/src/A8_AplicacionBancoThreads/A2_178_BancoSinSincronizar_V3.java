package A8_AplicacionBancoThreads;
//USAMOS "synchronized" PARA SINCRONIZAR EL METODO TRANFERENCIA()
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A2_178_BancoSinSincronizar_V3 {
	public static void main(String[]args) {
		Banco3 b = new Banco3();
		for(int i=0;i<100;i++) {
			EjecucionTransferencias3 r = new EjecucionTransferencias3(b,i,2000);
			Thread t = new Thread(r);
			t.start();
		}
	}
}


class Banco3{
	public Banco3() {
		cuentas = new double[100];
		//CARGAMOS LAS CUENTAS CON 2000 EUROS
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
		//EL BLOQUEO SE DEBE ESTABLECER EN BASE A UNA CONDICIÓN
		//saldoSuficiente = cierreBanco.newCondition();// YA NO SE NECESITA
	}
	
	public synchronized void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) throws InterruptedException {
		
		//BLOQUEAMOS EN MÉTODO PARA QUE EL MÉTODO SEA RECORRIDO SOLO POR UN HILO A LA VEZ.
		//ENCERRAMOS EL MÉTODO EN UN try/finally
		//cierreBanco.lock();
		
		//try {
		
		//PARA QUE LA CANTIDAD A TRANSFERIR NO SEA SUPERIOR AL SALDO DE LA CTA.
		while(cuentas[cuentaOrigen]<cantidad) {
			
			//MIENTRAS LA CONDICIÓN DEL WHILE SEA TRUE, EL HILO DEBE PERMANECER A LA ESPERA.
			//EL METODO LANZA UNA INTERRUPTEDEXCEPTION, SE LA PONEMOS AL MÉTODO.
			//saldoSuficiente.await();
			
			
			//METODO DE OBJECT,HACE LO MISMO QUE AWAIT() 
			wait();
		
		}
		//PARA QUE IMPRIMA EL HILO QUE HARÁ LA TRANSFERENCIA
		System.out.println(Thread.currentThread());
		
		//DESCONTAR A LA CTA ORIGEN LA CANTIDAD QUE SE VA A TRANSFERIR
		cuentas[cuentaOrigen]-=cantidad;
		
		//INFÓRMAME LA CTA ORIGEN, CTA DESTINO Y $CANTIDAD 
		System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
		
		//INCREMENTAR CTA DESTINO
		cuentas[cuentaDestino]+=cantidad;
		
		//LLAMAMOS AL MÉTODO DE SALDO TOTAL
		System.out.printf("Saldo total: %10.2f%n",getSaldoTotal());
		
		//DESPIERTA A LOS DEMÁS HILOS QUE ESTÁN ESPERANDO Y LES INFORMA DE LA OPERACIÓN QUE REALIZÓ  
		//saldoSuficiente.signalAll();
		
		//METODO DE OBJECT QUE INFORMA A LOS DEMÁS HILOS QUE YA SE HA TERMINADO DE EJECUTAR.
		notifyAll();
		
		}//finally {
			//DESBLOQUEAMOS PARA QUE PUEDA ENTRAR UN NUEVO HILO
			//cierreBanco.unlock();
		//}
	//}
	
	public double getSaldoTotal() {
		//VARIABLE QUE ALMACENA EL SALDO (SUMA) DE TODAS LAS CTAS
		double sumaCuentas=0;
		for(double a : cuentas ) {
			sumaCuentas+=a;
		}
		return sumaCuentas;
	}
	private final double[]cuentas;//ARRAY DONDE SE ALMACENARÁN LAS CUENTAS
	//private Lock cierreBanco = new ReentrantLock();
	//private Condition saldoSuficiente;//ReentrantLock hereda de Condition.
}


class EjecucionTransferencias3 implements Runnable{
								//(obj Banco,cta origen, cantidad max a transferir)
	public EjecucionTransferencias3(Banco3 b, int de, double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	
	//MÉTODO QUE EJECUTA LOS HILOS
	@Override
	public void run() {
		// QUE SE HAGAN TRANSFERENCIAS INFINITAS
		
		try {
		while(true) {
			//HACEMOS QUE LA CTA DE DESTINO SEA ALEATORIA
			int paraLaCuenta = (int)(100*Math.random());
			//DETERMINAMOS CANTIDAD A TRANFERIR, PERO LA CANTIDAD MAX SERÁ 2000
			double cantidad = cantidadMax*Math.random();
			//LLAMAMOS AL METODO DE LAS TRANSFERENCIAS
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			//HACEMOS ALEATORIO EL TIEMPO DE CADA HILO
			Thread.sleep((int)Math.random()*10);
		}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private Banco3 banco;
	private int deLaCuenta;
	private double cantidadMax;
}