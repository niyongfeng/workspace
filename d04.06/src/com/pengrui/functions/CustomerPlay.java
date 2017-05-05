package com.pengrui.functions;

import java.util.Collection;

import com.pengrui.dao.Dao;
import com.pengrui.util.MyConsole;

public class CustomerPlay {
	public static void play() {
		System.out.println("尊敬的顾客 " + Login.user.getName() + " 欢迎回来！");
		System.out.println("0.退出");
		System.out.println("1.显示所有商品");
		System.out.println("2.购买商品");
//		System.out.println("2.添加商品到购物车");
		System.out.println("3.显示购物车");
		System.out.println("4.删除购物车中的商品");
//		System.out.println("5.支付");
		//Buy.buy();
		one : while(true) {
			int i = MyConsole.userInputInt();
			switch(i) {
			case 0:
				break one;
			case 1:
				System.out.println("购物商城：");
				Buy.buy();
				break;
			case 2:
				System.out.print("请输入下单的商品编号：");
				if(Dao.insertOrder(MyConsole.userInputInt())){
					System.out.println("下单成功");
				}else {
					System.out.println("下单失败");
				}
				break;
			case 3:
				System.out.println("购物车信息：");
				for(Orders o : Dao.searchOrder(Login.customer)) {
					System.out.println(o.toString());
				}
				break;
			case 4:
				System.out.println("请输入要删除的单号：");
				int x = MyConsole.userInputInt();
				if(Dao.deleteOrder(x)) {
					System.out.println("删除成功！");
				}else {
					System.out.println("删除失败！");
				}
				break;
			}
		}
	}
}
