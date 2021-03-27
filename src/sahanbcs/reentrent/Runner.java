package sahanbcs.reentrent;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	 
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void increment() {
		for (int i = 0; i <  1000; i++) {
			count++;
		}
	}
	

	public void threadOneRunnig() throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		
		System.out.println("WAiting .......");
		
		condition.await();
		
		System.out.println("The Woken Up");
		
		try {
			increment();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
		
		
	}

	public void threadTwoRunnig() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		
		lock.lock();
		System.out.println("Press Enter To here :");
		new Scanner(System.in).nextLine();
		System.out.println("Key is Pressed ");
		
		condition.signal();
		try {
			increment();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
		
	}

	
	 
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("The Count value is :" + count );
	} 
	
	

}
