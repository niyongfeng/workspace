package com.func;

public class ToString {
	
	public static void main(String[] args) {
		
		String x = "*";
		String y = " ";
		int m = 2;
		for(int i = 1; i < 6; i++) {
			if(m >= 0 && m < 3) {
				for(int o = m; o > 0; o--) {
					System.out.print(y);
				}
				for(int n = 5 - 2 * m; n > 0; n--) {
					System.out.print(x);
				}
				m = m - 1;
				System.out.println("");
			}else{
				for(int o =0 - m; o > 0; o--) {
					System.out.print(y);
				}
				for(int n =2 * m + 5; n > 0; n--){
					System.out.print(x);
				}
				System.out.println("");
				m = m - 1;
			}
		}	
	}
}
