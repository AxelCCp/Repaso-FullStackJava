package A1_POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class A2_33_UsoEmpleado {
	public static void main(String[]args) {
		Empleado empleado1 = new Empleado("Goku", 1000000,2010,7,25);
		Empleado empleado2 = new Empleado("Vegeta", 1050300,2000,5,12);
		Empleado empleado3 = new Empleado("Androide 18", 2050000,2007,4,12);
		
		empleado1.setSubeSueldo(12);
		empleado2.setSubeSueldo(8);
		empleado3.setSubeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.getNombre() + ". Sueldo: " + empleado1.getSueldo() + ". fecha de alta: " + empleado1.getDate());
		System.out.println("Nombre: " + empleado2.getNombre() + ". Sueldo: " + empleado2.getSueldo() + ". fecha de alta: " + empleado2.getDate());
		System.out.println("Nombre: " + empleado3.getNombre() + ". Sueldo: " + empleado3.getSueldo() + ". fecha de alta: " + empleado3.getDate());
		
	}
}

class Empleado{
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
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
}

