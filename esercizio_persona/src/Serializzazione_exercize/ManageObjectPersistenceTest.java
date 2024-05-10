package Serializzazione_exercize;

import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ManageObjectPersistenceTest {
	static ManageObjectPersistence mop = new ManageObjectPersistence("animals.dat");
	static Animale cane= new Animale("cane", "abbaia",4);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	void testManageObjectPersistence() {
//		fail("Not yet implemented");
//	}


	@Test
	void testPersistObject() {
		mop.persistObject(cane);
	}

	@Test
	void testGetObject() throws ClassNotFoundException {
		System.out.println(mop.getObject());
		System.err.println(Optional.of(cane));
		mop.getObject().isPresent();
	}

}
