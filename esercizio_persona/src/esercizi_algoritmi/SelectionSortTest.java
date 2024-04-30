package esercizi_algoritmi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
	static SelectionSort sS;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		Integer[] arProva={5,4,3,2,1};
		Integer[] arAspettato={1,2,3,4,5};
		sS=new SelectionSort();
		
		assertArrayEquals(arAspettato, sS.orderBySelection(arProva));
	}

}
