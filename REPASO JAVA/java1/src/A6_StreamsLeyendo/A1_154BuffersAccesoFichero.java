package A6_StreamsLeyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class A1_154BuffersAccesoFichero {
	public static void main(String[]args) {
		LeerFichero2 accediendo = new LeerFichero2();
		accediendo.lee();
	}
}

class LeerFichero2 {
	public void lee() {
		try {
			entrada = new FileReader("C:/Users/Boo/Downloads/STREAMS.txt");
			//ALMACENAMOS EN EL BUFFER,LAMEMORIA INTERMEDIA, EL FICHERO TXT.
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea="";
			
			while(linea!=null) {
				linea= miBuffer.readLine(); //con el buffer leemos línea a línea.
				if(linea!=null)System.out.println(linea);
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se encontró el archivo");
			e.printStackTrace();
		}
	}
	FileReader entrada;
}