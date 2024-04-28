package enumeration_correct;

public enum EnumLevelComplex {
	  LOW(11, "low-value")
	, MEDIUM(34, "medium-value")
	, HIGH("high-value");

	// Instance variables
	int counter;
	String altText;

	// Constructors
	EnumLevelComplex(int counter, String altText) {  
		this.counter = counter;
		this.altText = altText;  
	} 

	EnumLevelComplex(String altText) {
		this.counter = 50;
		this.altText = altText;
	}

	public int getCounter() {
		return this.counter;
	}

	public String getAlText() {
		return this.altText;
	}
}
