package com.pengrui.sale;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TicketDispenser {
	
	Set<Integer> ticket = new TreeSet<Integer>();
	
	public TicketDispenser() {
		for(int i = 1; i <= 100; i++) {
			ticket.add(i);
		}
	}
	
	public synchronized void buy() {
		Iterator<Integer> it = ticket.iterator();
		if(it.hasNext()) {
			int x = it.next();
			System.out.println(Thread.currentThread().getName() + "出售票" + x);
			if(x == 100) {
				System.out.println(Thread.currentThread().getName() + "票已售完！");
			}
			ticket.remove(x);
		}
		else {
			System.out.println(Thread.currentThread().getName() + "票已售完！");
		}
	}
	
	public synchronized void returnTicket() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("欢迎进入退票系统！");
			System.out.println("请输入你要退的票号：");
			int x = sc.nextInt();
			if(ticket.contains(x)) {
				System.out.println("您的票有问题！");
			}else {
				ticket.add(x);
				System.out.println("退票成功！");
			}
			System.out.println("操作选择：(y:继续/n:退出)");
			String y = sc.next();
			if(y.equals("n")) {
				break;
			}
			
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		TicketDispenser t = new TicketDispenser();
		Thread sale1 = new Sale(t);
		Thread sale2 = new Sale(t);
		Thread sale3 = new Sale(t);
		Thread sale4 = new Sale(t);
		sale1.start();
		sale1.setName("一号窗口");
		sale2.start();
		sale2.setName("二号窗口");
		sale3.start();
		sale3.setName("三号窗口");
		sale4.start();
		sale4.setName("四号窗口");
		//t.returnTicket();
	}
	
}

class Sale extends Thread{
	TicketDispenser t;
	public Sale(TicketDispenser t) {
		this.t= t;
	}
	
	public void run() {
		while(true) {
			t.buy();
			Iterator<Integer> it = t.ticket.iterator();
			if(!it.hasNext()) {
				break;
			}
		}
	}
}