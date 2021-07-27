package B2_ProgramacionGenericaClasesPropias;
//import B1_ProgramacionGenerica.Empleado;

//EL MÉTODO GENÉRICO SE PUDE ADAPTAR A DIFERENTES TIPOS DE ARRAY, EN ESTE CASO UNO DE TIPO STRING Y OTRO DE TIPO EMPLEADO.

public class A2_166_MetodosGenericos {
	public static void main(String[]args) {
		String[]nombres= {"Cooler","Frezer","MajinBoo"};
		String elementos = MisMatrices.getElementos(nombres);
		System.out.println(elementos);
		
		/*
		Empleado[]listaEmpleados = {
				new Empleado("Bulma",39,4500),
				new Empleado("Bulma",39,4500),
				new Empleado("Bulma",39,4500),
				new Empleado("Bulma",39,4500),
				new Empleado("Bulma",39,4500)
		};
		System.out.println(MisMatrices.getElementos(listaEmpleados));
		*/
	}
}


class MisMatrices{
	//MÉTODO GENÉRICO
	//STATIC: PARA CONVERTIRLO EN UN MÉTODO DE CLASE, PARA NO TENER QUE INSTANCIAR UNA LA CLASE MISMATRICES
	//<T> ARGUMENTO DE TIPO
	//String: DEVOLVEÁ UN DATO DE TIPO STRING.
	//(T[]a): RECIVE POR PARÁMETRO UN ARRAY DE TIPO GENÉRICO, YA QUE NO SE SABE DE QUE TIPO SERÁ EL ARRAY QUE LE VAMOS A PASAR.
	public static <T> String getElementos(T[]a) {
		return "El array tiene una longitud de " + a.length + " elementos.";
	}
}