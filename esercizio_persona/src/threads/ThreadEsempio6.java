package threads;
/*
 * COMPLETARE evidenziare l'utilizzo dei soli metodi sincronizzati con Syncronized
 */
public class ThreadEsempio6 {
	
	public ThreadEsempio6() {
		P P1 = new P('A');
		P P2 = new P('B');
		Thread T1=new Thread(P1);
		Thread T2=new Thread(P2);
		T1.start();
		T2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		P1.ferma();
		P2.ferma();
		System.out.println("FINE");
	}

	public static void main(String[] args) {
		ThreadEsempio6 e6 = new ThreadEsempio6();
	}
	
	static class P implements Runnable{
		private int value = 0;
		boolean stop = false;
		public P(int c) {value = c;}		
		public void run() {
			while (true) {
				System.out.println(value);
				if (stop) {break;}
			}
		}
		public void ferma() {stop=true;};
	}
	
}
