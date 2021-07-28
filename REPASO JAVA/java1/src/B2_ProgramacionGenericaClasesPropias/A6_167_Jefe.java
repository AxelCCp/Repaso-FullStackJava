package B2_ProgramacionGenericaClasesPropias;

public class A6_167_Jefe extends A5_167_Empleados{
	
	public A6_167_Jefe(String nombre,int edad,double salario) {
		super(nombre,edad,salario);
	}
	
	double incentivo(double inc) {
		return inc;
	}
}
