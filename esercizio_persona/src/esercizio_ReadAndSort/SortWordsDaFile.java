package esercizio_ReadAndSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class SortWordsDaFile implements ReadDaFile {

	String fileName;
	File file;
	Scanner src;
	String word;
	Set<String> unorderedWords;
	EnumSortType enumSort;
	Set<String> orderedWords;
	List<String> listAllWords;

	
	SortWordsDaFile(String fileName){ 
		this.enumSort=EnumSortType.SORT_ASCENDING;
		//setFileName(fileName);
		fileReader(fileName);
	}
	
	SortWordsDaFile(String fileName, EnumSortType sortType){
		this.enumSort=sortType;
		//setFileName(fileName);
		fileReader(fileName);
	}
	
	
	
	
	@Override
	public void setFileName(String fileName) {
		unorderedWords.clear();
		fileReader(fileName);
		//this.fileName=fileName;	
	}

	@Override
	public void sort(EnumSortType sortType) {
		// TODO Auto-generated method stub
		if (sortType==EnumSortType.SORT_ASCENDING) {
			orderedWords= new TreeSet<String>(unorderedWords);
		}else {
			orderedWords=new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
//			orderedWords=new TreeSet<String>(Comparator.reverseOrder());
		}
		
	}

	@Override
	public void sort() {
	sort(this.enumSort);
	}

	@Override
	public boolean isWordPresent(String word) {
		return orderedWords.contains(word);
	}

	@Override
	public Collection<String> getListaParole(String word) {
		listAllWords=new ArrayList<String>();
		listAllWords.add(word);
		return listAllWords;
	}

	
	private void fileReader(String fileName) {
		unorderedWords= new HashSet<String>();
		
		file = new File(fileName);
		try {
			src = new Scanner(file);
			while (src.hasNext()) {
				word = src.next(); // add (String) here
				unorderedWords.add(word);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
