package com.test1;

public class Test1 {
	
	public static void main(String[] args) {
	
		//int[] a = new int[10];
		int[] b = {1,2,3,4,5};
		int[] c = new int[]{5,4,3,2,1};
		int t = 0;
	
		for(int i = 0; i < 5; i++) {
			if(c[i] > t) {
				t = c[i];
			}
		}
		System.out.println("最大值：" + t);
		
		for(int i = 0; i < 5; i++) {
			if(b[i] < t) {
				t = b[i];
			}
		}
		System.out.println("最小值：" + t);
	
	}
}
