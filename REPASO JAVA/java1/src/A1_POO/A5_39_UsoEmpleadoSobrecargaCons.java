package A1_POO;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class A5_39_UsoEmpleadoSobrecargaCons {
	
	public static void main(String[]args) {
		
		Jefatura jefeRRHH = new Jefatura("Maestro Rochi",55000,2006,9,25);
		jefeRRHH.setEstableceIncentivo(20000);
		
		EmpleadoY [] misEmpleados = new EmpleadoY[6];
		misEmpleados[0] = new EmpleadoY("Goku",85000,1990,12,17);
		misEmpleados[1] = new EmpleadoY("Vegeta",90000,1995,7,15);
		misEmpleados[2] = new EmpleadoY("Androide 18",120000,1990,8,25);
		misEmpleados[3] = new EmpleadoY("Cell");
		//POLIMORFISMO,UN OBJ DE TIPO JEFATURA ENTRÓ EN EL ARRAY DE TIPO EMPLEADOY.(PRINCIPIO DE SUSTITUCIÓN)
		misEmpleados[4] = jefeRRHH; 
		misEmpleados[5] = new Jefatura("Maron", 70000,1995,7,5);
		//CASTING O REFUNDICIÓN, PARA PODERU SAR MÉTODO DE CLASE JEFATURA  
		Jefatura jefaFinanzas = (Jefatura)misEmpleados[5];
		jefaFinanzas.setEstableceIncentivo(55000);
		
		
		EmpleadoY directorComercial = new Jefatura("Bra",85000,2021,05,05); 
		//PODEMOS CREAR UNA INSTANCIA DE TIPO "Comparable", PERO A LA HORA DE INSTANCIARLA, DECIMOS QUE ES DE TIPO EMPLEADO.
		Comparable ejemplo = new EmpleadoY("Pan", 95000,2011,06,07);
		//COMPROBAR SI UNA INSTANCIA PERTENECE A UNA CLASE
		if(directorComercial instanceof EmpleadoY) {
			System.out.println("Es de tipo jefatura");
		}
		if(ejemplo instanceof Comparable) {
			System.out.println("Implementa la interfazcomparable");
		}
		
		
		System.out.println(jefaFinanzas.tomarDecisiones("Dar más días de vacasiones a los empleados"));
		System.out.println("El Jefe: " + jefaFinanzas.getNombre() + " tiene un bonus de: " + jefaFinanzas.estableceBonus(500));
		System.out.println(misEmpleados[3].getNombre() + " Tiene un Bonus de " + misEmpleados[3].estableceBonus(500));
		
		for(EmpleadoY e :misEmpleados) {
			e.setSubeSueldo(5);
		}
		
		//USAMOS MÉTODO DE LA CLASE ARRAYS PARA ORDENAR MISEMPLEADOS 
		Arrays.sort(misEmpleados);
		
		for(EmpleadoY e : misEmpleados) {
			System.out.println("Nombre: " + e.getNombre() + ". Sueldo: " + e.getSueldo() + ". Fecha de alta: " + e.getDate());
		}
	}
}

//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class EmpleadoY implements Comparable, B1_51_Trabajadores{
	//CONSTRUCTORES
	public EmpleadoY(String nom, double sue, int agno, int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	public EmpleadoY(String nom) {
		this(nom,30000,2000,01,01);
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
	
	@Override
	public int compareTo(Object miObjeto) {
		EmpleadoY otroEmpleado = (EmpleadoY)miObjeto;
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public double estableceBonus(double gratificacion) {
		// TODO Auto-generated method stub
		return B1_51_Trabajadores.bonusBase + gratificacion;
	}
	
	//VARIABLES DECLARADAS
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
}

//CLASE JEFATURA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class Jefatura extends EmpleadoY implements B0_50_Jefes{ 
	public Jefatura(String nom,double sue, int agno, int mes, int dia) {
		//LLAMAMOS AL CONSTRUCTOR CLASE PADRE Y LE PASAMOS LOS PARÁMETROS DEL JEFE
		super(nom,sue,agno,mes,dia);
	}
	//METODOS
	public void setEstableceIncentivo(double b) {
		incentivo=b;
	}
	public double getSueldo() {
		double sueldoJefe = super.getSueldo();
		return sueldoJefe + incentivo;
	}
	@Override
	public String tomarDecisiones(String decision) {
		// TODO Auto-generated method stub
		return "Un mienbro de ladirección ha tomado la decisioón de: " + decision;
	}
	@Override
	public double estableceBonus(double gratificacion) {
		// TODO Auto-generated method stub
		double prima = 2000;
		return B1_51_Trabajadores.bonusBase + gratificacion + prima;
	}
	private double incentivo;
}


