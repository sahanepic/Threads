package sahanbcs.lowlevelsyncronization;

import java.util.LinkedList;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final Integer LIMIT = 10 ;
	private Object lock = new Object();
	
	public void producer() throws InterruptedException {
		
		int value =0;
		
		while (true) {
			
			synchronized (lock) {
				
				
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);	
				lock.notify();
			}
			
		}
		
	}
	
	public void consumer() throws InterruptedException {
		
		while (true) {
			
			synchronized (lock) {
			
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is :" + list.size() );
				int value = list.remove();
				System.out.println(" The Value is : " + value);
				lock.notify();
			}
			Thread.sleep(1000);
			
		}
		
	}
	
}
