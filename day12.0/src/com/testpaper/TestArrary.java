package com.testpaper;

public class TestArrary {

	public static void main(String[] args) {
		
		int[] a = {20,10,50,40,30,70,60,80,90,100};
		
		int x = a.length;
		int t;
		for(int i = 0; i < x; i++) {
			for(int m = 0; m < x - 1; m++) {
				if(a[m] < a[m + 1]) {
					t = a[m];
					a[m] = a[m + 1];
					a[m + 1] = t;
				}
			}
		}
		
		for(int n = 0; n < x; n++) {
			System.out.print(a[n] + " ");
		}
	}
	
}
