package sahanbcs.lockobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public  void main() {
		System.out.println("Starting.........");
		
		long st = System.currentTimeMillis();
		
	 Thread t1 =	 new Thread(new Runnable() {			
			@Override
			public void run() {
				process();				
			}
		});
	 
	 Thread t2 =	 new Thread(new Runnable() {			
			@Override
			public void run() {
				process();				
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
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("Ending....... The Time Take :" + (end - st));
		System.out.println("The List 1 :" + list1.size() + " | The List 2 :" + list2.size()  );
	}
	
	
	public  void stageOne() {		
		
		synchronized (list1) {		
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
		
				
	}
	
	public  void stageTwo() {
		synchronized (list2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));	
		}
	}
	
	public void process() {
		for (int i = 0; i < 100; i++) {
			stageOne();
			stageTwo();
		}		
	}
	
}
