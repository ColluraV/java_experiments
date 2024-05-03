package streams;

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
		String[] expectedWords = {"CANE", "CAVALLO","MADRE", "MIA", "ROTONDA", "SARA", "TANGENZIALE", "TESLA"}; // esempio
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
	void testWordGreater() {
		fail("Not yet implemented");
	}

	@Test
	void testWordsWithLenghtLessThen() {
		fail("Not yet implemented");
	}

	@Test
	void testWordsJoined() {
		fail("Not yet implemented");
	}

}
