package com.test;

public class Test8 {

	int sum1 = 0, sum2 = 0, x = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,3,2,1};
		Test8 test = new Test8();
		
		//test.splitArray(nums);
		System.out.println(test.splitArray(0,nums,0));
	}

//	public boolean splitArray(int[] nums) {
//	  if(x >= nums.length) {
//	    return sum1 == sum2;
//	  }
//	  if(sum1 > sum2) {
//	    sum2 = sum2 + nums[x];
//	    x++;
//	    splitArray(nums);
//	  }else {
//	    sum1 = sum1 + nums[x];
//	    x++;
//	    splitArray(nums);
//	  }
//	  return false;
//	}
	
	public boolean splitArray(int index, int[] nums, int max) {
		  if(index >= nums.length) {
		    return max == 0;
		  }
		  if(splitArray(index + 1, nums, max + nums[index])) return true;
		  if(splitArray(index + 1, nums, max - nums[index])) return false;
		  return false;
		}

}
