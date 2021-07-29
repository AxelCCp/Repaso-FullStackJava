package A0_Colecciones;

public class A2_181_Libro {

	public A2_181_Libro(String titulo,String autor, int ISBN) {
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
	}
	
	public String getDatos() {
		return "El título es: " + titulo + ". El autor es: " + autor + ". Y el ISBN es: " + ISBN;
	}
		
	//SOBREESCRIBIMOS EL MÉTODO DE LA CASE OBJECT "EQUALS()". DEVUELVE UN BOOLEAN...
	//...Y RECIBE POR PARÁMETRO UN OBJETO OBJECT.
	public boolean equals(Object obj) {
		if(obj instanceof A2_181_Libro) {
			A2_181_Libro otro = (A2_181_Libro) obj;
			if(this.ISBN==otro.ISBN) return true;
			else return false;
		}
		else return false;
		
	}
	
	//TAMBIÉN PODEMOS PEDIRLE A ECLIPSE QUE SOBREESCRIBA EL METODO EQUALS()
	

	
	private String titulo;
	private String autor;
	private int ISBN;
}
