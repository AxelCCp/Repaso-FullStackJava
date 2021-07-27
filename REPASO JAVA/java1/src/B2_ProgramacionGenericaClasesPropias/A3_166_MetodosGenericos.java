package B2_ProgramacionGenericaClasesPropias;
//import B1_ProgramacionGenerica.Empleado;

//EL M�TODO GEN�RICO SE PUDE ADAPTAR A DIFERENTES TIPOS DE ARRAY, EN ESTE CASO UNO DE TIPO STRING.

public class A3_166_MetodosGenericos {
	public static void main(String[]args) {
		String[]nombres= {"Cooler","Frezer","MajinBoo"};
		String elementos = MisMatrices2.getMenor(nombres);
		System.out.println(elementos);
	}
}


//METODO GEN�RICO QUE ORDENE LOS ELEMENTOS DEL ARRAY
//ESTE M�TODO YA NO VA A DEVOLVER UN STRING, VA A DEVOLVER EL ELEMENTO DEL ARRAY QUE SEA MENOR,
//..POR LO TANTO DEVOLVER� UN DATO GEN�RICO,YA Q SI SE LE PASA UN STRING,DEVOLVER� UN STRING. 
//..SI LE PASAMOS UN INT, NOS DEVOLVER� UN INT.

//Extends: EL M�TODO COMPARETO() ES DE LA INTERFAZ COMPARABLE. POR LO TANTO, LOS OBJ's QUE USEN ESTE..
//..M�TODO DEBEN IMPLEMENTAR LA INTERFAZ COMPARABLE. PARA DECIRLE A LOS TIPOS GENERICOS QUE...
//IMPLEMENTEN LA INTERFAZ COMPARABLE SE USA "EXTENDS" PARA LA IMPLEMENTACI�N DE LA INTERFAZ. NO SE..
//USA IMPLEMENTS.

//(ESTO SE HACE AS� PQ ASI PODEMOS PASARLE DIFERENTES TIPOS DE ARGUMENTOS DE CLASES QUE... 
//..IMPLEMENTEN LA INTERFAZ COMPARABLE. EJ: CLASE STRING, DATE, GREGORIANCALENDAR,ETC).

class MisMatrices2 {
	public static <T extends Comparable> T getMenor(T[]a) {
		if(a==null || a.length==0) {
			return null;
		}
		T elementoMenor = a[0];
		for(int i=1;i<a.length;i++) {
			if(elementoMenor.compareTo(a[i])>0) {
				elementoMenor=a[i];
			}
		}
		return elementoMenor;
	}
}