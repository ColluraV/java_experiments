package esercizi_java_spFormazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class prova_collections {

	public prova_collections() {

				
	}

	public static void main(String[] args) {
		
		GeneraLista();
		GeneraMap();
		StampaLista(GeneraLista());

        }


	private static void StampaLista(ArrayList<String> generaLista) {
		// TODO Auto-generated method stub
		ArrayList<String> colors= new ArrayList<String>(generaLista);
        System.out.println(colors);
        colors.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(colors);
	}

	private static void GeneraMap() {

        
        Map<Integer, String> classifica = new HashMap<>();
        classifica.put(1, "Juventus");
        classifica.put(2, "Napoli");
        classifica.put(3, "Roma");
        classifica.put(4, "Inter");

        for (Integer key : classifica.keySet()) {
            System.out.println(classifica.get(key));}
		
	}

	private static ArrayList<String> GeneraLista() {
		// TODO Auto-generated method stub
		
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Rosso");
        colors.add("Verde");
        colors.add("Blu");

        return colors;
	}

	
	
}
