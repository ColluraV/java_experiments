package threads;

/*
 * Thread A e B condividono lo stesso codice
 * Dopo il lancio si aspettano 2 secondi e poi  si stoppano i thread
 * con metodo obsoleto e deprecato
 */
public class ThreadEsempio3 {

	public static void main(String[] args) {
		P T1 = new P('A');
		P T2 = new P('B');
        T1.start();
        T2.start();
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		T1.stop();
		T2.stop();
		System.out.println("FINE");

	}

	static class P extends Thread{
		private char ch;		
		public P(char c) {ch = c;}		
		public void run() {
			while (true) {System.out.println(ch);}
		}
	}
}
