package A1_Colecciones;
import java.util.Comparator;
//USAMOS M�TODO COMPARE() DE LA INTERFAZ COMPARATOR
import java.util.TreeSet;

public class A7_187_PruebaTreeSet {
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
		
		ArticuloX primero = new ArticuloX(1,"primer art�culo");
		ArticuloX segundo = new ArticuloX(2,"segundo art�culo");
		ArticuloX tercero = new ArticuloX(3,"tercer art�culo");
		TreeSet<ArticuloX>ordenaArticulos = new TreeSet<ArticuloX>();
		
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		
		
		for(ArticuloX x: ordenaArticulos) {
			//ORDENA POR NUMERO numArticulo
			System.out.println(x.getDescripcion());
		}
		System.out.println("-----------------------------------");
	
		//PAS�NDOLE LA INSTANCIA comparadorArticulos AL TreeSet, POR PAR�METRO, CONSEGUIMOS QUE,...
		//...LA LISTA SE ORDENE SEG�N EL OBJETO DE ArticuloX, YA QUE ESTE OBJ ES DEL TIPO DE LA INTERFAZ..
		//.. COMPARE.POR LO TANTO EL TREESET VA A IR A VER QU� DICE EL METODO COMPARE() DE LA CLASE ARTICULOX.
		ArticuloX comparadorArticulos = new ArticuloX();
		TreeSet <ArticuloX>ordenaArticulos2 = new TreeSet <ArticuloX>(comparadorArticulos);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercero);
		
		for(ArticuloX a :ordenaArticulos2) {
			//ORDENAALAFAB�TICAMENTE POR LA DESCRIPCI�N
			System.out.println(a.getDescripcion());
		}
		System.out.println("-----------------------------------");
	}
}


//UNA CLASE NO PUEDE HEREDAR DE VARIAS CLASES, PERO SI UNA CLASE PUEDE IMPLEMENTAR + DE UNA INTERFAZ.
// LA INTERFAZ COMPARABLE Y COMPARATOR ADMITE UN GEN�RICO POR PAR�METRO,...
//...EN ESTE CASO LES DECIMOS QUE VAN A COMPARAR OBJ's DE TIPO ARTICULO. 
 
class ArticuloX implements Comparable<ArticuloX>, Comparator<ArticuloX>{
	
	public ArticuloX() {
		
	}
	
	public ArticuloX(int num,String desc) {
		numArticulo=num;
		descripcion=desc;
	}
	
	@Override
	public int compareTo(ArticuloX o) {
		// TODO Auto-generated method stub
		return numArticulo - o.numArticulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	@Override
	public int compare(ArticuloX arg0, ArticuloX arg1) {
		String descripcionA = arg0.getDescripcion();
		String descripcionB = arg1.getDescripcion();
		return descripcionA.compareTo(descripcionB);
	}
	
	private int numArticulo;
	private String descripcion;
}