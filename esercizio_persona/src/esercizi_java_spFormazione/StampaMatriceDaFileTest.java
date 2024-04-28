package esercizi_java_spFormazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StampaMatriceDaFileTest {
	
	StampaMatriceDaFile smf = new StampaMatriceDaFile();
	
	@Test
	void wrongFileNameTest() {
		assertTrue(smf.stampa("dsdsds", 3, 3).equals("INVALID-FILE-NAME"));
	}

	@Test
	void allCorrectTest() {
		assertTrue(smf.stampa("matrice.txt",3 , 3).equals("Matrice stampata"));
		}
	
	@Test
	void wrongNumRigheTest1() {
		assertTrue(smf.stampa("matrice.txt",2 , 3).equals("INVALID_DATA"));
		}

	@Test
	void wrongNumRigheTest2() {
		assertTrue(smf.stampa("matrice.txt",4 , 3).equals("INVALID_DATA"));
		}
	
	@Test
	void wrongNumColonneTest1() {
		assertTrue(smf.stampa("matrice.txt",3 , 2).equals("INVALID_DATA"));
		}

	@Test
	void wrongNumColonneTest2() {
		assertTrue(smf.stampa("matrice.txt",3 , 4).equals("INVALID_DATA"));
		}
	
	@Test
	void notIntTest() {
		assertTrue(smf.stampa("matriceTest.txt",3 , 3).equals("NOT-NUMERIC-VALUE"));
		}
	
	
}
