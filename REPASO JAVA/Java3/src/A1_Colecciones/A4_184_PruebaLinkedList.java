package A1_Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class A4_184_PruebaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList <String> persona = new LinkedList <String>();
		persona.add("MrPOPO");
		persona.add("Tortuga");
		persona.add("Khrilin");
		persona.add("Pilaf");
		
		System.out.println(persona.size());
		
		//CREAMOS ITERATOR
		ListIterator <String> it = persona.listIterator();
		it.next();//NOS DESPLAZAMOS UNA POSICIÓN ADELANTE EN LA LISTA.
		//AGREGAMOS AL Dr.Maquijero DESPUÉS DE MR.POPO
		it.add("Dr.Maquijero");
		
		for (String p : persona)
			System.out.println(p);
	}

}
