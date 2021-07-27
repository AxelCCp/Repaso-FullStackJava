package B1_ProgramacionGenerica;

import java.util.ArrayList;

public class A0_161_UsoEmpleadoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//ARRAY NORMAL
		/*Empleado listaEmpleados[] = new Empleado[3];
		listaEmpleados[0] = new Empleado("Bra", 17,2800);
		listaEmpleados[1] = new Empleado("Pan", 15,2500);
		listaEmpleados[2] = new Empleado("Giru", 10,2000);*/
		
		//ARRAYLIST
		ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();
		//listaEmpleados.ensureCapacity(12); //USAMOS ESTE MÉTODO PARA NO CONSUMIR MÁS MEMORIA QUE 12 ELEMENTOS DEL ARRAYLIST
		listaEmpleados.add(new Empleado("Bra", 17,2800));
		listaEmpleados.add(new Empleado("Pan", 15,2500));
		listaEmpleados.add(new Empleado("Giru", 10,2000));
		listaEmpleados.add(new Empleado("Bra", 17,2800));
		listaEmpleados.add(new Empleado("Pan", 15,2500));
		listaEmpleados.add(new Empleado("Giru", 10,2000));
		listaEmpleados.add(new Empleado("Bra", 17,2800));
		listaEmpleados.add(new Empleado("Pan", 15,2500));
		listaEmpleados.add(new Empleado("Giru", 10,2000));
		listaEmpleados.add(new Empleado("Bra", 17,2800));
		listaEmpleados.add(new Empleado("Pan", 15,2500));
		//PARA ELEGIR LA POSICIÓN DONDE QUEREMOS INCLUIR ELEMENTO.
		listaEmpleados.set(5,new Empleado("Androide18", 10,2000));
		
		//CORTAMOS EL EXCESO DE MEMORIA QUE ESTÁ SIN USAR
		//listaEmpleados.trimToSize();
		
		//PARA IMPRIMIR UN ELEMENTO DE ARRAYLIST EN ESPECIAL
		System.out.println(listaEmpleados.get(4).dameEmpleados());
		
		//IMPRIMIMOS EL TAMAÑO DEL ARRAYLIST
		System.out.println("Elementos: " +  listaEmpleados.size());
		
		/*//BUCLE FOR-EACH
		System.out.println("Elementos: " +  listaEmpleados.size());
		for(Empleado x : listaEmpleados) {
			System.out.println(x.dameEmpleados());
		}*/
		
		/*//BUCLE FOR
		for(int i=0;i<listaEmpleados.size();i++) {
			//ALAMCENAMOS EN "e" LOS ELEMENTOS DEL ARRAYLIST
			Empleado e =listaEmpleados.get(i); 
			System.out.println(e.dameEmpleados());
		}*/
		
		//GUARDAMOS LA INFORMACIÓN DEL ARRAYLIST EN UN ARRAY CONVENSIONAL Y LO RECORREMOS
		//CREAMOS ARRAY Y LE DAMOS LA LONGITUD DEL ARRAYLIST:
		Empleado arrayEmpleados[]= new Empleado[listaEmpleados.size()];
		//COPIAMOS LA INFORMACIÓN EN EL ARRAY CONVENSIONAL:
		listaEmpleados.toArray(arrayEmpleados);
		//RECORREMOS
		for(int i=0;i<arrayEmpleados.length;i++) {
			System.out.println(arrayEmpleados[i].dameEmpleados());
		}
	}	
}


class Empleado{
	
	public Empleado(String nombre, int edad,double salario) {
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