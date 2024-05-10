package threads;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ThreadParallelFileCreate {
	public static String path= "C:\\Users\\Rubbit\\git\\repository\\esercizio_persona\\";
	public static void main(String[] args) throws InterruptedException {
		Create c1= new Create(1);
		Create c2= new Create(2);
		Create c3= new Create(3);
		
		//lancio il thread e con join impongo prima
		//la chiusura del thread
		c1.start();
		c1.join();
		
		c2.start();
		c2.join();
		
		c3.start();
        c3.join();
	}


	static class Create extends Thread{
		int value;
		
		
		public Create(int numero){
			this.value=numero;
		}
		
		public void run() {
			synchronized (path) {
				try {
					File file = new File(path+"thread_test"+this.value+".txt");
					file.createNewFile();
					DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
					for (int i = 0; i <= 1000; i++) {
						
						out.writeChars("/-/stringa numero"+i);
						System.out.println("thread numero "+ this.value+"concluso"+"/-/stringa numero"+i);
					}
					out.flush();
					out.close();
					
					System.out.println("thread numero "+ this.value+"concluso");
				} catch (IOException e) {
				}
				
			}
		}
	}
	
}
