package esercizi_algoritmi;

public class SelectionSort {
	
	
    public static Integer[] orderBySelection(Integer[] vInput) {
        for (int i = 0; i < vInput.length - 1; i++) {
        	
            // Trova l'indice del minimo elemento
        	
            int minIndex = i;
            for (int j = i + 1; j < vInput.length; j++) {
                if (vInput[j] < vInput[minIndex]) {
                    minIndex = j;
                }
            }
            

            // Scambia l'elemento corrente con il minimo trovato
            
                if (minIndex != i) {
                int temp = vInput[i];
                vInput[i] = vInput[minIndex];
                vInput[minIndex] = temp;
            }
        }
        return vInput;
    }

    public static void main(String[] args) {
        Integer[] v = {24, 85, 78, 12, 25, 34, 15, 6, 5};
        Integer[] sortedV = orderBySelection(v);
        // Stampa l'array ordinato
        for (int i = 0; i < sortedV.length; i++) {
            System.out.print(sortedV[i] + " ");
        }
    }
}
