package A0_Colecciones;

public class A3_181_UsoLibro {

	public static void main(String[]args) {
	
		A2_181_Libro libro1 = new A2_181_Libro("P de Java","Juan",25);
		A2_181_Libro libro2 = new A2_181_Libro("P de Java","Juan",25);
		
		libro1 = libro2; //ALMACENAMOS LA REFERENCIA AL MISMO OBJ EN LA MEMORIA HEAP
		
		if(libro1.equals(libro2)) System.out.println("Es el mismo libro"
								+ "\nHashCode Libro1: " + libro1.hashCode()
								+ "\nHashCode Libro2: " + libro2.hashCode());
		else System.out.println("No es el mismo libro." 
								+ "\nHashCode Libro1: " + libro1.hashCode()
								+ "\nHashCode Libro2: " + libro2.hashCode());
	}
}