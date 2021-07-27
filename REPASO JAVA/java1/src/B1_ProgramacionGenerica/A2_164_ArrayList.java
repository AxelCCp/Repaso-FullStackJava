package B1_ProgramacionGenerica;
//PRUEBA DE QUE ES MEJOR USAR PROGRAMACIÓN GENERICA
public class A2_164_ArrayList {
	
	
	public A2_164_ArrayList(int z) {
		datosElemento= new Object[z];
	}
	
	public Object get(int i) {
		return datosElemento[i];
	}
	
	public void add(Object o) {
		datosElemento[i]=0;
		i++;
	}
	
	
	private Object[]datosElemento;
	private int i=0;
}
