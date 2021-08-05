package B7_JFileChooser_VentanaBusqueda;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class A0_227_VentanaExploradorArchivos {

	public static void main(String[] args) {
		
		Marco marco1 = new Marco();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//CREA INSTANCIA Y USA CONSTRUCTOR POR DEFECTO. 
		JFileChooser chooser = new JFileChooser();
		
		//SE CREA FILTRO Y POR PAR�METRO SE ESPECIFICAN LOS TIPOS SE ARCHIVOS QUE SE PODR�N BUSCAR EN LA VENTANA. 
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto", "txt");
		
		//SE ESTABLECE EL FILTRO
		chooser.setFileFilter(filter);
		
		//showOpenDialog(parent) RECIBE UN COMPONENTE PADRE 
		int returnVal = chooser.showOpenDialog(marco1);
		
		//EVAL�A Si returnVal es igual a JFileChooser.APPROVE_OPTION.
		//QUIERE DECIR QUE CUANDO LE DAMOS YES � OK � ACEPTAR A LA VENTANA, DESPU�S DE SELECCIONAR EL ARCHIVO...
		//...SE DEVUELVE UN VALOR INT. Y ESTE IF EVAL�A SI SE HA PULSADO ESTE BOT�N. 
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		       
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
		
		}
	}
}


class Marco extends JFrame{
	public Marco() {
		setBounds(300,300,300,300);
		setVisible(true);
	}
}