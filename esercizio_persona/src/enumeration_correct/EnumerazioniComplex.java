package enumeration_correct;

public class EnumerazioniComplex {
	public static void main(String[] args) {
		EnumerazioniComplex enumerazioni = new EnumerazioniComplex();
		enumerazioni.run(); 
	}
 
	private void run() { 
		EnumLevelComplex e;
		System.out.println("Value:" + EnumLevelComplex.HIGH);
		System.out.println("Ordinal: " + EnumLevelComplex.HIGH.ordinal());

		// Scan and print elements 
		for (EnumLevelComplex enumElement : EnumLevelComplex.values()) {
           System.out.println("Ordinal:"+enumElement.ordinal() + " Value:"+enumElement.toString());
		}
        
		// Get enum from string
		e = EnumLevelComplex.valueOf(EnumLevelComplex.class, "MEDIUM");
		System.out.println("Enum object value obtained by string 'MEDIUM':"+e.toString());
		
		// Get info from specific enum value
		System.out.println("Counter for MEDIUM:"+e.getCounter());
		System.out.println("Alternative text for MEDIUM:"+e.getAlText());
		
	}
}
