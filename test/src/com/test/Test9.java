package com.test;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		System.out.print(splitArray(nums));
	}

	static boolean splitArray(int[] nums) {
		return arrSum(0, nums, 0);
	}

	static boolean arrSum(int index, int[] num, int sum) {
		  if(index >= num.length) {
			  int temp = 0;
			  for (int arr : num) {
					temp = arr + temp;
			  }
			  return 2 * sum == temp;
		  }
		  if(arrSum(index + 1, num, sum + num[index])) {
			  return true;
		  }
		  if(arrSum(index + 1, num, sum)) {
			  return true;
		   }
		  return false;
		}
}
