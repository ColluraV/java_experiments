package esercizi_java_spFormazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StampaMatriceDaFile {

    public static void main(String[] args) {
        StampaMatriceDaFile stampaMatrice = new StampaMatriceDaFile();

        String result = stampaMatrice.stampa("matrice.txt", 3, 3);
        System.out.println(result);
    }

    public String stampa(String fileName, int numRighe, int numColonne) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            int[][] matrice = new int[numRighe][numColonne];

            String line;
            int riga = 0;
            
            //lettura righe file
            while ((line = br.readLine()) != null) {
            	
            	//verifica numero righe non superiore
            	if (riga>=numRighe) {
            		return "INVALID_DATA";
            	}
                Scanner scanner = new Scanner(line);
                int colonna = 0;
                
                
                while (scanner.hasNext()) {
                	if (!scanner.hasNextInt()) {
						return "NOT-NUMERIC-VALUE";
					}
                	//verifica numero colonne non superiore
                	if(colonna>=numColonne) {
                		return "INVALID_DATA";
                	}
                    matrice[riga][colonna] = scanner.nextInt();
                    colonna++;
                }
                scanner.close();
                
                //verifica numero colonne non inferiore
                if (colonna<numColonne) {
            		return "INVALID_DATA";
				}
                riga++;
            }

            br.close();
        	//verifica numero righe non superiore
        	if (riga<numRighe) {
        		return "INVALID_DATA";
        	}

            // Stampa la matrice
            for (int i = 0; i < numRighe; i++) {
                for (int j = 0; j < numColonne; j++) {
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.println();
            }

            return "Matrice stampata";
        } 
        catch (IOException e) {
            return "INVALID-FILE-NAME";
        } 
        
    }
}
