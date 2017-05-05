package com.test3;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		
		System.out.println("请输入一个1-100的数字：");
		Scanner sc = new Scanner(System.in);
		int x;
		int y =(int) (Math.random() * 100 + 1);
		while(true) {
			x = sc.nextInt();
			if(x == y) {
				System.out.println("恭喜你猜对了！生成的数字为：" + x);
				break;
			}else if(x > y){
				System.out.println("你输入的数大了!");
				//System.out.println("请重新输入：");
			}else {
				System.out.println("你输入的数小了!");
			}
			System.out.println("请重新输入：");
		}
		sc.close();
	}
	
}
