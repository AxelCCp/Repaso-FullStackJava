package JSPtags;

public class A0_243_Empleado {
	

	public A0_243_Empleado(String nombre, String apellido, String puesto, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.salario = salario;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}




	//CREAMOS 4 VARIABLES ENCAPSULADAS PARA MANEJAR LOS CAMPOS DE LA BBDD 
	private String nombre;
	private String apellido;
	private String puesto;
	private double salario;

}
