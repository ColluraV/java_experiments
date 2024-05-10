package threads;

/*
 * Thread con stessa sottoclasse di Thread
 * Codice condiviso, thread A e B alternano il controllo
 */
public class ThreadEsempio2 {

	public static void main(String[] args) {
		P T1 = new P('A');
		P T2 = new P('B');
		T1.setPriority(1);
		T2.setPriority(10);
        T1.start();
        T2.start();
	}
 
	static class P extends Thread{
		private char ch;
		
		public P(char c) {
			ch = c;
		}
		
		public void run() {
			while (true) {System.out.println(ch);}
		}
	}
}
