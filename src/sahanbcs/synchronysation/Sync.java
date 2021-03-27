package sahanbcs.synchronysation;

import java.util.Scanner;

class Processer extends Thread{

	private volatile
	boolean running =true; 
	
	@Override
	public void run() {
	  
		while (running) {
			System.out.println("Hello sahan ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public  void shutDown() {
		this.running = false;
	}
	
}



public class Sync {
	
	public static void main(String[] args) {
		
		System.out.println("Press Button To Shutdown :");
		Scanner sc = new Scanner(System.in);
		Processer t1 = new Processer();
		t1.start();
		sc.nextLine();
		t1.shutDown();
		System.out.println("The End !!!!");
		
	}

}
