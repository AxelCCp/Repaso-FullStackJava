package A2_AplicacionesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class D1_91_AreasDeTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPruebaArea marco1 = new MarcoPruebaArea();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}


class MarcoPruebaArea extends JFrame{
	public MarcoPruebaArea() {
		setTitle("Probando área de texto");
		setBounds(500,300,500,350);
		//ESTABLECEMOS UNA DISPOSICIÓN EN EL MISMO MARCO
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		botonInsertar = new JButton("Insertar");
		//INSTANCIAMOS DIRECTAMENTE LA INTERFAZ ActionListener, EN VEZ DE UN OBJ DE UNA CLASE QUE IMPLEMENTE ESTA INTERFAZ.
		botonInsertar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				areaTexto.append("En un lugar de la mancha ...");
			}
		});
		laminaBotones.add(botonInsertar);
		botonSaltoLinea = new JButton("Salto Línea");
		botonSaltoLinea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean saltar =! areaTexto.getLineWrap(); 
				areaTexto.setLineWrap(saltar);
				/*if(saltar==true) {
					botonSaltoLinea.setText("Quitar salto");
				}else {
					botonSaltoLinea.setText("Salto Línea");
				}*/
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto línea");
			}
		});
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones,BorderLayout.SOUTH);
		areaTexto = new JTextArea(8,20);
		laminaConBarras = new JScrollPane(areaTexto);
		add(laminaConBarras,BorderLayout.CENTER);
	}
	private JPanel laminaBotones;
	private JButton botonInsertar;
	private JButton botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
}


