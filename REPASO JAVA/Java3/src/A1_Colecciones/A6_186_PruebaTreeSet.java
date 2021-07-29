package A1_Colecciones;
//USAMOS MÉTODO COMPARETO() DE LA INTERFAZ COMPARABLE
import java.util.TreeSet;

public class A6_186_PruebaTreeSet {
	public static void main(String[]args) {
		TreeSet<String>ordenaPersonas = new TreeSet<String>();
		ordenaPersonas.add("Robot Octavio");
		ordenaPersonas.add("Aralé");
		ordenaPersonas.add("Tao PaiPai");
		
		for(String z : ordenaPersonas) {
			
			//LOS ELEMENTOS STRING SE ORDENAN ALFABÉTICAMENTE, YA QUE LA CLASE STRING IMPLEMENTA..
			//..LA INTERFAZ COMPARABLE QUE TIENE EL MÉTODO COMPARETO()
			System.out.println(z);
		}
		
		//------------------------------------------------------------------------
		
		Articulo primero = new Articulo(1,"primer artículo");
		Articulo segundo = new Articulo(2,"segundo artículo");
		Articulo tercero = new Articulo(3,"tercer artículo");
		TreeSet<Articulo>ordenaArticulos = new TreeSet<Articulo>();
		
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		
		
		for(Articulo x: ordenaArticulos) {
			System.out.println(x.getDescripcion());
		}
	}
}


// LA INTERFAZ COMPARABLE ADMITE UNGENÉRICO POR PARÁMETRO, EN ESTE CASO SERÁ ARTÍCULO
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