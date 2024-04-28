/**
 * 
 */
package esercizi_java_spFormazione;

import java.util.Arrays;

/**
 * @author giamp
 *
 */
public class E0013_NextElements {
	public static boolean isArrayCorrect(int[] arNumsInp) {
        
        // Initialize boolean variables to check for specific patterns
        boolean found1010 = false;
        boolean found2020 = false;
        
        // Iterate through the array to find patterns (e.g., 1010 and 2020)
        for (int i = 0; i < arNumsInp.length - 1; i++) {
            if (arNumsInp[i] == 10 && arNumsInp[i + 1] == 10) {
                found1010 = true;
            }

            if (arNumsInp[i] == 20 && arNumsInp[i + 1] == 20) {
                found2020 = true;
            }
        }
        
        return found1010 != found2020 ? true : false;
 	}
}
