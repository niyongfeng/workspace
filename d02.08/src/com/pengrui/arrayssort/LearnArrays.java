package com.pengrui.arrayssort;

import java.util.Arrays;

public class LearnArrays {
	
	public static void main(String[] args) {
		//利用Arrays.sort()对数组进行排序
		//数字从小到大排，字符串从字母A到B的顺序排
		
		int[] numbers = {1, 5, 2, 8, 6, 3};
		String[] names = {"tom", "mic", "bat", "ben", "AAa", "aaa"};
		Arrays.sort(numbers);
		Arrays.sort(names);
		int[] num1 = new int[8];
		num1 = numbers;
		for(int num : num1) {
			System.out.println(num);
		}
		
		for(String name : names) {
			System.out.println(name);
		}
		
		
	}

}
