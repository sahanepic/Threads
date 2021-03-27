package sahanbcs.waitnotify;

import java.util.Scanner;

public class Processor {

	public void producer() throws InterruptedException {
		
		synchronized (this) {
			System.out.println("Producer Running the Therad");
			wait();
			
			System.out.println("Resumed ...");
			
		}
		
	}
	
	public void consumer() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("WAit for the return key...");
			sc.nextLine();
			System.out.println("Return Key Pressed...");
			notify();
		}
		
		
		
	}
	
}
