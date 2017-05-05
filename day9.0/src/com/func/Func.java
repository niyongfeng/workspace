package com.func;

public class Func {
	
	private int x;

	public Func() {
		
	}
	
	public int func(int x) {
		
		this.x = x % 10 * 10000 + (x % 100 - x % 10 ) * 100 + (x % 1000 - x % 100) + (x % 10000 - x % 1000) / 100  + x / 10000; 
		return this.x;
	}
}
