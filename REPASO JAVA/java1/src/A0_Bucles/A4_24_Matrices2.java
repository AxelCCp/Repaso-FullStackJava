package A0_Bucles;

public class A4_24_Matrices2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[]paises= new String[8];
		
		paises[0] ="españa";
		paises[1] ="méxico";
		paises[2] ="Colombia";
		paises[3] ="Perú";
		paises[4] ="chile";
		paises[5] ="argentina";
		paises[6] ="ecuador"; 
		paises[7] ="venezuela";
		
		
		for(int i=0; i<paises.length; i++) {
			System.out.println("país " + i + " " + paises[i] );
		}
		
		int z = 0;
		for(String elementos: paises) {
		z++;	
			System.out.println("país " + z +  " " +  elementos );
		}
		
		
	}

}
