package com.pengrui.invoice;

public class Test {
	public static void main(String[] args) {
		Customer customer = new Customer(110708132, "niyongfeng", 80);
		Invoice invoice = new Invoice(1, customer, 1000);
		
		System.out.println(customer.toString());
		System.out.println("原价：" + invoice.getAmount() + "\n折扣：" + customer.getDiscount() + "%\n折后价：" + invoice.getAmountAfterDiscount());
	}
	
}
