package com.pengrui.array2dtest;

public class ArrayTestTwo {
	
	public static void main(String[] args) {
		// 一维数组
		int[] numbers1 = new int[100];
		int x = 0;
		for(int i = 0; i < 100; i++) {
			numbers1[i] = (int)(Math.random() * 10 + 1);
			System.out.println(numbers1[i]);
		}
		for(int i = 0; i < 100; i++) {
			if(numbers1[i] == 8) {
				x++;
			}
		}
		System.out.println("8在数组中出现的个数为：" + x);
		System.out.println(" ");
		
		//二维数组
		int y = 0;
		int[][] numbers2 = new int[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j< 10; j++) {
				numbers2[i][j] = (int)(Math.random() * 10 + 1);
				System.out.print(numbers2[i][j] + "  ");
			}
			System.out.println(" ");
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(numbers2[i][j] == 8) {
					y++;
				}
			}
		}
		System.out.println("8在数组中出现的个数为：" + y);
		
		
	}

}
