package streams;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StatsFileWordsTest {
	
	static StatsFileWords sFW;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sFW=new StatsFileWords();
	}

	@Test
	void testCountAll() throws IOException {
		sFW.fileReader("text2.txt");
		assertEquals(8, sFW.countAll());
	}

	@Test
	void testWords() throws IOException {
		sFW.fileReader("text2.txt");
		String[] expectedWords = {"CANE", "CAVALLO","MADRE", "MIA", "ROTONDA", "SARA", "TANGENZIALE", "TESLA"}; 
        String[] actualWords=sFW.words();
        assertArrayEquals(expectedWords, actualWords);
    }
	

	@Test
	void testCount() throws IOException {
		sFW.fileReader("fileReadAndSort.txt");
		long counter= sFW.count("ZAINO");
		assertEquals(3, counter);
	}

	@Test
	void testWordGreater() throws IOException {
		sFW.fileReader("fileReadAndSort.txt");
		String actual="ZAINO";
		String expected=sFW.wordGreater();
		assertEquals(actual, expected);
	}

	@Test
	void testWordsWithLenghtLessThen() throws IOException {
		sFW.fileReader("text2.txt");
		String [] actual={"CANE", "MIA", "SARA"}; 
		String [] expected =sFW.wordsWithLenghtLessThen(5);
		assertArrayEquals(actual, expected);
	}

	@Test
	void testWordsJoined() throws IOException {
		sFW.fileReader("fileReadAndSort.txt");
		String actual ="CACIOCAVALLOCANEDROMEDARIOZAINOZAINOZAINO";   
		String expected=sFW.wordsJoined();
		assertEquals(actual,expected);
		 
	}

}
