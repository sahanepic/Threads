package sahanbcs.ttread;

 

class IMPRunn implements Runnable{

	@Override
	public void run() {
		
		try {
			
			for (int i = 0; i < 10; i++) {
				System.out.println("Hello sahan  " + i );
				Thread.sleep(1000);
			}
			
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}



public class ThreadInRunnabel {

	public static void main(String[] args) {
			Runnable r1 = new IMPRunn();
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r1);
			t1.start();
			t2.start();
	}
}
