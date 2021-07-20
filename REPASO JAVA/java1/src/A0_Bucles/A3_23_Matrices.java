package A0_Bucles;

public class A3_23_Matrices {
	
	public static void main(String[]args) {
		
		/*
		int [] matrizA = new int[5];
		matrizA[0]=45;
		matrizA[1]=23;
		matrizA[2]=99;
		matrizA[3]=100;
		matrizA[4]=444;
		*/
		
		int[]matrizA = {45,23,99,100,444};
		
		System.out.println(matrizA[4]);
		
		for(int i=0; i<5; i++) {
			System.out.println(matrizA[i]);
		}
		
		for (int i=0; i<matrizA.length; i++) {
			System.out.println(matrizA[i]);
		}
			
		for (int i=5; i==0; i--){
			System.out.println(matrizA[i]);
		}
		
		
		
		
		
	}

}
