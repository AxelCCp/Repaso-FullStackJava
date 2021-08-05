package A1_JTree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class A0_266_JTree {
	
	public static void main(String[]args) {
		MarcoArbol marco1 = new MarcoArbol();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}

}


class MarcoArbol extends JFrame{
	public MarcoArbol() {
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
		
		//LE PASAMOS EL ARBOL AL CONTRUCTOR DE LA LÁMINA
		LaminaArbol lamina1 = new LaminaArbol(arbol);
		add(lamina1);
	}
}

class LaminaArbol extends JPanel{
	public LaminaArbol(JTree miArbol) {
		setLayout(new BorderLayout());
		add(miArbol,BorderLayout.NORTH);
	}
}
