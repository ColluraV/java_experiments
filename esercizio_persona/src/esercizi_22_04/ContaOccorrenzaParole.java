package esercizi_22_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class ContaOccorrenzaParole implements Parole{


	Map<String, Integer> occorrenze;

	Integer numOc;

	String paroleInput = new String();
	String maxParole = "";
	Integer wordMaxValue = 0;
	Scanner srcWords=null;
	String wordMax="";
	//List<Integer> wordMax = new ArrayList<>();

	
	
	
	ContaOccorrenzaParole() {
		occorrenze= new HashMap<String, Integer>();
	}
	ContaOccorrenzaParole(Integer maxParole){
		occorrenze= new HashMap<String, Integer>(maxParole*150/100);
	}

	ContaOccorrenzaParole(String paroleInput) {
		occorrenze=new HashMap<String, Integer>();
		loadMap(paroleInput);

	}
	ContaOccorrenzaParole (String ... parola){
		for (String word : parola) {
			addParola(word);
		}
	}
	
	@Override
	public void setInputString(String strInput) {
		
	    occorrenze.clear();
	    loadMap(strInput);

	}
	

	@Override
	public void addParola(String parola) {
		while (srcWords.hasNext()) {
			String word = (String) srcWords.next();
			numOc = occorrenze.get(word);
			if (numOc == null) {
				occorrenze.put(word, 1);
			} else {
				occorrenze.put(word, ++numOc);
			}
		}

	}

	@Override
	public boolean exists(String parola) {
		return occorrenze.containsKey(parola) ? true : false ;
	}

	@Override
	public boolean deleteParola(String parola) {
		return occorrenze.remove(parola)==null ? false : true;
	}

	@Override
	public int contaParole() {
		return occorrenze.size();
	}

	@Override
	public int occorrenzeParola(String parola) {
		return occorrenze.getOrDefault(parola, -1);
	}

	@Override
	public String[] paroleConMaxOccorrenze() {
		int maxOccurr=maxOccorrenzeNum();
	 	List<String> alMaxOccorrenze = new ArrayList<String>();
		
		for (Entry<String, Integer> keyValue : occorrenze.entrySet()) {
			if (keyValue.getValue()==maxOccurr) {
				alMaxOccorrenze.add(keyValue.getKey());
			}
		}
	return alMaxOccorrenze.toArray(new String[0]);
	}

	@Override
	public int maxOccorrenzeNum() {
		
		for (Entry<String, Integer> keyValue : occorrenze.entrySet()) {
			if (keyValue.getValue() > wordMaxValue) {
				wordMaxValue = keyValue.getValue();
				wordMax = keyValue.getKey();
			}
		}

		return wordMaxValue;
	}

	@Override
	public String[] toArrayParole() {
		return occorrenze.keySet().toArray(new String[0]);
	}

	
	private void loadMap(String paroleInput) {
		Scanner srcInput = new Scanner(paroleInput);
		
		while (srcInput.hasNext()) {
			addParola(srcInput.next());
		}
		srcInput.close();
		
	}

}

