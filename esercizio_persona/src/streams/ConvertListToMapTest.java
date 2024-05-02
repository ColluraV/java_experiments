package streams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConvertListToMapTest {

	static ConvertListToMap lTM;
	
	List<Book> listaProva= Arrays.asList(
			new Book("ISBN1", "Descrizione del primo libro", "Autore1", "Italia", 50),
			new Book("ISBN2", "Descrizione del secondo libro", "Autore2", "Francia", 60),
			new Book("ISBN3", "Descrizione del terzo libro", "Autore3", "Germania", 70));
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	lTM=new ConvertListToMap();
	}

	@Test
	void testTotalCost() {
		assertEquals(180, lTM.totalCost(listaProva));
	}
	
	@Test
	void testListOldStyle() {
		assertEquals(3,(lTM.listToMapOldStyle(listaProva).size()));
		assertEquals("Descrizione del secondo libro",(lTM.listToMapOldStyle(listaProva)).get("ISBN2"));
	}
	
	
}
