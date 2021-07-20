package A0_Bucles;

public class A8_26_MatrizBidimensional2 {
	public static void main(String[]args) {
		int[][] matrix = { 
				{12,34,45,76,43},
				{35,66,78,89,35},
				{45,63,36,2,588},
				{26,49,23,90,68}	
		};
		
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(matrix[i][j] + ",");
				if(j==4)System.out.println("");
			}
		}
		
		System.out.println("");
		
		for(int[]fila : matrix) {
			for(int columna:fila) {
				System.out.print(columna + ",");
			}
			System.out.println("");
			
		}
	}
}
