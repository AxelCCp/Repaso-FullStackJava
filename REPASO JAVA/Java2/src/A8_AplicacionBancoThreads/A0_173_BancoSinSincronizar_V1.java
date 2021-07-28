package A8_AplicacionBancoThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A0_173_BancoSinSincronizar_V1 {
	public static void main(String[]args) {
		Banco b = new Banco();
		for(int i=0;i<100;i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b,i,2000);
			Thread t = new Thread(r);
			t.start();
		}
	}
}


class Banco{
	public Banco() {
		cuentas = new double[100];
		//CARGAMOS LAS CUENTAS CON 2000 EUROS
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
	}
	
	public void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) {
		
		//BLOQUEAMOS EN MÉTODO PARA QUE EL MÉTODO SEA RECORRIDO SOLO POR UN HILO A LA VEZ.
		//ENCERRAMOS EL MÉTODO EN UN try/finally
		cierreBanco.lock();
		
		try {
		
		//PARA QUE LA CANTIDAD A TRANSFERIR NO SEA SUPERIOR AL SALDO DE LA CTA.
		if(cuentas[cuentaOrigen]<cantidad) {
			//SI EL SALDO DE LA CTA ES INFERIOR A LA CANTIDAD, IMPRIME ESTO: 
			System.out.println("---------------Cantidad insuficiente: " + cuentaOrigen + "... Saldo: " + cuentas[cuentaOrigen] + "... Cantidad: " + cantidad);
			return;
		}else {
			System.out.println("-------------Cantidad OK-----------" + cuentaOrigen);
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
	
	//ARRAY DONDE SE ALMACENARÁN LAS CUENTAS
	private final double[]cuentas;
	private Lock cierreBanco = new ReentrantLock();
}


class EjecucionTransferencias implements Runnable{
								//(obj Banco,cta origen, cantidad max a transferir)
	public EjecucionTransferencias(Banco b, int de, double max) {
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
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
}
