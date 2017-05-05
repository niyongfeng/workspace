package com.pengrui.test;


import com.pengrui.functions.Login;
import com.pengrui.functions.Register;
import com.pengrui.object.Customers;
import com.pengrui.object.Products;
import com.pengrui.object.Sellers;
import com.pengrui.object.Users;
import com.pengrui.util.MyConsole;

public class Test {
	public static void main(String[] args) {
		System.out.println("==========轻课商城==========");
		one : while(true) {
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
			switch(MyConsole.userInputInt()) {
			case 1: Login.loginUser();break;
			case 2: Register.register();break;
			case 3:break one;
			default : System.out.println("输入有误！");
			}
		}
	}
	
	public static Customers getComstomer() {
		Customers customer = new Customers();
		System.out.print("用户名：");
		customer.setName(MyConsole.userInput());
		System.out.print("密码：");
		customer.setPwd(MyConsole.userInput());
		System.out.print("电话：");
		customer.setPhone(MyConsole.userInput());
		System.out.print("地址：");
		customer.setAddress(MyConsole.userInput());
		System.out.print("邮箱：");
		customer.setEmail(MyConsole.userInput());
		System.out.print("邮编：");
		customer.setPostcode(MyConsole.userInputInt());
		return customer;
	}
	
	public static Sellers getSeller() {
		Sellers seller = new Sellers();
		System.out.print("用户名：");
		seller.setName(MyConsole.userInput());
		System.out.print("密码：");
		seller.setPwd(MyConsole.userInput());
		System.out.print("电话：");
		seller.setPhone(MyConsole.userInput());
		System.out.print("地址：");
		seller.setAddress(MyConsole.userInput());
		System.out.print("邮箱：");
		seller.setEmail(MyConsole.userInput());
		return seller;
	}
	
	public static Users getUser() {
		Users user = new Users();
		System.out.print("登录名：");
		user.setName(MyConsole.userInput());
		System.out.print("密码：");
		user.setPwd(MyConsole.userInput());
		return user;
	}
	
	public static Products getProduct(Sellers sel) {
		Products pro = new Products();
		System.out.print("商品名：");
		pro.setName(MyConsole.userInput());
		System.out.println("描述：");
		pro.setDescription(MyConsole.userInput());
		System.out.println("价格：");
		pro.setPrice(MyConsole.userInputInt());
		System.out.println("数量：");
		pro.setNumber(MyConsole.userInputInt());
		pro.setSellersId(sel.getId());
		System.out.println("状态：");
		pro.setStatus(MyConsole.userInputInt());
		return pro;
	}
	public static Products getProduct() {
		System.out.print("请输入需要修改的商品编号：");
		int i = MyConsole.userInputInt();
		Products pro = new Products();
		pro.setProductsId(i);
		System.out.print("商品名：");
		pro.setName(MyConsole.userInput());
		System.out.print("描述：");
		pro.setDescription(MyConsole.userInput());
		System.out.print("价格：");
		pro.setPrice(MyConsole.userInputInt());
		System.out.print("数量：");
		pro.setNumber(MyConsole.userInputInt());
		pro.setSellersId(pro.getSellersId());
		System.out.print("状态：");
		pro.setStatus(MyConsole.userInputInt());
		return pro;
	}
}
