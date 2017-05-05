package com.pengrui.learnjdbc1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//sql注入攻击
public class SqlInject {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		
		Connection conn = null;
		Statement sta = null;
		ResultSet res = null;
		try {
			conn = LearnJDBC.getConnection();
			sta = conn.createStatement();
			String sql = "select * from orders_manage_system.customers where name = '" + username + "' and pwd = '" + password + "'";
			res = sta.executeQuery(sql);
			while(res.next()) {
				int id = res.getInt("customers_id");
				String pwd = res.getString("pwd");
				String name = res.getString("name");
				String phone = res.getString("phone");
				String address = res.getString("address");
				String email = res.getString("email");
				int postcode = res.getInt("postcode");
				System.out.println("id:" + id + 
						",name:" + name + 
						",pwd:" + pwd + 
						",phone:" + phone + 
						",address:" + address + 
						",email:" + email + 
						",postcode:" + postcode);
				//System.out.println("id:" + res.getInt("id") + ",name:" + res.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			LearnJDBC.clean(conn,sta,res);
		}
	}

}
