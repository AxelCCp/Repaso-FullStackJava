package B0_ManipulacionDeFicherosYDirectorios;

import java.io.File;

public class A3_160_Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BORRAMOS EL ARCHIVO CREADO EN LA CLASE A2_160_Creando
		
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "Boo" + File.separator + "Downloads" + File.separator + "ARCHIVONUEVO.TXT");
		ruta.delete();
	}
	

}
