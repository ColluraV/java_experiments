package esercizi_java_spFormazione;

import java.util.Scanner;
/*definire la stringa inp a programm ed estrarre con scanner, verificandone il tpo
 * e stampado gli interi, le stringhe e i double*/
public class ExtractionScanner {

	public static void main(String[]args) {
		
		String inp="123 T-DHIRT 200,5";
		Scanner sc = new Scanner(inp);	
		String s = "";
		int i;
		double d;
		
		if (sc.hasNextInt()) {
			i=sc.nextInt();
			System.out.println(i);
		}
		
		if (sc.hasNext()) {
			s=sc.next();
			System.out.println(s);
		}
		
		if (sc.hasNextDouble()) {
			d=sc.nextDouble();
			System.out.println(d);
		}
	}
	
	
}

		