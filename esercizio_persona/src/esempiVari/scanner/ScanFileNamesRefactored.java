package esempiVari.scanner;

import java.time.LocalDate;

import java.util.Scanner;

/*
 * ScanFileNamesRefactored
 * 
 * Versione "refactored" di ScanFileNames
 * 
 * Input: stringa con elenco di files AAAA-MM-GG size name.ext
 * 
 * 1) Restituire "NO FILES" o counter files validi
 *    Contare solo i files con data < 13 Ottobre 1995
 *    Usare LocalDate.of(yyy,mm,gg) per creare una data e LocalDate.iBefore()
 *    per confrontare le date
 *
 * 2) Restituire INPUT INVALID e STOP se input malformato
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

public class ScanFileNamesRefactored { 
	final String INPUT_INVALID = "INPUT INVALID";
	final String NO_FILES = "NO FILES";
	
	private LocalDate limitDate;
	private LocalDate curDate;
	private String dateFile;
	private String fileName;
	private String ext;
	private long size;
	private int countFiles;
	
	public static void main(String[] args) {
		ScanFileNamesRefactored S = new ScanFileNamesRefactored();
		S.run();
	}

	public void run() {

		String S1 = "1998-08-29 956 system.zip " 
				  + "1995-10-12 245760 old-photos.tgz " 
				  + "1989-11-05 245761 file2.rar "
				  + "1994-12-01 845 very-long-filename.rar " 
				  + "1988-11-05 400 file1.txt ";

		System.out.println(solution(S1));

	}

	public String solution(String S) {
		Scanner scn = new Scanner(S);  
		countFiles = 0;
		boolean isInputInvalid = false;
        
		while (scn.hasNext()) {
			
			// Date extraction
			extractData(scn);
			
			// Size extraction
			if (!checkSizeAndExtract(scn)) {
				isInputInvalid = true;
				break;
			}
						
			// File extraction
			if (!checkFileAndExtract(scn)) {
				isInputInvalid = true;
				break;
			}
			
			// Check Size
			if (isFileLengthOverSize()) {continue;}

			// Check extension
			if (!isFileExtensionGood(fileName)) {
				isInputInvalid = true;
				break;
			}
			
			// Check data
			if (!isFileDateGood(dateFile)) {
				isInputInvalid = true;
				break;
			}
			
			// File formally good: count if old file
			countOldFiles();
		}
		scn.close();
		
		return setReturnValue(isInputInvalid);
	}

	private String setReturnValue(boolean isInputInvalid) {
		
		String ret = "";
		
		if (isInputInvalid) {
			return INPUT_INVALID;
		}
		
		if (countFiles == 0) {
			ret = NO_FILES;
		} else {
			ret = countFiles + "";
		}
		return ret;
	}

	private void countOldFiles() {
		if (curDate.isBefore(limitDate)) {
			countFiles++;
		}
	}

	private boolean isFileDateGood(String dateFile) {
		limitDate = LocalDate.of(1995, 10, 13);
     
		int yyyy = 0;
		int mm = 0;
		int dd = 0;
		
		try {
			yyyy = Integer.parseInt(dateFile.substring(0, 4));
			mm = Integer.parseInt(dateFile.substring(5, 7));
			dd = Integer.parseInt(dateFile.substring(8));
			curDate = LocalDate.of(yyyy, mm, dd);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}

	private boolean isFileExtensionGood(String fileName) {
		String arExt[];
		
		arExt = fileName.split("\\.");
		if (arExt.length != 2) {
			return false;
		}	
		
		ext = arExt[1];
		
		if (!ext.equals("zip") 
		&&  !ext.equals("rar")
		&&  !ext.equals("tgz")) {
			return false;
		}
		return true;
	}

	private boolean isFileLengthOverSize() {
		return size > (240 * 1024);
	}

	private String extractData(Scanner scn) {
		dateFile = scn.next();
		return dateFile;
	}

	private boolean checkSizeAndExtract(Scanner scn) {
		
		if (!scn.hasNextLong()) {return false;}	
		
		size = scn.nextLong();
	    return true;
	}
	
	private boolean checkFileAndExtract(Scanner scn) {
		
		if (!scn.hasNext()) {
			return false;
		}
		fileName = scn.next();
	return true;
		
	}

}
