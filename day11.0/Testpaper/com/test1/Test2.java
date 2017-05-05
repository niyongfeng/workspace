package com.test1;

public class Test2 {
	public static void main(String[] args) {
		//方法一：定义一个空的中间数组
		int[] a = {1,2,3,4,5};
		int[] b = new int[99];
		
		for(int i = 0; i < a.length; i++) {
			b[i] = a[a.length - i - 1];
		}
		for(int x = 0; x < a.length; x++) {
			a[x] = b[x];
		}
		for(int y = 0; y < a.length; y++) {
			System.out.println(a[y]);
		}
		
		
		//方法二：定义一个中间变量进行交换 
		int[] c = {5,4,3,2,1};
		int t;
		for(int m = 0; m < c.length / 2; m++) {
			t = c[m];
			c[m] = c[c.length - 1 - m];
			c[c.length - 1 - m] = t;
		}
		for(int n = 0; n < c.length; n++) {
			System.out.println(c[n]);
		}
		
	}

}
