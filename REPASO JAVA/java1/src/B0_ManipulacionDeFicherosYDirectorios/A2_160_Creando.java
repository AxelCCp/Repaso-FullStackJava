package B0_ManipulacionDeFicherosYDirectorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class A2_160_Creando {
	public static void main(String[]args) {
		//CREAMOS UNA NUEVA CARPETA, AL FINAL DE ESTE PATH PONEMOS EL NOMBRE DEL NUEVO DIRECTORIO  
		//File ruta = new File("C:" + File.separator + "Users" + File.separator + "Boo" + File.separator + "Downloads" + File.separator + "DirectorioJava");
		//ruta.mkdir();  //AQUÍ LO CREAMOS.
		
		//CREAMOS UN NUEVO ARCHIVO, AL FINAL DE ESTE PATH PONEMOS EL NOMBRE DEL NUEVO ARCHIVO 
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "Boo" + File.separator + "Downloads" + File.separator + "ARCHIVONUEVO.TXT");
		String archivoDestino = ruta.getAbsolutePath();
		
		//ESTE MÉTODO SE USA PARA CREAR ARCHIVOS.
		//PONEMOS EL NOMBRE DEL ARCHIVO EN EL PATH Y USAMOS ESTE MÉTODO.
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//ESCRIBIMOS EN EL ARCHIVO CON EL MÉTODO CREADO:
		Escribiendo accedeEs = new Escribiendo();
		accedeEs.escribir(archivoDestino);
	}
}


class Escribiendo{
	public void escribir(String rutaArchivo) {
		String frase = "Esto es un ejemplo";
		try {
			FileWriter escritura = new FileWriter(rutaArchivo);
			for(int i=0;i<frase.length();i++) {
				escritura.write(frase.charAt(i));	
			}
			escritura.close();
		}catch(IOException e ) {
			e.printStackTrace();
		}
	}
}