package B0_ManipulacionDeFicherosYDirectorios;

import java.io.File;

public class A1_159_AccesoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
						    
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "Boo" + File.separator + "Downloads");
		System.out.println(ruta.getAbsoluteFile());
		//ALMCENAMOS EN UN ARRAY TODO LO QUE HAY EN "RUTA"
		String[]nombresArchivos = ruta.list();
		
		for(int z=0;z<nombresArchivos.length;z++) {
			System.out.println(z);
			File f = new File(ruta.getAbsolutePath(),nombresArchivos[z]);       //EXAMINA LA RUTA ABSOLUTA + NOMBRES DE CADA ARCHIVO.
			if(f.isDirectory()==true) {
				String[]archivosSubCarpeta = f.list();
				for(String y : archivosSubCarpeta) {
					System.out.println(y);
				}
			}
		}
	}

}
