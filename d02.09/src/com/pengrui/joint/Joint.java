package com.pengrui.joint;

import java.util.Scanner;

public class Joint {

	public static void main(String[] args) {
		
		System.out.println("转换格式系统！");
		System.out.println("请输入数组个数:");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] arr = new int[m];
		System.out.println("请输入数组元素，每个元素以回车键结束！");
		for(int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}
		String str = "[";
		for(int i = 0; i < arr.length - 1; i++) {
			str = str + arr[i] + ",";
		}
		str = str + arr[arr.length - 1] + "]";
		System.out.println(str);
		sc.close();
	}
}
