package enumeration_correct;

public class EnumerazioniSimple {
	public static void main(String[] args) {
		EnumerazioniSimple enumerazioni = new EnumerazioniSimple();
		enumerazioni.run(); 
	}
 
	private void run() {
		EnumLevelSimple e;
		System.out.println("Value:" + EnumLevelSimple.HIGH); 
		System.out.println("Ordinal: " + EnumLevelSimple.HIGH.ordinal());

		// Scan and print elements 
		for (EnumLevelSimple enumElement : EnumLevelSimple.values()) {
           System.out.println("Ordinal:"+enumElement.ordinal() + " Value:"+enumElement.toString());
		}
        
 		// Get enum from string
		e = EnumLevelSimple.valueOf(EnumLevelSimple.class, "MEDIUM");
		System.out.println("Enum object value obtained by string 'MEDIUM':"+e.toString());
	}
}
