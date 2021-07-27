package B2_ProgramacionGenericaClasesPropias;
//CREAMOS CLASES GENÉRICAS PROPIAS


public class A1_165_UsoPareja {
	public static void main(String[]args) {
		
		A0_165_Pareja<String> una = new A0_165_Pareja<String>();
		//CAMBIAMOS EL VALOR DEL CAMPO DE CLASE NULL DE primero= null, ...A OTRA COSA.
		una.setPrimero("Rochi");
		System.out.println(una.getPrimero());
		
		Persona pers1 = new Persona("Bra");
		A0_165_Pareja<Persona>otra = new A0_165_Pareja<Persona>();
		//PRIMERO ES IGUAL A NULL Y LE TENEMOS QUE DECIR QUE PRIMERO=PERS1
		otra.setPrimero(pers1);
		System.out.println(otra.getPrimero());
		
	}
}


class Persona{
	
	Persona(String nombre) {
		this.nombre=nombre;
	}	
	
	public String toString() {
		return nombre;
	}
	
	private String nombre;
}