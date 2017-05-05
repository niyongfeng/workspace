package com.func;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		int  x;
		Func func = new Func();
		System.out.println("请输入一个五位数:");
		Scanner sc = new Scanner(System.in);
		while(true) {
			x = sc.nextInt();
			if((x / 10000 >= 1) &&(x / 10000 <= 9)) {
				break;
			}else {
				System.out.println("您的输入有误！请重新输入：");
			}
			
		}
		System.out.println(func.func(x));
		sc.close();
	}
}
