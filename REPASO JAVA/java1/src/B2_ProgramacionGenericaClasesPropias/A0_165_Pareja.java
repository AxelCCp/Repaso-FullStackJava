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
	private T primero;
}
