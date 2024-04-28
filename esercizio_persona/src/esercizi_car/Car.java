package esercizi_car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Car {
     
     public String extractContentFromFile(String fileName) {
    	File file = new File(fileName);
    	String saveDefinedResult = "";
    	String saveNotDefinedResult = "";
    	String line;
    	String result = "";
    	try {
			FileReader fr = new FileReader(file);
			try (BufferedReader br = new BufferedReader(fr)) {
				line = br.readLine();
				if(line != null) {
				while(line != null) {
					saveDefinedResult += this.isBrandDefined(line);
					saveNotDefinedResult += this.notBrandDefined(line);
					line = br.readLine();
					}
				
				result = saveDefinedResult+"\n"+saveNotDefinedResult;
				} else {
					result = "file vuoto";
				}
			}
		} catch (FileNotFoundException e) {
			return "Missing file";
		} catch (IOException e) {
			return "Error";
		}
    	
    	
		return result; 
           
    }
     
    public String isBrandDefined(String line) {
    	String [] arLine = line.split(" ");
    	String saveResult = "";
    	for (EnumCar element : EnumCar.values()) {
			if(arLine[0].equals(element.toString())) {
				saveResult = element + this.numOfModels(arLine, element.getNameModels());
			}
		}
		return saveResult;
    }
    public String numOfModels(String [] arLine, String [] arModelEnum ) {
    	int modelCounter = 0;
    	String saveResult = "";
    	for (int i = 1; i < arLine.length; i++) {
			for (String models : arModelEnum ) {
				if(arLine[i].toUpperCase().equals(models.toUpperCase())) {					
					modelCounter++;
					saveResult += " " + models ;
					
				}
			}
		}
    	saveResult += " the model are " + modelCounter + "\n";
    	
		return saveResult;
    }
    
    public String notBrandDefined(String line) {
    	boolean flag = true;
    	String saveResult = "";
    	String [] arLine = line.split(" ");
    	for (EnumCar element : EnumCar.values()) {
			if(arLine[0].equals(element.toString())) {
				flag = false;
			}
		}
    	
    	if (flag) {
    	saveResult = arLine[0] + " is not defined" + "\n";
    	}
		return saveResult;
    }
    
}