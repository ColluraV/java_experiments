package esercizi_java_spFormazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class E0013_NextElementsTest {
     
	@Test
	void testArrayFalse() {
		int[] arFalse1 = {10, 10, 2, 4, 20, 20};
		int[] arFalse2 = {10, 10, 2, 4, 10, 10,  20, 20};
		int[] arFalse3 = {8, 10, 10, 2, 4, 10, 10,  20, 20};
		int[] arFalse4 = {83, 14, 20, 20, 2, 4, 10, 10,  20, 20};
		assertFalse(E0013_NextElements.isArrayCorrect(arFalse1));
		assertFalse(E0013_NextElements.isArrayCorrect(arFalse2));
		assertFalse(E0013_NextElements.isArrayCorrect(arFalse3));
		assertFalse(E0013_NextElements.isArrayCorrect(arFalse4));
	}

	@Test
	void testArrayTrue() {
		int[] arTrue1 = {10, 10, 2, 4};
		int[] arTrue2 = {20, 20, 2, 4};
		int[] arTrue3 = {2, 4, 8, 7, 10, 10};
		int[] arTrue4 = {2, 4, 10, 10, 4, 8};
		int[] arTrue5 = {2, 4, 20, 20, 4, 8};
 		assertTrue(E0013_NextElements.isArrayCorrect(arTrue1));
 		assertTrue(E0013_NextElements.isArrayCorrect(arTrue2));
		assertTrue(E0013_NextElements.isArrayCorrect(arTrue3));
		assertTrue(E0013_NextElements.isArrayCorrect(arTrue4));
		assertTrue(E0013_NextElements.isArrayCorrect(arTrue5));
	}

}
