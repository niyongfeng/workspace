package com.login;

import java.util.Scanner;

public class Login {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String pwd = sc.next();
		
		for(int i = 0; i < 3; i++) {
			if(i == 2) {
				System.out.println("您的账号已被锁定!");
				break;
			}
			if(name.equals("admin") && pwd.equals("admin")) {
				System.out.println("登录成功");
				break;
			}else {
				System.out.println("用户名密码错误！你还有" + (2 - i) + "次机会！");
				System.out.println("请输入用户名：");
				name = sc.next();
				System.out.println("请输入密码：");
				pwd = sc.next();
			}
		}
		sc.close();
	}

}
