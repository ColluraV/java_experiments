package esercizi_car;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.migrationsupport.EnableJUnit4MigrationSupport;

import enumeration_correct.EnumLevelComplex;
import enumeration_correct.EnumerazioniSimple;

public class ScanAutoEnum implements Auto{
	List<String> lsFileInput;
	String fileName ;
	List<String> lsRowsGood;
	List<String> lsRowsWrong;	
	Set<String> setBrand;
	
	//COSTRUTTORE
	public ScanAutoEnum(String fileName) throws FileNotFoundException {
		super();
		this.fileName = fileName;
		lsFileInput= new ArrayList<String>();
		lsRowsGood= new ArrayList<String>();
		lsRowsWrong= new ArrayList<String>();
		setBrand= new TreeSet<String>();
		readAndCheckFile();
		
	}
	
	
	public void readAndCheckFile() throws FileNotFoundException {
		//

		File file= new File(fileName);
		Scanner scnFile= new Scanner(file);
		Scanner scnModels= null;
		String models="";
		String brand="";
		String model="";
		boolean isModelDefined=false;
		
			while (scnFile.hasNextLine()){
					
				brand=scnFile.next();
				if (brand.isBlank()) {
					continue;
				}
				if (scnFile.hasNext()) {
					models=scnFile.nextLine();
				}else {
					lsRowsWrong.add(brand);
					continue;
				}
							
				if (!existsProducer(brand)) {
					lsRowsWrong.add(brand);
					continue;
				}
				
				setBrand.add(brand);
				
				scnModels = new Scanner(models);
				isModelDefined=false;
				
				while (scnModels.hasNext()) {
					
					model=scnModels.next();
					
					if (existsModel(brand, model)) {
						isModelDefined=true;
						break;
					}
				}
				
				if (!isModelDefined) {
					lsRowsWrong.add(brand + " " + models);
					continue;
				}
				lsRowsGood.add(brand + " " + models);
			}
	}
	
	
	

	@Override
	public String[] rowsWrong() {
		return lsRowsWrong.toArray(new String[0]);
	}


	@Override
	public String[] rowsGood() {
		return lsRowsGood.toArray(new String[0]);
	}


	@Override
	public String[] autoProducers() {
		return setBrand.toArray(new String[0]);
	}


	@Override
	public String[] autoProducersDefined() {
		List<String> lsBrand=new ArrayList<String>();
		EnumCar[] arEnumCar = EnumCar.values();
		for (EnumCar enumCar : arEnumCar) {
			lsBrand.add(enumCar.name());
		}
		
		return lsBrand.toArray(new String[0]);
	}


	@Override
	public boolean existsProducer(String autoProducer) {

		EnumCar[] arEnumCar = EnumCar.values();
		for (EnumCar enumCar : arEnumCar) {
			if (enumCar.name().equals(autoProducer)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean existsModel(String autoProducer, String autoModel) {
		// TODO Auto-generated method stub
		EnumCar enumCar;
		try {
			enumCar = EnumCar.valueOf(EnumCar.class, autoProducer);
		} catch (Exception e) {
			return false;
		}
		for (String modelDefined : enumCar.getNameModels()) {
			if (autoModel.equalsIgnoreCase(modelDefined)) {
				return true;
			}
		}
	return false;
	}

}