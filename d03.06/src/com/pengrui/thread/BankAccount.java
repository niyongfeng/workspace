package com.pengrui.thread;

public class BankAccount {
	long balance = 10000;
	
	public void quqian() {
		System.out.println("取钱前的余额：" + balance);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(balance > 1000) {
			balance = balance - 1000;
			System.out.println("取钱后的余额：" + balance);
		}else {
			System.out.println("余额不足！");
		}
	}
	
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Thread husband = new Account(account);
		Thread wife = new Account(account);
		husband.start();
		wife.start();
	}
}

class Account extends Thread{
	BankAccount account;
	public Account(BankAccount account) {
		this.account = account;
	}
	public void run() {
		account.quqian();
	}
}

