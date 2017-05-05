package com.drink;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		int x;
		Test test = new Test();
		System.out.println("请选择你需要的饮品：");
		System.out.println("1、咖啡  2、啤酒  3、牛奶");
		Scanner sc = new Scanner(System.in);
		while(true) {
		x = sc.nextInt();
		if(x > 0 && x< 4) {
			break;
		}else {
			System.out.println("您的输入有误！请重新输入：");
		}
		}
		System.out.println(test.toString(x));
		sc.close();
		
	}

	public String toString(int x) {
		if(x == 1) {
			return "您点的是咖啡，请拿好，谢谢光临！";
		}else if(x == 2) {
			return "您点的是啤酒，请拿好，谢谢光临！";
		}else{
			return "您点的是牛奶，请拿好，谢谢光临！";
		}
	}
}
