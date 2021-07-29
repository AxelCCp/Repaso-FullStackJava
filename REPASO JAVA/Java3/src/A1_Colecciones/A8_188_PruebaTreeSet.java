package A1_Colecciones;
import java.util.Comparator;
//USAMOS MÉTODO COMPARE() DE LA INTERFAZ COMPARATOR, PERO LO HACEMOS DESDE UNA CLASE DIFERENTE.
import java.util.TreeSet;

public class A8_188_PruebaTreeSet {
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
		
		ArticuloY primero = new ArticuloY(1,"primer artículo");
		ArticuloY segundo = new ArticuloY(2,"segundo artículo");
		ArticuloY tercero = new ArticuloY(3,"tercer artículo");
		TreeSet<ArticuloY>ordenaArticulos = new TreeSet<ArticuloY>();
		
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		
		
		for(ArticuloY x: ordenaArticulos) {
			//ORDENA POR NUMERO numArticulo
			System.out.println(x.getDescripcion());
		}
		System.out.println("-----------------------------------");
	
		//CREAMOS EL NUEVO COMPARADOR
		ComparadorArticulos ComparaAr = new ComparadorArticulos();
		TreeSet<ArticuloY> ordenaArticulos2 = new TreeSet<ArticuloY>(ComparaAr);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercero);
		
		for(ArticuloY a :ordenaArticulos2) {
			//ORDENAALAFABÉTICAMENTE POR LA DESCRIPCIÓN
			System.out.println(a.getDescripcion());
		}
		System.out.println("-----------------------------------");
	}
}


//UNA CLASE NO PUEDE HEREDAR DE VARIAS CLASES, PERO SI UNA CLASE PUEDE IMPLEMENTAR + DE UNA INTERFAZ.
// LA INTERFAZ COMPARABLE Y COMPARATOR ADMITE UN GENÉRICO POR PARÁMETRO,...
//...EN ESTE CASO LES DECIMOS QUE VAN A COMPARAR OBJ's DE TIPO ARTICULO. 
 
class ArticuloY implements Comparable<ArticuloY> {
	
	
	
	public ArticuloY(int num,String desc) {
		numArticulo=num;
		descripcion=desc;
	}
	
	@Override
	public int compareTo(ArticuloY o) {
		// TODO Auto-generated method stub
		return numArticulo - o.numArticulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	private int numArticulo;
	private String descripcion;
}


class ComparadorArticulos implements Comparator<ArticuloY>{

	@Override
	public int compare(ArticuloY o1, ArticuloY o2) {
		// TODO Auto-generated method stub
		String desc1 = o1.getDescripcion();
		String desc2 = o2.getDescripcion();
		return desc1.compareTo(desc2);
	}
}