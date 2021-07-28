package B2_ProgramacionGenericaClasesPropias;

public class A4_167_HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		A5_167_Empleados administrativa = new A5_167_Empleados("Milk", 39,2500);
		A6_167_Jefe directoraComercial = new A6_167_Jefe("Bra",15,1500);
		//PRINCIPIO ES UN: UN JEFE SIEMPRE ES UN EMPLEADO POR LO TANTO SE PUEDE HACER ESTA IGUALDAD.
		A5_167_Empleados nuevoEmpleado = directoraComercial;
		*/
		
		//USAMOS LA CLASE PAREJA Y LE PASAMOSUN TIPO EMPLEADO
		A0_165_Pareja <A5_167_Empleados> administrativa = new A0_165_Pareja <A5_167_Empleados>();
		A0_165_Pareja <A6_167_Jefe> directoraComercial = new A0_165_Pareja <A6_167_Jefe>();
		//NO PODEMOS USAR EL PRINCIPIO DE SUSTITUCIÓN CON LAS CLASES GENERÍCAS
		//A0_165_Pareja <A5_167_Empleados>> nuevompleado = directoraComercial; 
		
		A0_165_Pareja.imprimirTrabajador(administrativa);
		
		//EL MÉTODO PERMITE RECIBIR UN ARGUMENTO DE TIPO JEFE, YA QUE EL MÉTODO PUEDE RECIBIR CUALQUIER..
		//OBJ QUE HEREDE EMPLEADOS <? extends A5_167_Empleados>
		A0_165_Pareja.imprimirTrabajador(directoraComercial);
	}

}
