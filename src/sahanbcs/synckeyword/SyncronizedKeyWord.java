package sahanbcs.synckeyword;




 


public class SyncronizedKeyWord {

	
	private volatile int  count = 0;
	
	public static void main(String[] args) {
		SyncronizedKeyWord sc = new SyncronizedKeyWord();
		sc.doWork();
	}
	
	
 	public synchronized  void  increment(){
		count++;
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			 
				for (int i = 0; i <  1000; i++) {
					increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			 
				for (int i = 0; i <  1000; i++) {
					increment();
				}
				
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
		
		
		System.out.println("The Count is :" + count );
		
	}
	
}
