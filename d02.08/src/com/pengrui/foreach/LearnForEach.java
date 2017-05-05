package com.pengrui.foreach;

public class LearnForEach {

	public static void main(String[] args) {
		//for each 用于数组，集合
		
		int[] number = {1,2,3,4,5,6,7,8,9};
		int[][] number1 = {{1,2,3}, {4,5,6}};
		System.out.println("输出：");
		for(int num : number) {
			System.out.println(num);
		}
		
		for(int[] nums : number1) {
			for(int num : nums) {
				System.out.print(num);
			}
			System.out.println(" ");
		}
	}
}
