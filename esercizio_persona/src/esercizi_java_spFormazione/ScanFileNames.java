package esercizi_java_spFormazione;

import java.time.LocalDate;
import java.util.Scanner;

public class ScanFileNames {
	public String solution(String s) {
		

		String data = null;
		String extension;
		String fileName;
		int size;
		int counter;
		

		
		Scanner sc = new Scanner(s);
	
		while (sc.hasNext()) {
			data=sc.next();
			
			// data formatter 
			String splitter="-";
			String[] splittedData=data.split(splitter);
			
			int aaaa=Integer.parseInt(splittedData[0]);
			int mm=Integer.parseInt(splittedData[1]);
			int gg=Integer.parseInt(splittedData[2]);
			
			LocalDate formattedData = LocalDate.of(aaaa,mm,gg); 
			LocalDate definedData = LocalDate.of(1995,10,15); 
			

				if(formattedData.isBefore(definedData)==false){
					return "DATA TROPPO RECENTE";
				}
			if (!sc.hasNextInt()) {
				return "INPUT INVALID"; 
			}
			size=sc.nextInt();
			
			if (!sc.hasNext()) {
				return "INVALID NAME";
			}
			fileName=sc.next();
						
			
		}
		
		
		
		return "0";
		}
}
