package A1_POO;
import java.util.*;
public class A0_48_TiposEnumerados {
	
	
	enum Talla{
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		
		//CONSTRUCTOR
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		public String getAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
	}
	
	
	
	public static void main(String[]args) {
		
	Scanner entrada = new Scanner(System.in);
	System.out.println("Ingresa una tallla: MINI,MEDIANO,GRANDE,MUY_GRANDE");
	String  datosEntrada = entrada.nextLine().toUpperCase();
	//DEVUELVE EL NOMBRE DE LA CONSTANTE
	Talla laTalla = Enum.valueOf(Talla.class, datosEntrada);
	System.out.println("LA TALLA ES:" + laTalla);
	System.out.println("Abreviatura: " + laTalla.getAbreviatura());
		
		
	}
}
