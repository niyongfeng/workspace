package com.pengrui.functions;

import com.pengrui.dao.Dao;
import com.pengrui.test.Test;
import com.pengrui.util.MyConsole;

public class Register {
	public static void register() {
		while (true) {
			System.out.println("1.顾客模式");
			System.out.println("2.商家模式");
			int i = MyConsole.userInputInt();
			if(i == 1) {
				if(Dao.insertCustomer(Test.getComstomer())) {
					System.out.println("注册成功！");
					break;
				}else {
					System.out.println("注册失败！");
				}
			}else if(i == 2) {
				if(Dao.insertSeller(Test.getSeller())) {
					System.out.println("注册成功！");
					break;
				}else {
					System.out.println("注册失败！");
				}
			}else {
				System.out.println("输入有误！请重新输入！");
			}
		}
	}
}
