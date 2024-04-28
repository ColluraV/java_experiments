package esercizi_car;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScanAutoEnumTest {
	static ScanAutoEnum scan;
	static List<String> line2;
	static EnumCar[] enumCars;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		scan = new ScanAutoEnum("elenco_auto.txt");
	}

	@Test
	void testRowsWrong() {
		assertTrue(true);
	}
//
//
//	@Test
//	void testRowsGood() {
//		fail();
//	}
//
//	@Test
//	void testAutoProducersOk() {
//		fail();
//	}
//	
//	@Test
//	void testAutoProducersDefined() {
//		fail();
//	}
//
//	@Test
//	void testExistsProducer() {
//		fail();
//	}
//	
//	
//	@Test
//	void testexistsModel() {
//		fail();
//	}
	
	}
