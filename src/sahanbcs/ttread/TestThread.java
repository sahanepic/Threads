package sahanbcs.ttread;

 

class Runner extends Thread{
		
		public void run() {
			 try {
				
				 for (int i = 0; i < 10; i++) {
					System.out.println("Hello  I am  "+ i );
					Thread.sleep(1000);
				}
				 
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	
}


public class TestThread {
	
	public static void main(String[] args) {
		Thread tt = new Runner();
		tt.start();
		Thread t2 = new Runner();
		t2.start();
	}
	
}
