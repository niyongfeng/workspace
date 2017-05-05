package com.pengrui.airthmetic;

public class Airthmetic {

	public static void main(String[] args) {

		int[] num = {1, 2, 3, 4, 5, 6};
		int[] num1 = {1, 2, 3, 4, 5, 6};
		int[] num2 = {1, 2, 3, 4, 5};
		int[] num3 = {1, 2, 3, 4, 5, 7};
		mergeArrays(num, num3);
		//deleteArrays(num, 3);
		//addArrays(num, 3, 9);
		equalsArrays(num, num1);
		equalsArrays(num, num2);
		equalsArrays(num, num3);
	}

	static void mergeArrays(int[] nums1, int[] nums2) {
		int[] num = new int[nums1.length + nums2.length];
		//num = nums1;
		for(int i = 0; i < nums1.length; i++) {
			num[i] = nums1[i];
		}
		int x = 0; 
		for(int i = nums1.length; i < num.length; i++) {
			num[i] = nums2[x];
			x++;
		}
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	static void deleteArrays(int[] nums, int x) {
		for (int i = x + 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}
		nums[nums.length - 1] = -1;
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	static void addArrays(int[] nums, int x, int y) {
		int[] nums1 = new int[nums.length + 1];
		int m = 0;
		for(int i = 0; i < nums.length + 1; i++) {
			if(i - 1 == x) {
				nums1[i] = y;
				i++;
			}
			nums1[i] = nums[m];
			m++;
		}
		for(int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}
	}
	
	static void equalsArrays(int[] nums1, int[] nums2) {
		int n = 0, m = 0;
		n = nums1.length;
		m = nums2.length;
		boolean dd = true;
		if(n == m) {
			for(int i = 0; i < nums1.length; i++) {
				if(nums1[i] != nums2[i]) {
					dd = false;
					break;
				}
			}
		}else {
			dd = false;
		}
		System.out.println(dd);
	}
}
