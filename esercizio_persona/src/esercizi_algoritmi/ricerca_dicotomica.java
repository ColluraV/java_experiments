package esercizi_algoritmi;

public class ricerca_dicotomica {
	
	int numDaCercare;
	int[] arNum= {2, 5, 8, 12, 25, 34, 45, 66, 75};
	int metàArray;
	int arEl;
	
	public ricerca_dicotomica(int valore) {
		numDaCercare=valore;
		metàArray= (arNum.length /2);
		
		do {
		
		if (valore==arNum[metàArray]) {
			System.out.println("il numero "+valore+" è alla posizione: "+(metàArray+1));
			break;
		}
		else if (valore>arNum[metàArray]) {
			metàArray=metàArray+(metàArray/2);

			
		}else
		metàArray=(metàArray/2);
		
		}while (arNum[metàArray]!=valore);
		
	}

	
	

}
