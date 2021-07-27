package B1_ProgramacionGenerica;

import java.util.ArrayList;
import java.util.Iterator;
public class A1_163_Iteradores {

	public static void main(String[] args) {
		
		//ARRAYLIST
		ArrayList<Empleado2>listaEmpleados = new ArrayList<Empleado2>();
		//listaEmpleados.ensureCapacity(12); //USAMOS ESTE M�TODO PARA NO CONSUMIR M�S MEMORIA QUE 12 ELEMENTOS DEL ARRAYLIST
		listaEmpleados.add(new Empleado2("Bra", 17,2800));
		listaEmpleados.add(new Empleado2("Pan", 15,2500));
		listaEmpleados.add(new Empleado2("Giru", 10,2000));
		listaEmpleados.add(new Empleado2("Bra", 17,2800));
		listaEmpleados.add(new Empleado2("Pan", 15,2500));
		listaEmpleados.add(new Empleado2("Giru", 10,2000));
		listaEmpleados.add(new Empleado2("Bra", 17,2800));
		listaEmpleados.add(new Empleado2("Pan", 15,2500));
		listaEmpleados.add(new Empleado2("Giru", 10,2000));
		listaEmpleados.add(new Empleado2("Bra", 17,2800));
		listaEmpleados.add(new Empleado2("Pan", 15,2500));
		//PARA ELEGIR LA POSICI�N DONDE QUEREMOS INCLUIR ELEMENTO.
		listaEmpleados.set(5,new Empleado2("Androide18", 10,2000));
		
		//CORTAMOS EL EXCESO DE MEMORIA QUE EST� SIN USAR
		//listaEmpleados.trimToSize();
		
		//PARA IMPRIMIR UN ELEMENTO DE ARRAYLIST EN ESPECIAL
		System.out.println(listaEmpleados.get(4).dameEmpleados());
		
		//IMPRIMIMOS EL TAMA�O DEL ARRAYLIST
		System.out.println("Elementos: " +  listaEmpleados.size());
		
		/*//BUCLE FOR-EACH--------------------------------------------//
		System.out.println("Elementos: " +  listaEmpleados.size());
		for(Empleado2 x : listaEmpleados) {
			System.out.println(x.dameEmpleados());
		}*/
		
		/*//BUCLE FOR-------------------------------------------------//
		for(int i=0;i<listaEmpleados.size();i++) {
			//ALAMCENAMOS EN "e" LOS ELEMENTOS DEL ARRAYLIST
			Empleado2 e =listaEmpleados.get(i); 
			System.out.println(e.dameEmpleados());
		}*/
		
		//ITERADOR----------------------------------------------------//
		//Iterator()DEVUELVE UN OBJ DE TIPO ITERATOR Y SE ALMACENA EN miIterador.
		Iterator<Empleado2>miIterador = listaEmpleados.iterator();
		//hasNext() NOS DICE SI TENEMOS M�S OBJETOS DENTRO DE LA COLLECCI�N.
		while(miIterador.hasNext()==true) {
			//next() RECORREMOS LA LISTA Y NOS DEVUELVE LOS OBJETOS.
			System.out.println(miIterador.next().dameEmpleados());
		}
	}	
}


class Empleado2{
	
	public Empleado2(String nombre, int edad,double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String dameEmpleados() {
		return "El empleado se llama: " + nombre + ". Tiene una edad de: " + edad + ". Su salario es de: " + salario ;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}