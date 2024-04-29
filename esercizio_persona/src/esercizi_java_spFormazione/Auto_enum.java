package esercizi_java_spFormazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Auto_enum {

	public Auto_enum() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("elenco_auto.txt");
		Scanner scanner = new Scanner(file);
		
		
		
		while (scanner.hasNext()) {

        }
		
		
	//	// Scan and print elements 
	//	for (EnumAuto enumElement : EnumAuto.values()) {
	//	System.out.println("Ordinal:"+enumElement.ordinal() + " Value:"+enumElement.toString());
	//	}
	//	// Get enum from string
	//	e = EnumAuto.valueOf(EnumAuto.class, "MEDIUM");
	//	System.out.println("Enum object value obtained by string 'MEDIUM':"+e.toString());
	//	// Get info from specific enum value
	//	System.out.println("Counter for MEDIUM:"+e.getCounter());
	//	System.out.println("Alternative text for MEDIUM:"+e.getAlText());
	}

}
