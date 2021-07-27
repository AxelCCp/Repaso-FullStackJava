package B1_ProgramacionGenerica;
import java.io.File;
//PRUEBA DE QUE ES MEJOR USAR PROGRAMACIÓN GÉNERICA
import java.util.ArrayList;

public class A3_164_UsoArrayList {
	public static void main(String[]args) {
		ArrayList archivos = new ArrayList(4);
		archivos.add("Cell");
		archivos.add("Vegeta");
		archivos.add("Broly");
		archivos.add("Ulon");
		archivos.add(new File("gestionPedidos.accdb"));
		
		String nombrePersona = (String) archivos.get(4);
		
		
		System.out.println(nombrePersona);
	}
}
