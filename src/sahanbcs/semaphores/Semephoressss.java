package sahanbcs.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semephoressss {

	
	public static void main(String[] args) throws InterruptedException {
		
//		Semaphore sem = new Semaphore(7);
//		sem.acquire();
//		System.out.println( "The Sem Available Permits  : " + sem.availablePermits() );
//		sem.release();		
//		System.out.println( "The Sem Available Permits  : " + sem.availablePermits() );
		
		
		
		
		
		ExecutorService execute = Executors.newCachedThreadPool();
		
		
		for (int i = 0; i <  200; i++) {
			execute.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Connection.getConnection().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		
		execute.shutdown();
		execute.awaitTermination(1, TimeUnit.DAYS);
	}
	
}
