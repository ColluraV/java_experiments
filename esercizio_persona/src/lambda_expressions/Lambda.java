package lambda_expressions;
interface Executable{
	//void execute();
	int execute(int a);
	
	/*si può avere una funzione che ritorni un valore
	 * tipizzando il metodo
	 * public int execute();
	 * */
}

interface StringExecutable{
	String executeString(String z);
}

class Runner{
	public void run(Executable e, StringExecutable a) {
		System.out.println("yamete kudasai");
		System.out.println(e.execute(8));
		a.executeString("cavatappi");
	}
}

public class Lambda {
	public static void main(String[] args) {
		Runner runner= new Runner();
		runner.run( (a)->a+10, 
				(stringa)->{System.out.println(stringa); return stringa;});
		/*non abbreviata: runner.run((a)->{return a+8;});*/
		
		/* qualora ci fossero due run per utilizzare le due interfacce*/
		/* sarebbe necessario dichiarare il tipo di dato all'interno della expression*/
				/*		es:	runner.run(	(int a)->a+8,);		*/
				
//				//versione lambda
//				//()->{..codice da eseguire.. + return in caso di metodo con ritorno}
				//(()-> 8); versione ancora più abbreviata
				//()->{System.out.println("Sara troppo mia madre!!");}
				
				
//			/*versione non lambda*/
//				new Executable() {
//			@Override
//			public void execute() {	
//				System.out.println("Sara troppo mia madre!!");
				/*In caso di metodo con ritorno
				 * return 8;
				 * }*/
//			}
//		}
		
	}
}
