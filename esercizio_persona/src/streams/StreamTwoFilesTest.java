package streams;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StreamTwoFilesTest {
	static StreamTwoFiles STF;

	 StreamTwoFilesTest() throws IOException {
		 STF= new StreamTwoFiles("fileReadAndSort.txt","text2.txt");
	}
	

	@Test
	void testCountWords() {
		long testContatore= STF.countWords();
		assertEquals(testContatore,14);
	}

	@Test
	void testWords() {
		String[] test= STF.words();
		String[] actual= {"CACIOCAVALLO", "CANE","DROMEDARIO", 
							"ZAINO", "ZAINO", "ZAINO", "CANE", "CAVALLO", 
							"MADRE","MIA", "ROTONDA", "SARA", "TANGENZIALE", "TESLA"};
		assertArrayEquals( test,actual);
	}

	@Test
	void testWordsAsString() {
		String actual=STF.wordsAsString("/");
		String expected="CACIOCAVALLO/CANE/DROMEDARIO/ZAINO/ZAINO/ZAINO/CANE/CAVALLO/MADRE/MIA/ROTONDA/SARA/TANGENZIALE/TESLA";
		assertEquals(actual, expected);
	}

	@Test
	void testWordsNoDuplicates() {
		String[] actual=STF.wordsNoDuplicates();
		String[] expected= {"CACIOCAVALLO", "CANE", "DROMEDARIO",
							"ZAINO", "CAVALLO", "MADRE", "MIA", "ROTONDA",
							"SARA", "TANGENZIALE", "TESLA"};
		
		assertArrayEquals(actual, expected);;
	}

	@Test
	void testWordsOfLength() {
		String[] actual=STF.wordsOfLength(5);
		String[] expected= {"ZAINO", "ZAINO", "ZAINO", "MADRE", "TESLA"};
		
	}

	@Test
	void testAddWord() {
		String word="novi";
		String expected="CACIOCAVALLO-CANE-DROMEDARIO-ZAINO-ZAINO-ZAINO-CANE-CAVALLO-MADRE-MIA-ROTONDA-SARA-TANGENZIALE-TESLA-NOVI";
		//String actual=STF.addWord(word);
		//assertEquals(actual, expected);
		System.out.println(STF.addWord(word));
	}

	@Test
	void testDeleteWord() {
		fail("Not yet implemented");
	}

	@Test
	void testFirstWord() {
		fail("Not yet implemented");
	}

	@Test
	void testLastWord() {
		fail("Not yet implemented");
	}

	@Test
	void testWordOccurrences() {
		fail("Not yet implemented");
	}

	@Test
	void testFindWord() {
		fail("Not yet implemented");
	}

}
