package A9_serializacion;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class A1_158_SerialVersionUID {
	public static void main(String[]args) {
		
		Administrador2 jefe = new Administrador2("Freezer",80000,2005, 12,15);
		jefe.setInsentivo(5000);
		
		Empleado2[]personal = new Empleado2[3];
		personal[0]=jefe;
		personal[1]=new Empleado2("Bulma",25000,2008,10,1);
		personal[2]=new Empleado2("Puar",10000,20015,9,20);
		
		try {
			/*
			//-----CREAMOS EL FLUJO DE DATOS EXTERNO (ESTE ES EL EMISOR DEL OBJ SERIALIZADO)------//
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("C:/Users/Boo/Downloads/empleado2.dat")); 
			escribiendoFichero.writeObject(personal);
			escribiendoFichero.close();
			*/
			
			//-----RECUPERAR EL FICHERO (ESTE ES EL RECEPTOR DEL OBJ SERIALIZADO)------//
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream("C:/Users/Boo/Downloads/empleado2.dat"));
			Empleado2[]personalRecuperado=(Empleado2[])recuperandoFichero.readObject();
			recuperandoFichero.close();
			//RECORREMOS EL ARRAY PARA VERLO
			for(Empleado2 x : personalRecuperado) {
				System.out.println(x);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Empleado2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Empleado2(String n, double s,int agno, int mes,int dia) {
		nombre=n;
		sueldo=s;
		GregorianCalendar calendar = new GregorianCalendar(agno,mes-1, dia);
		fechaContrato = calendar.getTime();
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void subirSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo+=aumento;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", sueldo: " + sueldo + ", fecha de contrato: " + fechaContrato;
	}
	
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
	
}



class Administrador2 extends Empleado2{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Administrador2(String n, double s, int agno,int mes, int dia) {
		super(n,s,agno,mes,dia);
		incentivo=0;
	}
	public double getSueldo() {
		double sueldoBase=super.getSueldo	();
		return sueldoBase + incentivo;
	}
	public void setInsentivo(double b) {
		incentivo=b;
	}
	public String toString() {
		return super.toString() + " Incentivo: " + incentivo;
	}
	private double incentivo;
}