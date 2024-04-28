package esercizi_java_spFormazione;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScanFileNamesTest {
	static ScanFileNames sc;
	String s ="1988-08-29 956 system.zip";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sc = new ScanFileNames();
	}

	@Test
	void testOk1() {
		assertEquals("0" ,sc.solution("1988-08-29 956 system.zip"));

	}
	
	@Test
	void testNotOk1() {
		assertEquals("INPUT INVALID" ,sc.solution("1988-08-29"));

	}
	

	@Test
	void testNotOk2() {
		assertEquals("INPUT INVALID" ,sc.solution("1988-08-29 gadfe"));

	}

	@Test
	void testNotOk3() {
		assertEquals("INVALID NAME" ,sc.solution("1988-08-29 12345"));

	}
	
	@Test
	void testDataNotOk1() {
		assertEquals("DATA TROPPO RECENTE" ,sc.solution("1999-08-29 12345"));

	}

	
	@Test
	void testDataOk1() {
		assertEquals("0" ,sc.solution("1994-08-29 12345 gyjr.zip"));

	}


}
