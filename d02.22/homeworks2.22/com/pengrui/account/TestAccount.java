package com.pengrui.account;

public class TestAccount {

	public static void main(String[] args) {
		Account a1 = new Account("110", "nyf", 99999);
		Account a2 = new Account("120", "qyt", 10000);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println("增加1后余额为:" + a1.credit(1));
		System.out.println("取走1000后余额为:" + a1.debit(1000));
		System.out.println("nyf转账给qyt 1000");
		a1.transferTo(a2, 1000);
		System.out.println("转账后余额:\n" + a1 + "\n" + a2);
		
		Account a3 = new Account("110", "nyf", 99999);
		Account a4 = (Account)a3.clone();
		System.out.println("本体：" + a3.toString());
		System.out.println("克隆体：" + a4.toString());
		System.out.println("本体哈希码值：" + a3.hashCode());
		System.out.println("克隆体哈希码值：" + a4.hashCode());
		System.out.println(a3.equals(a4));
	}
}
