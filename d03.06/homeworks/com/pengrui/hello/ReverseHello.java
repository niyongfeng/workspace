package com.pengrui.hello;

public class ReverseHello {
	public static void main(String[] args) {
		Print t = new Print();
		t.recursion(1);
	}
	

}

class Print extends Thread {

	public void run() {
		System.out.println("Hello from Thread" + Thread.currentThread().getName());
	}
	
	public void recursion(int n) {
		if(n != 51) {
			Thread p = new Print();
			p.setName(n + "");
			recursion(n + 1);
			p.start();
		}
		
	}
}
