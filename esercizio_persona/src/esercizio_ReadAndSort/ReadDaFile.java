package esercizio_ReadAndSort;

import java.util.Collection;

public interface ReadDaFile {

	void setFileName(String fileName);
	
	 void sort(EnumSortType sortType);
	 
	 void sort();   /* Sorting according default sort type */
	 
	 boolean isWordPresent(String word); 
	 
	 String toString();

	 Collection<String> getListaParole(String word);
}
