package com.pengrui.queue;

public class Test {
	
	public static void main(String[] args) {
		MyQueue m = new MyQueue();
		String s = "abcdefghijklmn";
		for(int i = 0; i < 10; i++) {
			m.add(s.charAt(i) + "");
		}
		
	}

}
