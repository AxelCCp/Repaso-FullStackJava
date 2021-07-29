package A0_Colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A1_180_CuentasUsuarios {
	public static void main(String[]args) {
		A0_180_Cliente cl1 = new A0_180_Cliente("Antonio Banderas","00001",200000);
		A0_180_Cliente cl2 = new A0_180_Cliente("Rafael Nadal","00002",250000);
		A0_180_Cliente cl3 = new A0_180_Cliente("Penélope Cruz","00003",300000);
		A0_180_Cliente cl4 = new A0_180_Cliente("Julio inglesias","00004",500000);
		
		A0_180_Cliente cl5 = new A0_180_Cliente("Antonio Banderas","00001",200000);
	
		Set<A0_180_Cliente> clientesBanco = new HashSet<A0_180_Cliente> ();
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		
		clientesBanco.add(cl5);
		
		//----------------------------------------------------------------------------------
		//NOS GENERA ERROR SI TRATAMOS DE ELIMINAR Y LEER LA COLECCIÓN AL MISMO TIEMPO, USANDO...
		//...BUCLES FOR EACH
		/*for(A0_180_Cliente e : clientesBanco) {
			e.getNombre().equals("Julio inglesias");
			clientesBanco.remove(e);
		}*/
		
		
		//MEJOR ELIMINAR CON ITERATOR
		Iterator<A0_180_Cliente> it = clientesBanco.iterator();
		while (it.hasNext()) {
			String nombreCliente= it.next().getNombre();
			if(nombreCliente.equals("Julio inglesias")) it.remove();
		}
		
		for(A0_180_Cliente e : clientesBanco) {
			System.out.println("Nombre:" + e.getNombre() 
								+ ". Cuenta: " + e.getnCuenta()
								+ ". Saldo: " + e.getSaldo());
		}
		//----------------------------------------------------------------------------------
		
		//RECORREMOS LA COLECCIÓN  CON UN ITERADOR
		//iterator() DEVUELVE UN OBJ ITERATOR, POR ESO LO ALMACENAMOS EN "it" 
				    //<tipo>
		/*Iterator<A0_180_Cliente> it = clientesBanco.iterator();
		while (it.hasNext()) {
			String nombreCliente= it.next().getNombre();
			System.out.println(nombreCliente);
		}*/
	}
	

}
