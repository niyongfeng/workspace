package com.pengrui.account;

public class Account {
	
	private String id;
	private String name;
	private int balance = 0;
	
	public Account(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int credit(int amount) {
		balance = balance + amount;
		return balance;
	} 
	
	public int debit(int amount) {
		if(amount <= balance) {
			balance = balance - amount;
		}else {
			System.out.println("Amount exceeded balance");
		}
		return balance;
	}
	
	public int transferTo(Account another, int amount) {
		if(amount <= balance) {
			another.balance = another.balance + amount;
			balance = balance - amount;
			System.out.println("已转账给" + another.name + "：" + amount);
		}else {
			System.out.println("Amount exceeded balance");
		}
		return balance;
	}
	
	public String toString() {
		return "Account[ id = " + id + ", name = " + name + ", balance = " + balance + " ]";
	}
	
	public int hashCode() {
		String str = id + name + balance;
		return str.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Account)) return false;
		
		Account a = (Account) obj;
		return a.id == id && a.name == name && a.balance == balance;
	}
	
	public Object clone() {
		Account account = new Account(id, name, balance);
		return account;
	}

}
