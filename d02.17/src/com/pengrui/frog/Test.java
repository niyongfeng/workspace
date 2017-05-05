package com.pengrui.frog;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(frog(5));
	}

	static int frog(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			return frog(n - 1) + frog(n - 2);
		}
	}
}
