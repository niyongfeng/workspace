package com.pengrui.account;

public class TestAccount {

	public static void main(String[] args) {
		Customer c = new Customer(110708132, "niyongfeng", 'm');
		Account a = new Account(110, c, 10000);
		
		System.out.println(a.toString());
		System.out.println(c.getGender());
		System.out.println(a.deposit(10000));
		System.out.println(a.withdraw(30000));
		System.out.println(a.withdraw(5000));
	}
}
