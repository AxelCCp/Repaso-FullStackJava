package B2_ProgramacionGenericaClasesPropias;
//CREAMOS CLASES GEN�RICAS PROPIAS


//CONVERTIMOS A LA CLASE EN UNA CLASE GEN�RICA, LE PONEMOS UN "ARGUMENTO GEN�RICO" DE TIPO <> LLAMADO T
public class A0_165_Pareja <T>{
	public A0_165_Pareja() {
		primero=null;
	}
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	//NOS VA A DEVOLVER UN OBJ DE TIPO GENER�CO QUE PODR�A SER DE CUALQUIER TIPO.
	public T getPrimero() {
		return primero;
	}
	private T primero;
}
