package com.test;

public class Test5 {

	public static void main(String[] args) {
//		int[] nums = {1, 2, 1, 20, 21, 1, 2, 1, 2, 23, 24, 2, 1, 2, 1, 25};
//		  int m = 0, max = 0;
//		  for(int i = 0; i < nums.length; i++) {
//		    for(int j = i + 1; j < nums.length; j++) {
//		      while(true) {
//		        if((i + m) < nums.length && (j - m) >= 0 && nums[i + m] == nums[j - m]) {
//		          m++;
//		        }else {
//		          if(m > max) {
//		            max = m;
//		            System.out.println(max);
//		          }
//		          m = 0;
//		          break;
//		        }
//		      }
//		    }
//		  }
		String[] a = {"a", "a", "b", "b", "c"};
		String[] b = {"a", "b", "c"};
		  int x = 0, m = 1, n = 1;
		  String[] c = new String[99];
		  String[] d = new String[99];
		  c[0] = a[0];
		  d[0] = b[0];
		  for(int i = 1; i < a.length; i++) {
		    if(a[i] != c[m - 1]) {
		      c[m] = a[i];
		      m++;
		    }
		  }
		  for(int i = 0; i < m; i++) {
			  System.out.println(c[i]);
		  } 
		 // System.out.println(m);
		  for(int i = 1; i < b.length; i++) {
		    if(b[i] != d[n - 1]) {
		      d[n] = b[i];
		      n++;
		    }
		  }
		  System.out.println(n);
		  for(int i = 0; i < m; i++) {
		    for(int j = 0; j < n; j++) {
		      if(c[i] == d[j]) {
		        x++;
		        System.out.println(c[i] + "," + d[j]);
		      }
		    }
		  }
//		  for(String str : c) {
//			  System.out.print(str + ",");
//		  }
//		  for(String str : d) {
//			  System.out.print(str + ",");
//		  }
		  System.out.println(x);
		  
	}
}
