package com.pengrui.functions;

import java.util.Iterator;

import com.pengrui.dao.Dao;
import com.pengrui.object.Customers;
import com.pengrui.object.Users;
import com.pengrui.test.Test;

public class Login {
	public static Users user = null;
	public static Customers customer = null;
	public static void loginUser() {
		Iterator<Users> it = Dao.searchUser(Test.getUser()).iterator();
		if (it.hasNext()) {
			user = it.next();
			if (user.getCustomersId() != 0) {
				Customers c = new Customers();
				c.setName(user.getName());
				c.setPwd(user.getPwd());
				customer = Dao.searchCustomer(c).get(0);
				CustomerPlay.play();
			}
			if (user.getSellersId() != 0) {
				SellerPlay.play();
			}
		} else {
			System.out.println("用户名密码错误！");
		}
	}
}
