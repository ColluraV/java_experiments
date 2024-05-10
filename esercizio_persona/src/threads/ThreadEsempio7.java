package threads;

/*
 * Produttore/consumatore
 */
public class ThreadEsempio7 {
	public static void main(String[] args) {
		OggettoCondviso c = new OggettoCondviso();
		Producer p1 = new Producer(c, 1);    
		Consumer c1 = new Consumer(c, 2);
		p1.setName("Thread Producer");
		c1.setName("Thread Receiver");
		p1.start(); 
		c1.start();
	}
}

class OggettoCondviso {
	volatile int contents;
	volatile boolean available = false;
	
    synchronized int get() {
		while (available == false) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contents;
	}
	
	synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			}
			catch (InterruptedException e) { 
			} 
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

/*
 * Consumatore
 */
class Consumer extends Thread {
	private OggettoCondviso oggettoCondiviso;
	private int number;
	public Consumer(OggettoCondviso c, int number) {
		oggettoCondiviso = c;
		this.number = number;
	}
	public void run() {
		int value = 0;
		for (int i = 0; i < 50; i++) {
			value = oggettoCondiviso.get();
			System.out.println(Thread.currentThread().getName() + " Numero " + this.number+ " get: " + value);
		}
	}
}

/*
 * Produttore
 */
class Producer extends Thread {
	private OggettoCondviso oggettoCondiviso;
	private int number;

	public Producer(OggettoCondviso c, int number) {
		oggettoCondiviso = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			oggettoCondiviso.put(i);
			System.out.println(Thread.currentThread().getName() + " Numero " + this.number + " put: " + i);
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) { }
		}

	}
}
