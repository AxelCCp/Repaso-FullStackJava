package A3_Introspeccion;


/**
 * 
 * @author Boo
 *
 */

public class A0_271_UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona giru = new Persona("Giru");
		System.out.println(giru.getNombre());
		System.out.println(giru.getClass());
		
		Empleado bulma = new Empleado("Bulma",700000); 
		System.out.println(bulma.getNombre());
		System.out.println(bulma.getSalario());
		
		
		Class b = bulma.getClass();
		System.out.println(b.getName());
		
	}
}

//----------------------------------
class Persona{
	public Persona(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	private String nombre;
}

//----------------------------------
class Empleado extends Persona{
	public Empleado(String nombre, double salario) {
		super(nombre);
		this.salario=salario;
	}
	
	public void setIncentivo(double incentivo) {
		salario = salario + incentivo; 
	}
	
	public String getSalario() {
		return "El Salario es: " + salario;
	}
	
	private double salario;
}