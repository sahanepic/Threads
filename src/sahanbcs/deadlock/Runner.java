package sahanbcs.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	
	private Account  a1= new Account();
	private Account  a2= new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	
	private void acquireLocks(Lock lock1, Lock lock2) {
		
		boolean firstLock = false;
		boolean secoundlock = false;
			
			while (true) {
				try {
					firstLock = lock1.tryLock();
					secoundlock = lock2.tryLock();
				} finally {
					// TODO: handle finally clause
					if(firstLock &secoundlock) {
						return;
					}else if (secoundlock) {
						lock2.unlock();
					}else if (firstLock) {
						lock1.unlock();
					}
					
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
						
	}

	
	
	public void firstThread() {
		
		Random r = new Random();
		
		for (int i = 0; i <  1000; i++) {
			
			
		//	lock1.lock();
		//	lock2.lock();
			
			acquireLocks(lock1,lock2);
			
			try {
				Account.trancefer(a1, a2, r.nextInt(100) );
			} finally {
				// TODO: handle finally clause
				lock1.unlock();
				lock2.unlock();
			}	
			
		}
	}

 






	public void secoundThread() {
		Random r = new Random();
		 
		
		
		for (int i = 0; i <  1000; i++) {
			acquireLocks(lock1,lock2);
			
		//  REASON FOT THE DEAD LOCK	
		//	lock2.lock();
		//	lock1.lock();
			try {
				Account.trancefer(a2, a1, r.nextInt(100) );
			} finally {
				// TODO: handle finally clause
				lock1.unlock();
				lock2.unlock();
			}
			
		}
	}
	
	public void finished() {

		System.out.println("Account  1 Balance : " +a1.getBalance()  );
		System.out.println("Account  2 Balance : " +a2.getBalance()  );
		System.out.println("Account Totla Balance : "  + (a2.getBalance() + a1.getBalance())  );
		
	}

}
