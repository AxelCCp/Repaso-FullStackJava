package A1_JTree;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class A1_266_JTree2 {
	
	public static void main(String[]args) {
		MarcoArbol2 marco1 = new MarcoArbol2();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}

}


class MarcoArbol2 extends JFrame{
	public MarcoArbol2() {
		setTitle("Arbol sencillo");
		setBounds(350,300,600,600);
		
		//CREAMOS ARBOL CON NODOS DESDE LA RAÍZ
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo"); 
		DefaultMutableTreeNode pais = new DefaultMutableTreeNode("España");
		raiz.add(pais);
		DefaultMutableTreeNode comunidad = new DefaultMutableTreeNode("Madrid"); 
		pais.add(comunidad);
		DefaultMutableTreeNode mostoles= new DefaultMutableTreeNode("Mostoles"); 
		comunidad.add(mostoles);
		DefaultMutableTreeNode alcobendas = new DefaultMutableTreeNode("Alcobendas"); 
		comunidad.add(alcobendas);
		
		comunidad = new DefaultMutableTreeNode("Cantabria"); 
		pais.add(comunidad);
		DefaultMutableTreeNode santillana= new DefaultMutableTreeNode("Santillana del Mar"); 
		comunidad.add(santillana);
		
		//CREAMOS EL OBJ DE TIPO ARBOL JTREE Y AL CONTRUCTOR DE JTREE LE PASAMOS LA RAIZ
		JTree arbol = new JTree(raiz);
		
		//getContentPane() DEVUELVE UN OBJ DE TIPO CONTENEDOR,PARA ESPECIFICAR EL CONTENEDOR DE ESTE JFRAME
		Container laminaContenido = getContentPane(); 
		laminaContenido.add(new JScrollPane(arbol));
	}
}


