package A1_Colecciones;
import java.util.Comparator;
//USAMOS M�TODO COMPARE() DE LA INTERFAZ COMPARATOR, PERO LO HACEMOS DESDE UNA CLASE DIFERENTE.
//AQUI LA CLASE QUE IMPLEMENTA EL METODO COMPARE() SER� AN�NIMA.
import java.util.TreeSet;

public class A9_188_PruebaTreeSet {
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
		System.out.println("-----------------------------------");
		
		//------------------------------------------------------------------------
		
		ArticuloZ primero = new ArticuloZ(1,"primer art�culo");
		ArticuloZ segundo = new ArticuloZ(2,"segundo art�culo");
		ArticuloZ tercero = new ArticuloZ(3,"tercer art�culo");
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
		//..QUE IMPLEMENTA AL M�TODO COMPARE:
		
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
			//ORDENAALAFAB�TICAMENTE POR LA DESCRIPCI�N
			System.out.println(a.getDescripcion());
		}
		System.out.println("-----------------------------------");
	}
}


//UNA CLASE NO PUEDE HEREDAR DE VARIAS CLASES, PERO SI UNA CLASE PUEDE IMPLEMENTAR + DE UNA INTERFAZ.
// LA INTERFAZ COMPARABLE Y COMPARATOR ADMITE UN GEN�RICO POR PAR�METRO,...
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

