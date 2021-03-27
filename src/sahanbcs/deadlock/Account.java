package sahanbcs.deadlock;

public class Account {

	private int balance = 1000;
	
	
	
	public int  getBalance() {
		return balance;
	}
	
	
	public static void trancefer(Account a1 , Account a2 , Integer amount) {
		a1.withdraw(amount);
		a2.deposite(amount);
	}

	private void deposite(Integer amount) {
		// TODO Auto-generated method stub
		balance += amount;
	}
	
	public void withdraw(Integer amount) {
		balance -= amount;
	}
}
