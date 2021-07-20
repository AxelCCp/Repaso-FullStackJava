package A1_POO;

public class A4_36_Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados empleado1 = new Empleados("Bulma");
		empleado1.setCambiaSeccion("Desarrollo");
		
		Empleados empleado2 = new Empleados("Puar");
		empleado2.setCambiaSeccion("RRHH");
		
		Empleados empleado3 = new Empleados("Ulon");
		empleado3.setCambiaSeccion("ADM");
		
		System.out.println(empleado1.getDevuelveDatos());
		System.out.println(empleado2.getDevuelveDatos());
		System.out.println(empleado3.getDevuelveDatos());
		System.out.println(Empleados.getSiguienteId());
	}
}
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

class Empleados{
	
	public Empleados(String nom) {
		id=idSiguiente;
		idSiguiente++;
		nombre=nom;
		seccion="administración";
	}
	
	public void setCambiaSeccion(String seccion) {
		this.seccion=seccion;
	}
	
	public String getDevuelveDatos() {
		return "Id: " + id + " El nombre es: " + nombre + " y su sección es: " + seccion  + ".";
	}
	
	public static String getSiguienteId() {
		return "El siguiente Id es: " + idSiguiente; 
	}
	
	//VARIABLES DECLARADAS 
	private final String nombre;
	private String seccion;
	private int id;
	private static int idSiguiente=1;
}