package A7_StreamsEscribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class A1_153_EscribiendoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo lapiz = new Escribiendo();
		lapiz.escribir();
	}

}

class Escribiendo{
	public void escribir() {
		String frase = "Esto es una prueba de escritura";
		try {
			FileWriter escritura = new FileWriter("C:/Users/Boo/Downloads/texto153.txt");
			//PARA ESCRIBIR SOBRE UN FICHERO TXT QUE YA EXISTE.
			//FileWriter escritura = new FileWriter("C:/Users/Boo/Downloads/texto153.txt",true);
			for(int i=0;i<frase.length();i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}