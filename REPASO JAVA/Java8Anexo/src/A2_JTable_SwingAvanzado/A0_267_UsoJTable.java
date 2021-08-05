package A2_JTable_SwingAvanzado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//JTABLE SE USAN PARA MOSTRAR DATOS EN FORMA DE TABLA

public class A0_267_UsoJTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco1 = new MarcoTabla();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}
}


class MarcoTabla extends JFrame{
	public MarcoTabla() {
		setTitle("Los planetas");
		setBounds(200,50,700,700);
		JTable tablaPlanetas = new JTable(datosFilas,nombresColumnas);
		add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
		JButton botonImprimir = new JButton("Imprimir Tablas");
		botonImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					tablaPlanetas.print();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		JPanel laminaBoton = new JPanel();
		laminaBoton.add(botonImprimir);
		add(laminaBoton,BorderLayout.SOUTH);
	}
	
	private String[]nombresColumnas = {"Nombre","Radio","Lunas","Gaseoso"};
	private Object[][]datosFilas = {
			
			{"Mercurio",2440.0,0,false},
			{"Venus",6052.0,0,false},
			{"Tierra",6378.0,1,false},
			{"Marte",3397.0,2,false},
			{"Júpiter",71492.0,16,true},
			{"Saturno",60268.0,18,true},
			{"Urano",25559.0,17,true},
			{"Neptuno",24766.0,8,true},
			{"Plutón",1137.0,1,false}
			
	};
}
