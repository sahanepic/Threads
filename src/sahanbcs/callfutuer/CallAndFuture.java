package sahanbcs.callfutuer;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAndFuture {
	
	
	
	
	 public static void main(String[] args) {
		 ExecutorService executor = Executors.newCachedThreadPool();
		 Future<Integer> future =  executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				
				Random rr =new Random();
				int duration = rr.nextInt(4000);
				
				if(duration > 2000) {
					throw new IOException("Time is Too Long");
				}
				System.out.println("Starting");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Finishing...");
				return duration;
			}
		});
		 
		
		 executor.shutdown();
		 
		 try {
			System.out.println("The Returned Value is " + future.get() );
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println( e.getMessage());
		}
		 
	}
	 
	
	
	
	

}
