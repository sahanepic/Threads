package sahanbcs.deadlock;

public class DeadLockss {
	
	public static void main(String[] args) {
	
		Runner rr = new Runner();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rr.firstThread();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rr.secoundThread();
			}
		});
	
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		rr.finished();
		
		
	}
	
	

}
