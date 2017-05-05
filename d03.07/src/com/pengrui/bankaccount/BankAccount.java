package com.pengrui.bankaccount;

public class BankAccount {
	long balance = 10000;
	//添加synchronized关键词，使之为线程安全
	//public synchronized void quqian(String n) {
	//Daemon Thread 守护线程/精灵线程
	//守护线程在其他非守护线程都执行完成后自己马上停止
	//setDeamon(true);
	public void quqian(String n) {
		System.out.println("取钱前的余额：" + balance);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			if(balance > 1000) {
				balance = balance - 1000;
				System.out.println(n + "取钱后的余额：" + balance);
			}else {
				System.out.println("余额不足！");
			}
		}
		
	}
	
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Thread husband = new Account(account, "husband");
		Thread wife = new Account(account, "wife");
		wife.start();
		husband.start();
		System.out.println(wife.getId());
		System.out.println(husband.getId());
	}
}

class Account extends Thread{
	BankAccount account;
	String n;
	public Account(BankAccount account, String n) {
		this.account = account;
		this.n= n;
	}
	public void run() {
		account.quqian(n);
	}
}


