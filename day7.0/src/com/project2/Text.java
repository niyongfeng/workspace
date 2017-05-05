package com.project2;

import java.util.Scanner;

public class Text {

	public static void main(String[] agrs) {
		
		System.out.println("请输入1个1-100的数字：");
		Scanner sc = new Scanner(System.in);
		int shuzi = sc.nextInt();
		int shuzi1 =(int)(Math.random() * 100) + 1;
		
		while(shuzi1 != shuzi) {
			
			if(shuzi1 > shuzi) {
				System.out.println("你输入的数字小了，请重新输入：");
				shuzi = sc.nextInt();
			}else {
				System.out.println("你输入的数字大了，请重新输入：");
				shuzi = sc.nextInt();
			}
			
		}
		
		System.out.println("恭喜你猜对了，数字为:" + shuzi1);
		sc.close();
		
	}
}
