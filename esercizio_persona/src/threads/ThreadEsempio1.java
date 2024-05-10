package threads;

/*
 * Thread A non cede il controllo
 */
public class ThreadEsempio1 {

	public static void main(String[] args) {
//		Thread.currentThread().setName("Main");
		System.out.println(Thread.currentThread().getName());
		A T1 = new A();
		B T2 = new B();
        T1.start();
        T2.start();
        System.out.println("T1 e T2 arrivati");
	}

	static class A extends Thread{
		public void run() {
			while (true) {System.out.println("A");}
		}

	}
	static class B extends Thread{
		public void run() {
			for (int i = 0; i < 1000000; i++) {System.out.println("B");}
		}

	}
}
