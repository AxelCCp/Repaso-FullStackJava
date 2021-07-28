package B2_ProgramacionGenericaClasesPropias;

public class A5_167_Empleados {
	public A5_167_Empleados(String nombre,int edad, double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String dameDAtos() {
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años. Y un salario de " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}
