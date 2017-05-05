package com.test;

public class Test2 {
	public static void main(String[] args) {
		String str = "This is notnot";
//		  int m = str.indexOf("xyz");
//		  int n = str.indexOf(".");
//		  if(m != n + 1 || (n < 0 && m >= 0)) {
//		    System.out.println(m + " " + n);
//		  }else {
//		    System.out.println(m + " , " + n);
//		  }
//		equalIsNot(str);
		
		

	} 
	
	static boolean equalIsNot(String str) {
		  int m = 0, n = 0;
		  for(int i = 0; i < str.length() - 1; i++) {
		    if(str.substring(i, i + 2).equals("is")) {
		      m++;
		    }
		  }
		  for(int i = 0; i < str.length() - 2; i++) {
		    if(str.substring(i,  i + 3).equals("not")) {
		      n++;
		    }
		  }
		  System.out.println(m + "," + n);
		  if(m == n) {
		    return true;
		  }else {
		    return false;
		  }
		}
}