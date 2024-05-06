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
		assertArrayEquals(actual, expected);
	}

	@Test
	void testAddWord() {
		String word="novi";
		String expected="CACIOCAVALLO-CANE-DROMEDARIO-ZAINO-ZAINO-ZAINO-CANE-CAVALLO-MADRE-MIA-ROTONDA-SARA-TANGENZIALE-TESLA-NOVI";
		//String actual=STF.addWord(word);
		//assertEquals(actual, expected);
	}

	@Test
	void testDeleteWord() {

	}

	@Test
	void testFirstWord() {
		String wordCheck=STF.firstWord();
		System.out.println(wordCheck);
		assertEquals(wordCheck, "CACIOCAVALLO");
	}

	@Test
	void testLastWord() {
	}

	@Test
	void testWordOccurrences() {
		
		
	}

	@Test
	void testFindWord() {
		boolean test=STF.findWord("ZAINO");
		assertTrue(test);
	}
	
	@Test
	void testFindWordFalse() {
		boolean falseTest=STF.findWord("PANINO");
		assertFalse(falseTest);
	}

}
