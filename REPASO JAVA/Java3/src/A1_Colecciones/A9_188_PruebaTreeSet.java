package A1_Colecciones;
import java.util.Comparator;
//USAMOS MÉTODO COMPARE() DE LA INTERFAZ COMPARATOR, PERO LO HACEMOS DESDE UNA CLASE DIFERENTE.
//AQUI LA CLASE QUE IMPLEMENTA EL METODO COMPARE() SERÁ ANÓNIMA.
import java.util.TreeSet;

public class A9_188_PruebaTreeSet {
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
		System.out.println("-----------------------------------");
		
		//------------------------------------------------------------------------
		
		ArticuloZ primero = new ArticuloZ(1,"primer artículo");
		ArticuloZ segundo = new ArticuloZ(2,"segundo artículo");
		ArticuloZ tercero = new ArticuloZ(3,"tercer artículo");
		TreeSet<ArticuloZ>ordenaArticulos = new TreeSet<ArticuloZ>();
		
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		
		
		for(ArticuloZ x: ordenaArticulos) {
			//ORDENA POR NUMERO numArticulo
			System.out.println(x.getDescripcion());
		}
		System.out.println("-----------------------------------");
	
		
		//PARA CREAR UN NUEVO OBJ COMPARADOR, LE PASAMOS AL TREESET LA CLASE INTERNA ANONIMA..
		//..QUE IMPLEMENTA AL MÉTODO COMPARE:
		
		TreeSet<ArticuloZ> ordenaArticulos2 = new TreeSet<ArticuloZ>(new Comparator<ArticuloZ>() {
			@Override
			public int compare(ArticuloZ o1, ArticuloZ o2) {
				// TODO Auto-generated method stub
				String desc1 = o1.getDescripcion();
				String desc2 = o2.getDescripcion();
				return desc1.compareTo(desc2);
			}
		});
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercero);
		
		for(ArticuloZ a :ordenaArticulos2) {
			//ORDENAALAFABÉTICAMENTE POR LA DESCRIPCIÓN
			System.out.println(a.getDescripcion());
		}
		System.out.println("-----------------------------------");
	}
}


//UNA CLASE NO PUEDE HEREDAR DE VARIAS CLASES, PERO SI UNA CLASE PUEDE IMPLEMENTAR + DE UNA INTERFAZ.
// LA INTERFAZ COMPARABLE Y COMPARATOR ADMITE UN GENÉRICO POR PARÁMETRO,...
//...EN ESTE CASO LES DECIMOS QUE VAN A COMPARAR OBJ's DE TIPO ARTICULO. 
 
class ArticuloZ implements Comparable<ArticuloZ> {
	
	
	
	public ArticuloZ(int num,String desc) {
		numArticulo=num;
		descripcion=desc;
	}
	
	@Override
	public int compareTo(ArticuloZ o) {
		// TODO Auto-generated method stub
		return numArticulo - o.numArticulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	private int numArticulo;
	private String descripcion;
}

