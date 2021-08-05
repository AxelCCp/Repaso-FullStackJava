package A2_JTable_SwingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class A1_268__UsoJTable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco1 = new MarcoTablaPersonalizado();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);
	}

}


class MarcoTablaPersonalizado extends JFrame{
	public MarcoTablaPersonalizado () {
		setTitle("Tabla Personalizada");
		setBounds(200,50,700,700);
		
		TableModel miModelo = new ModeloTablaPersonalizada();
		JTable miTabla = new JTable(miModelo);
		add(new JScrollPane(miTabla));
	}
}

class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3; //ESTABLECE N° DE COLUMNAS
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5; //ESTABLECE N° DE FILAS
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		int z = rowIndex + 1;
		int y = columnIndex + 2;
		return " " + z + " " + y;
	}
	
	// LE CAMBIAMOS EL NOMBRE A LAS COLUMNAS
	public String getColumnName(int c) {
		return "Columna " + c;
	}
	
}

