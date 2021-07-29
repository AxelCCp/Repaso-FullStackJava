package A1_Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class A5_185_PruebaListaEnlazada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String>paises = new LinkedList<String>();
		paises.add("España");
		paises.add("EEUU");
		paises.add("China");
		paises.add("Korea");
		
		LinkedList<String>capitales = new LinkedList<String>();
		capitales .add("Madrid");
		capitales .add("Washington");
		capitales .add("Pekín");
		capitales .add("Seul");
		
		//System.out.println(paises);
		//System.out.println(capitales);
	
		//ITERADOR PARA IMPRIMIR PAÍS Y CIUDAD----------------------------------
		ListIterator<String>iter1 = paises.listIterator();
		ListIterator<String>iter2 = capitales.listIterator();
		//MIENTRAS(CON ITER1 HAYA ELEMENTO SIGUIENTE)
		while(iter2.hasNext()) {
			//SI(EN ITER2 HAY SIGUIENTE)
			if(iter1.hasNext()) {
				//AVÁNZAME EL ITER1
				iter1.next();
			}
			//CON EL AVANCE DEL ITER1, AGRÉGAME EL ITER2
			iter1.add(iter2.next());
		}
		System.out.println(paises);
		//----------------------------------------------------------------------
		
		//LLAMAMOS DE NUEVO  AL ITERADOR Y LO USAMOS PARA ELMINAR LAS POSICIONES PARES DE LA LISTA CAPITALES.
		//AL LLAMARLO DE NUEVO, EL ITERADOR VUELVE AL PRINCIPIO DE LA LISTA.
		iter2 = capitales.listIterator();
		//MIENTRAS(CON ITER2 HAYA UN ELEMENTO SIGUIENTE)
		while(iter2.hasNext()) {
			//ITER2 PASA AL SIGUIENTE
			iter2.next();
			//SI(HAY ELEMENTO SIGUIENTE)
			if(iter2.hasNext()) {
				//SALTA AL SIGUIENTE
				iter2.next();
				//Y ELIMINA EL ELEMENTO DONDE ITER2 ESTÁ EN EL IF 
				iter2.remove();
			}
		}
		System.out.println(capitales);
		paises.removeAll(capitales);
		System.out.println(paises);
	}
}
