package com.test4;

import java.util.Scanner;

public class Test21 {

	public static void main(String[] args) {
		int[] arr = new int[99];
		Scanner sc = new Scanner(System.in);
		System.out.println("请确定你要存储的数字个数：");
		int a = sc.nextInt();
		int b;
		System.out.println("请输入需要存储的数字：(输入一个完成后按回车继续下一个数字的输入)");
		for(int i = 0; i < a; i++) {
			b = sc.nextInt();
			arr[i] = b;
		}
		System.out.print("[ ");
		for(int m = 0;m < a - 1; m++) {
			System.out.print(arr[m] + ",");
		}
		System.out.println(arr[a - 1] + " ]");
		sc.close();
	}
}
