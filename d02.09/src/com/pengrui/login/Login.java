package com.pengrui.login;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		System.out.println("欢迎来到倪永烽的帝国，请输入您的用户名和密码：(只有三次机会哦！)");
		Scanner sc = new Scanner(System.in);
		String name, pwd;
		for (int i = 0; i < 3; i++) {
			System.out.println("用户名：");
			name = sc.next();
			System.out.println("密码：");
			pwd = sc.next();
			if (name.equals("niyongfeng") && pwd.equals("12345")) {
				System.out.println("我亲爱的臣子，欢迎你进入帝国！");
				break;
			} else {
				if (i < 2) {
					System.out.println("您的用户名/密码错误，请重新输入！");
					System.out.println("您还有" + (2 - i) + "次机会");
				}else {
					System.out.println("你没有机会了！");
				}
			}
			if (i == 2 && !(name.equals("niyongfeng") && pwd.equals("12345"))) {
				System.out.println("你TMD去死吧！奸细！");
			}
		}
		sc.close();

	}
}
