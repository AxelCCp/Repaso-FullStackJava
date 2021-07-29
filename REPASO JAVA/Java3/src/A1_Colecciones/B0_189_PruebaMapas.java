package A1_Colecciones;

import java.util.HashMap;
import java.util.Map;

public class B0_189_PruebaMapas {
	public static void main(String[]args) {
		
		   	  //<CLAVE,VALOR>	
		HashMap<String,Empleado>personal = new 	HashMap<String,Empleado>();
		personal.put("145", new Empleado("Up"));
		personal.put("150", new Empleado("Baby"));
		personal.put("170", new Empleado("Tapión"));
		
		System.out.println(personal);
		
		//QUITAMOS UN ELEMENTO
		personal.remove("150");
		System.out.println(personal);
		
		//REMPLAZAMOS UN ELEMENTO
		personal.put("190", new Empleado("DragonDe4Estrellas"));
		System.out.println(personal);
		
		//DEVUELVE UNA COLECCIÓN DE TIPO SET {} E IMPRIME: 
		System.out.println(personal.entrySet());
		
		//USAMOS LA CLASE INTERNA DE SET MAP.ENTRY. RECORREMOS LOS ELEMENTOS Y QUE LOS DEVUELVA COMO SET:
		//personal.entrySet() DEVUELVE LO QUE HAY EN LA COLECCIÓN EN FORMA DE SET. 
		for(Map.Entry<String, Empleado> entrada : personal.entrySet()){
			String clave = entrada.getKey();
			Empleado valor = entrada.getValue();
			System.out.println("Clave: " + clave + " / Valor: " + valor);
		}
	}

}



class Empleado{
	public Empleado(String n) {
		nombre=n;
		sueldo=2000;
	}
	
	
	public String toString() {
		return "[Nombre= " + nombre + ", Sueldo= " + sueldo + "]"; 
	}
	
	private String nombre;
	private double sueldo;
}