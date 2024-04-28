package esercizi_java_spFormazione;


public enum EnumAuto {
	STELLANTIS(10),
	CITROEN(8),
	PEUGEOT(6),
	TOYOTA(12),;

	int numModelli;
	
	EnumAuto(int numModelli) {
		this.numModelli=numModelli;
	}

	public int GetNumModelli() {
		return this.numModelli;
	}
	
}
