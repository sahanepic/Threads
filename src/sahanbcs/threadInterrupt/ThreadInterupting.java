package sahanbcs.threadInterrupt;

import java.util.Iterator;
import java.util.Random;

public class ThreadInterupting {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("Starting the Processs..");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random rr =new Random();
				
				// TODO Auto-generated method stub
				for (int i = 0; i <  1E6 ; i++) {
//					if(Thread.currentThread().isInterrupted()) {
//						System.out.println("Threed Interpted");
//						break;
//					}
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO: handle exception
						System.out.println("Interrupted ....");
						break;
					}
					
					Math.sin(rr.nextDouble());
				}
				
			}
		});
		
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
		
		t1.join();
		
		System.out.println("Ending the Processs..");
	}
}
