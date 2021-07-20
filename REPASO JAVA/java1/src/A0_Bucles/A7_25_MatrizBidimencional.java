package A0_Bucles;

public class A7_25_MatrizBidimencional {
	public static void main(String[]args) {
		
		int matrix [][]= new int [4][5];
		
		matrix [0][0]=43;
		matrix [0][1]=54;
		matrix [0][2]=67;
		matrix [0][3]=989;
		matrix [0][4]=343;
		
		matrix [1][0]=65;
		matrix [1][1]=46;
		matrix [1][2]=35;
		matrix [1][3]=57;
		matrix [1][4]=45;
		
		matrix [2][0]=89;
		matrix [2][1]=76;
		matrix [2][2]=74;
		matrix [2][3]=76;
		matrix [2][4]=45;
		
		matrix [3][0]=45;
		matrix [3][1]=34;
		matrix [3][2]=2;
		matrix [3][3]=56;
		matrix [3][4]=8;
		
		
			for(int i=0;i<4; i++) {
				for(int j=0; j<5; j++) {
					System.out.println(matrix[i][j]);			
				}
		
				System.out.println("");
			}
			
			
		
	}

}
