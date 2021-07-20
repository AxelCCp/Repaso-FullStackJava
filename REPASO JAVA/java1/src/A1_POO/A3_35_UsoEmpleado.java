package A1_POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class A3_35_UsoEmpleado {
	public static void main(String[]args) {
		
		EmpleadoX [] misEmpleados = new EmpleadoX[3];
		misEmpleados[0] = new EmpleadoX("Goku",85000,1990,12,17);
		misEmpleados[1] = new EmpleadoX("Vegeta",90000,1995,7,15);
		misEmpleados[2] = new EmpleadoX("Androide 18",120000,1990,8,25);
		for(int i=0;i<3;i++) {
			misEmpleados[i].setSubeSueldo(5);
		}
		for(int i=0;i<3;i++) {
			System.out.println("Nombre: " + misEmpleados[i].getNombre() + ". Sueldo: " + misEmpleados[i].getSueldo() + ". Fecha de alta: " + misEmpleados[i].getDate());
		}
		
	}
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

class EmpleadoX{
	//CONSTRUCTOR
	public EmpleadoX(String nom, double sue, int agno, int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	//MÉTODOS
	public String getNombre() {
		return nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getDate() {
		return altaContrato;
	}
	public void setSubeSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	//VARIABLES DECLARADAS
	private String nombre;
	private double sueldo;
	private Date altaContrato;
}



