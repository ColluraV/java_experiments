package threads;

/*
 *  Si attiva Thread1
 *  Si aspetta che finisca thread1
 *  Si attiva Thread2
 *  Si aspetta che finisca thread2 
 *  Si attiva Thread3
 *    
 */
public class ThreadEsempio5 {

	public static void main(String[] args) {
		// creating two threads
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		ThreadJoining t3 = new ThreadJoining();
		
		t1.setName("ThreadT1");
		t2.setName("ThreadT2");
		t3.setName("ThreadT3");

		// thread t1 starts
		t1.start();

		// starts second thread after when
		// first thread t1 has died.
		try
		{
			System.out.println("Current Thread: "
					+ Thread.currentThread().getName());
			t1.join();
		}

		catch(Exception ex)
		{
			System.out.println("Exception has " +
					"been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 has died.
		try
		{
			System.out.println("Current Thread: "
					+ Thread.currentThread().getName());
			t2.join();
		}

		catch(Exception ex)
		{
			System.out.println("Exception has been" +
					" caught" + ex);
		}
 
		t3.start();
		
		System.err.println("FINE ATTIVAZIONE THREAD");
	}	

}

class ThreadJoining  extends Thread{
	@Override
	public void run()
	{
		for (int i = 0; i < 2; i++)
		{
			try
			{
				Thread.sleep(5000);
				System.out.println("Current Thread: "
						+ Thread.currentThread().getName());
			}

			catch(Exception ex)
			{
				System.out.println("Exception has" +
						" been caught" + ex);
			}
			System.out.println(i);
		}
	}
}

