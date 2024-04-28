package esercizio_ReadAndSort;


import org.junit.jupiter.api.Test;


class SortWordsDaFileTest {
	static SortWordsDaFile swdf;

	
	@Test
	void SortWordsDaFile() {
		swdf = new SortWordsDaFile("text2.txt");
		String[] arProva= {"zaino", "sara","caciocavallo"};
		swdf.setFileName("fileReadAndSort.txt");
		swdf.sort(EnumSortType.SORT_DESCENDING);
	}
	
}
