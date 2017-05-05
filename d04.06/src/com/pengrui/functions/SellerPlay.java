package com.pengrui.functions;

import com.pengrui.dao.Dao;
import com.pengrui.object.Sellers;
import com.pengrui.test.Test;
import com.pengrui.util.MyConsole;

public class SellerPlay {
	public static void play() {
		System.out.println("尊敬的商家 " + Login.user.getName() + " 欢迎回来！");
		Sellers sel = new Sellers();
		sel.setId(Login.user.getSellersId());
		// Manages.manages(Dao.searchSeller(sel).get(0));
		Sellers seller = Dao.searchSeller(sel).get(0);
		System.out.println("0.退出");
		System.out.println("1.添加商品");
		System.out.println("2.显示本家商品");
		System.out.println("3.修改商品属性");
		System.out.println("4.删除商品");
		one : while (true) {
			int i = MyConsole.userInputInt();
			switch (i) {
			case 0:
				break one;
			case 1:
				System.out.println(Dao.insertProduct(Test.getProduct(seller)));
				break;
			case 2:
				Manages.manages(seller);break;
			case 3:
				Dao.updateProductSeller(Test.getProduct());
				break;
			case 4:
				System.out.println("请输入删除的商品编号：");
				System.out.println(Dao.deleteProductSeller(MyConsole.userInputInt()));
				break;
			default: System.out.println("输入有误！请重新输入！");break;
			}
		}
	}
}
