package esercizi_java_spFormazione;

public class RubricaTelefonica implements Rubrica {

	SchedaPersona[] arSchedaPersona;
	int dimMax;
	
	public RubricaTelefonica(int dimMax) {
		
		arSchedaPersona = new SchedaPersona[dimMax];
		
	}
	
	
	@Override
	public boolean insert(SchedaPersona s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arSchedaPersona.length; i++) {
			if (arSchedaPersona[i] == null) {
				arSchedaPersona[i]= s;
			
				return true;
			}
			if (arSchedaPersona[i].equals(s)) {
				break;
			}
			
		}
		return false;
	}

	@Override
	public SchedaPersona[] search(String s) {
		// TODO Auto-generated method stub
		SchedaPersona[i] arSearch=null;
		int nSchede = 0;
		int j = 0;
		
		
		for (int i = 0; i < arSchedaPersona.length; i++) {
			if (!arSchedaPersona[i].contains(str)) {
				continue;
			}
			nSchede++;
		}
		return arSearch;
	}

	@Override
	public String ToString() {
		// TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
       /* for (int i = 0; i < arSchedaPersona; i++) {
            sb.append(arSchedaPersona[i].toString()).append("\n");
        }*/
        return sb.toString();
	}

	@Override
	public boolean delete(SchedaPersona s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arSchedaPersona.length; i++) {
			if (arSchedaPersona[i] == null) {
				break;
			}
			if (!arSchedaPersona[i].equals(s)) {
				continue;
			}
			arSchedaPersona=null;
		}
		
		//compattazione array
		for (int j = 0; j < arSchedaPersona.length; j++) {
			if (arSchedaPersona)
		}
		
		return false;
	}

}
