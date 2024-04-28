package esempiVari.scanner;

import java.time.LocalDate;

import java.util.Scanner;

/*
 * ScannerFormattedString
 * 
 * Input: stringa con elenco di files AAAA-MM-GG size name.ext
 * 
 * 1) Restituire "NO FILES" o counter files validi
 *    Contare solo i files con data < 13 Ottobre 1995
 *    Usare LocalDate.of(yyy,mm,gg) per creare una data e LocalDate.iBefore()
 *    per confrontare le date
 *
 * 2) Restituire INPUT INVALID e stoppare l'elaborazione se input malformato
 *      Se size > (240K) scartare il nome file e continue
 *      Se non c'è estensione (.)  
 *      Se non c'è suffix dopo .  
 *      Se suffix diverso da rar zip tgz   
 *
 * 3) Scartare il file corretto individuato se size > (240K)
 *
 * Esempio di stringa in input:
 * 
 *                  "1988-08-29 956 system.zip " 
 *	              + "1995-10-12 245760 old-photos.tgz " 
 *				  + "1989-11-05 245761 file2.rar "
 *				  + "1994-12-01 845 very-long-filename.rar " 
 *				  + "1988-11-05 400 file1.txt ";
 */ 
public class ScanFileNames { 
	int countFiles = 0;
	String A2;
	String ret = "";

	public static void main(String[] args) {
		ScanFileNames S = new ScanFileNames();
		S.run();
	}

	public void run() {

		String S1 = "1988-08-29 956 system.zip " 
				  + "1995-10-12 245760 old-photos.tgz " 
				  + "1989-11-05 245761 file2.rar "
				  + "1994-12-01 845 very-long-filename.rar " 
				  + "1988-11-05 400 file1.txt ";

		System.out.println(solution(S1));

	}

	public String solution(String S) {
		String date = "";
		String name = "";
		String ext = "";
		String arExt[] = null;
		long size = 0;
		int yyyy;
		int mm;
		int dd;

		Scanner scn = new Scanner(S);

		while (scn.hasNext()) {
			
			date = scn.next();
			
			if (scn.hasNextLong()) {
				size = scn.nextLong();
				if (scn.hasNext()) {
					name = scn.next();
				}
			} else {
				countFiles = -1;   // Invalid input
				break;
			}

			// File information available

			// Check Size
			if (size > (240 * 1024)) {
				continue;
			}

			// Check file name
			arExt = name.split("\\.");
			if (arExt.length != 2) {
				countFiles = -1;   // Invalid input
				break;
			}
			// Check file name extension
			if (!ext.equals("zip") && !ext.equals("rar") && !ext.equals("tgz")) {
				countFiles = -1;
				break;
			}

			// Check data
			LocalDate limitDate = LocalDate.of(1995, 10, 13);
			try {
				yyyy = Integer.parseInt(date.substring(0, 4));
				mm = Integer.parseInt(date.substring(5, 7));
				dd = Integer.parseInt(date.substring(8));
			} catch (NumberFormatException e) {
				countFiles = -1;
				break;
			}
			LocalDate curDate = LocalDate.of(yyyy, mm, dd);
			System.out.println(curDate.toString());
			if (curDate.isBefore(limitDate)) {
				countFiles++;
			}
		}

		if (countFiles == 0) {
			ret = "NO FILES";
		} else if (countFiles == -1) {
            ret = "INPUT INVALID";
		} else {
			ret = countFiles + "";
		}
		
		return ret;
	}

}
