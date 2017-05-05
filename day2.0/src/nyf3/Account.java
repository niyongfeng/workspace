package nyf3;

public class Account {
	
	private String id;
	private String name;
	private int balance = 0;
	
	
	public Account(String id,String name) {
		this.id =id;
		this.name = name;
	}
	
	public Account(String id,String name,int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	

	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int credit(int amount) {
		balance = amount + balance;
		return balance;
	}
	
	public int debit(int amount) {
		if(amount <= balance) {
			balance = balance - amount;
		}else {
			System.out.println("Amount execeeded balance");
		}
		return balance;
	}
	
	public int TransferTo(Account another,int amount) {
		if(amount <= balance) {
			balance = balance - amount;
			another.balance = amount + another.balance;
		}else {
			System.out.println("Amount execeeded balance");
		}
		return another.balance;
	}
	
	public String toString() {
		return "Account[id=" + id + ',' + "name=" + name + ',' + "balance=" + balance + ']';
	}

}
