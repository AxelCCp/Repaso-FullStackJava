package A0_Bucles;

public class A6_24_MatrizNumsAleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] aleatorios = new int [150];
		
		for(int i=0; i<aleatorios.length; i++) {
			aleatorios[i] = (int)Math.round(Math.random()*100);
		}
		
		
		for(int elementos: aleatorios) {
			System.out.print(elementos + "/");
		}

	}

}
