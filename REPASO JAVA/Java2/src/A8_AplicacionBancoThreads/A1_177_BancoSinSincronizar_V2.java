package A8_AplicacionBancoThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A1_177_BancoSinSincronizar_V2 {
	public static void main(String[]args) {
		Banco2 b = new Banco2();
		for(int i=0;i<100;i++) {
			EjecucionTransferencias2 r = new EjecucionTransferencias2(b,i,2000);
			Thread t = new Thread(r);
			t.start();
		}
	}
}


class Banco2{
	public Banco2() {
		cuentas = new double[100];
		//CARGAMOS LAS CUENTAS CON 2000 EUROS
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
		//EL BLOQUEO SE DEBE ESTABLECER EN BASE A UNA CONDICI�N
		saldoSuficiente = cierreBanco.newCondition();
	}
	
	public void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) throws InterruptedException {
		
		//BLOQUEAMOS EN M�TODO PARA QUE EL M�TODO SEA RECORRIDO SOLO POR UN HILO A LA VEZ.
		//ENCERRAMOS EL M�TODO EN UN try/finally
		cierreBanco.lock();
		
		try {
		
		//PARA QUE LA CANTIDAD A TRANSFERIR NO SEA SUPERIOR AL SALDO DE LA CTA.
		while(cuentas[cuentaOrigen]<cantidad) {
			
			//MIENTRAS LA CONDICI�N DEL WHILE SEA TRUE, EL HILO DEBE PERMANECER A LA ESPERA.
			//EL METODO LANZA UNA INTERRUPTEDEXCEPTION, SE LA PONEMOS AL M�TODO.
			saldoSuficiente.await();
		
		}
		//PARA QUE IMPRIMA EL HILO QUE HAR� LA TRANSFERENCIA
		System.out.println(Thread.currentThread());
		
		//DESCONTAR A LA CTA ORIGEN LA CANTIDAD QUE SE VA A TRANSFERIR
		cuentas[cuentaOrigen]-=cantidad;
		
		//INF�RMAME LA CTA ORIGEN, CTA DESTINO Y $CANTIDAD 
		System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
		
		//INCREMENTAR CTA DESTINO
		cuentas[cuentaDestino]+=cantidad;
		
		//LLAMAMOS AL M�TODO DE SALDO TOTAL
		System.out.printf("Saldo total: %10.2f%n",getSaldoTotal());
		
		//DESPIERTA A LOS DEM�S HILOS QUE EST�N ESPERANDO Y LES INFORMA DE LA OPERACI�N QUE REALIZ�  
		saldoSuficiente.signalAll();
		
		}finally {
			//DESBLOQUEAMOS PARA QUE PUEDA ENTRAR UN NUEVO HILO
			cierreBanco.unlock();
		}
	}
	
	public double getSaldoTotal() {
		//VARIABLE QUE ALMACENA EL SALDO (SUMA) DE TODAS LAS CTAS
		double sumaCuentas=0;
		for(double a : cuentas ) {
			sumaCuentas+=a;
		}
		return sumaCuentas;
	}
	private final double[]cuentas;//ARRAY DONDE SE ALMACENAR�N LAS CUENTAS
	private Lock cierreBanco = new ReentrantLock();
	private Condition saldoSuficiente;//ReentrantLock hereda de Condition.
}


class EjecucionTransferencias2 implements Runnable{
								//(obj Banco,cta origen, cantidad max a transferir)
	public EjecucionTransferencias2(Banco2 b, int de, double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	
	//M�TODO QUE EJECUTA LOS HILOS
	@Override
	public void run() {
		// QUE SE HAGAN TRANSFERENCIAS INFINITAS
		
		try {
		while(true) {
			//HACEMOS QUE LA CTA DE DESTINO SEA ALEATORIA
			int paraLaCuenta = (int)(100*Math.random());
			//DETERMINAMOS CANTIDAD A TRANFERIR, PERO LA CANTIDAD MAX SER� 2000
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
	private Banco2 banco;
	private int deLaCuenta;
	private double cantidadMax;
}