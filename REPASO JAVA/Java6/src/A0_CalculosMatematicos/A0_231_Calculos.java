package A0_CalculosMatematicos;

public class A0_231_Calculos {
	
	//HACEMOS A LA VARIABLE Y A LOS M�TODOS "static" PARA QUE SOLO USEMOS LAS EL NOMBRE DE...
	//...LA CLASE A LA HORA DE LLAMAR A LOS M�TODOS EN EL ARCHIVO JSP. ESTO PARA NO HACER ...
	//..TANTO C�DIGO EN EL JSP.
	
	private static int resultado;
	public static int metodoSuma(int num1, int num2){
		resultado=num1+num2;
		return resultado;
	}

	public static int metodoResta(int num1, int num2){
		resultado=num1-num2;
		return resultado;
	}

	public static int metodoMultiplica(int num1, int num2){
		resultado=num1*num2;
		return resultado;
	}
}
