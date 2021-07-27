package A9_serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class A0_157_Serializando {
	public static void main(String[]args) {
		
		Administrador jefe = new Administrador("Freezer",80000,2005, 12,15);
		jefe.setInsentivo(5000);
		
		Empleado[]personal = new Empleado[3];
		personal[0]=jefe;
		personal[1]=new Empleado("Bulma",25000,2008,10,1);
		personal[2]=new Empleado("Puar",10000,20015,9,20);
		
		try {
			//CREAMOS EL FLUJO DE DATOS EXTERNO
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("C:/Users/Boo/Downloads/empleado.dat")); 
			//USAMOS EL FLUJO DE DATOS PARA ESCRIBIR EL OBJETO "personal" QUE QUEREMOS QUE VAYA AL EXTERIOR.
			escribiendoFichero.writeObject(personal);
			escribiendoFichero.close();
			//-----PARA RECUPERAR EL FICHERO------//
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream("C:/Users/Boo/Downloads/empleado.dat"));
			//PARA ALMACENAR LA INFORMACIÓN DEL OBJETO USAMOS UN OBJ ARRAY DE TIPO EMPLEADO, YA Q LA INFORMACION QUE SE GUARDÓ ERA UN ARRAY.
			Empleado[]personalRecuperado=(Empleado[])recuperandoFichero.readObject();
			recuperandoFichero.close();
			//RECORREMOS EL ARRAY PARA VERLO
			for(Empleado x : personalRecuperado) {
				System.out.println(x);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Empleado implements Serializable {
	public Empleado(String n, double s,int agno, int mes,int dia) {
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



class Administrador extends Empleado{
	public Administrador(String n, double s, int agno,int mes, int dia) {
		super(n,s,agno,mes,dia);
		incentivo=0;
	}
	public double getSueldo() {
		double sueldoBase=super.getSueldo();
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
