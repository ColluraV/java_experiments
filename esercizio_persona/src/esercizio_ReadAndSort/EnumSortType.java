package esercizio_ReadAndSort;

public enum EnumSortType {
	SORT_ASCENDING("(o1, o2) -> o2.compareTo(o1)"),
    SORT_DESCENDING("(o1, o2) -> o1.compareTo(o2)");

	String constructor;
	
	EnumSortType(String string) {
	   this.constructor=string;	    
	}
	
	String getConstructor() {
		return this.constructor;
	}
	
}
