package sahanbcs.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
	
	private static Connection instance = new Connection();
	private int connections = 0;
	private Semaphore sem = new Semaphore(10);
	
	private Connection() {
		
	}

	public static Connection getConnection() {
		return instance;
	}
	
	
	public void connect   () throws InterruptedException {
		
		sem.acquire();
		
		try {
			doconnect();
		} finally {
			// TODO: handle finally clause
			sem.release();
		}
		
		
		
	}
	
	
	public void doconnect()  {
		
		
		synchronized (this) {
			connections++;
			System.out.println("The Current Connections :" + connections );
		}
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
			System.out.println("EE The Current Connections :" + connections );
		}
		
	}
	
}
