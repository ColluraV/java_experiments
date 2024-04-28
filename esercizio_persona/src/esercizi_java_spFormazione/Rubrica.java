package esercizi_java_spFormazione;

public interface Rubrica {
	boolean insert(SchedaPersona s);

	
	SchedaPersona[] search(String s);
	
	
	String ToString();
	
	
	boolean delete(SchedaPersona s);
	
}
