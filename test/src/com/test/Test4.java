package com.test;

public class Test4 {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 1};
//		int[] num = new int[nums.length];
//		  for(int i = 0; i < nums.length; i++) {
//		    if(nums[i] == 4) {
//		      num[i] = 4;
//		      nums[i] = - 1;
//		      for(int j = 0; j < nums.length; j++) {
//		        if(nums[j] == 5) {
//		          nums[j] = nums[i + 1];
//		          num[i + 1] = 5;
//		          nums[i + 1] = -1;
//		          break;
//		        }
//		      }
//		    }
//		  }
//		  for(int nums1 : nums) {
//			  System.out.print(nums1 + " ");
//		  }
//		  System.out.println(" ");
//		  for(int nums1 : num) {
//			  System.out.print(nums1 + " ");
//		  }
//		  for(int i = 0; i < nums.length; i++) {
//		    if(nums[i] != -1) {
//		      num[i] = nums[i];
//		    }
//		  }
		
		int x = 0, y = 0;
		  for(int i = 0; i < nums.length; i++) {
		    for(int m = 0; m <= i; m++) {
		      x = x + nums[m];
		      //System.out.println(x);
		    }
		    for(int n = i + 1; n < nums.length; n++) {
		      y = y + nums[n];
		      //System.out.println(y);
		    }
		    if(x == y) {
		      break;
		    }else {
		    	x = 0;
		    	y = 0;
		    }
		  }
		  //System.out.println(x + "," + y);
		  byte k = (byte)130;
		  System.out.println(k);
	}
}
