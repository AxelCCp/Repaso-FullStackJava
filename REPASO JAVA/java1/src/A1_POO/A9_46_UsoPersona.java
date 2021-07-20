package A1_POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class A9_46_UsoPersona {	
	public static void main(String[]args) {
		
		Persona [] lasPersonas = new Persona[2];
		lasPersonas[0] = new EmpleadoZ("Ulon",30000,2011,3,20);
		lasPersonas[1] = new Alumno("Puar", "Commputación Ing");
		
		for(Persona e : lasPersonas) {
			System.out.println(e.getNombre() + ", "+ e.getDescripcion());
		}
	}
}

abstract class Persona{
	public Persona(String nom) {
		nombre=nom;
	}
	//MÉTODOS
	public String getNombre() {
		return "Nombre: " + nombre;
	}
	public abstract String getDescripcion();
	//VARIABLES DECLARADAS
	private String nombre;
}


class EmpleadoZ extends Persona{
	//CONSTRUCTORES
	public EmpleadoZ(String nom, double sue, int agno, int mes, int dia) {
		super(nom);
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	//MÉTODOS	
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
	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Este empleado tiene un ID ??? con un sueldo de " + sueldo;
	}
	//VARIABLES DECLARADAS
	private double sueldo;
	private Date altaContrato;	
}


class Alumno extends Persona{
	public Alumno(String nom, String car) {
		super(nom);
		carrera=car;
	}
	public String getDescripcion() {
		return "Esta es la descripción del alumno, está estudiando la carrera de: " + carrera;
	}
	
	private String carrera;
}




