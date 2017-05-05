package com.pengrui.test11;

public class Test {
	public static void main(String[] args) {
		Worker worker1 = new Worker("niyongfeng", 25, 8888);
		Manage.list.add(worker1);
		Worker worker2 = new Worker("nyf", 26, 6666);
		Manage.list.add(worker2);
		Manage.list.add(new Worker("张三", 24, 5555));
		
		Manage.print();
		System.out.println(worker1.equals(worker2));
		
		
	}
}
