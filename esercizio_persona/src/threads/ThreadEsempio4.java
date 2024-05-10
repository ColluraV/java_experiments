package threads;
/*
 * Thread A e B condividono lo stesso codice e la stessa variabile di memoria
 * Dopo il lancio si aspettano 2 secondi e poi  si stoppano i thread
 * con metodo di stop
 * Thread implementato con Runnable
 */
public class ThreadEsempio4 {
	public static void main(String[] args) {
		P P1 = new P('A');
		P P2 = new P('B');
		Thread T1=new Thread(P1);
		Thread T2=new Thread(P2);
		T1.start();
		T2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		P1.ferma();
		P2.ferma();
		System.out.println("FINE");
	}
	static class P implements Runnable{
		private char ch;
		boolean stop = false;
		public P(char c) {ch = c;}		
		public void run() {
			while (true) {
				System.out.println(ch);
				if (stop) {break;}
			}
		}
		public void ferma() {stop=true;};
	}
}
