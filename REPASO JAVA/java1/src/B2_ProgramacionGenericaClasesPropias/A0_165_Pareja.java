package B2_ProgramacionGenericaClasesPropias;
//CREAMOS CLASES GENÉRICAS PROPIAS


//CONVERTIMOS A LA CLASE EN UNA CLASE GENÉRICA, LE PONEMOS UN "ARGUMENTO GENÉRICO" DE TIPO <> LLAMADO T
public class A0_165_Pareja <T>{
	public A0_165_Pareja() {
		primero=null;
	}
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	//NOS VA A DEVOLVER UN OBJ DE TIPO GENERÍCO QUE PODRÍA SER DE CUALQUIER TIPO.
	public T getPrimero() {
		return primero;
	}
	
	
	//---CLASE 167----------------------------------------------------------------------------------
	//LE PASAMOS UN OBJ DE TIPO PAREJA, PERO Q ES DE TIPO EMPLEADO
	//LE PASAMOS UN ARGUMENTO DE TIPO P, QUE ES UN GENÉRICO DE LA CLASE PAREJA Y QUE ES DE TIPO EMPLEADOS
	
	/*public static void imprimirTrabajador(A0_165_Pareja <A5_167_Empleados> p) {
		A5_167_Empleados primero = p.getPrimero();
		System.out.println(primero);
	}*/
	
	//---CLASE 167----------------------------------------------------------------------------------
	//? extends A5_167_Empleados : LE DECIMOS QUE RECIBE UN ARGUMENTO "p" DE LA CLASE PAREJA, PERO..
	//QUE ES DE UN TIPO DE CUALQUIER CLASE QUE PUEDA HEREDAR DE EMPLEADOS.
	
	public static void imprimirTrabajador(A0_165_Pareja <? extends A5_167_Empleados> p) {
		A5_167_Empleados primero = p.getPrimero();
		System.out.println(primero);
	}
	
	//----------------------------------------------------------------------------------------------
	
	
	
	
	private T primero;
}
