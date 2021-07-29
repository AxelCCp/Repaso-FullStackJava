package A1_Colecciones;
//USAMOS M�TODO COMPARETO() DE LA INTERFAZ COMPARABLE
import java.util.TreeSet;

public class A6_186_PruebaTreeSet {
	public static void main(String[]args) {
		TreeSet<String>ordenaPersonas = new TreeSet<String>();
		ordenaPersonas.add("Robot Octavio");
		ordenaPersonas.add("Aral�");
		ordenaPersonas.add("Tao PaiPai");
		
		for(String z : ordenaPersonas) {
			
			//LOS ELEMENTOS STRING SE ORDENAN ALFAB�TICAMENTE, YA QUE LA CLASE STRING IMPLEMENTA..
			//..LA INTERFAZ COMPARABLE QUE TIENE EL M�TODO COMPARETO()
			System.out.println(z);
		}
		
		//------------------------------------------------------------------------
		
		Articulo primero = new Articulo(1,"primer art�culo");
		Articulo segundo = new Articulo(2,"segundo art�culo");
		Articulo tercero = new Articulo(3,"tercer art�culo");
		TreeSet<Articulo>ordenaArticulos = new TreeSet<Articulo>();
		
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		
		
		for(Articulo x: ordenaArticulos) {
			System.out.println(x.getDescripcion());
		}
	}
}


// LA INTERFAZ COMPARABLE ADMITE UNGEN�RICO POR PAR�METRO, EN ESTE CASO SER� ART�CULO
class Articulo implements Comparable<Articulo>{
	public Articulo(int num,String desc) {
		numArticulo=num;
		descripcion=desc;
	}
	
	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
		return numArticulo - o.numArticulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private int numArticulo;
	private String descripcion;
}