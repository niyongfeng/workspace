package com.pengrui.learnjdbc1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;



public class LearnJDBC {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		loadDriverClass();
		System.out.println("======= Statement ======");
		//doStatement();
		System.out.println("======= PreparedStatement ======");
		//doPreparedStatement();
		System.out.println("======= CallableStatement ======");
		//doCallableStatement();
		doBatch();
	}
	
	public static void doBatch() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("INSERT INTO `orders_manage_system`.`customers`(`customers_id`,`pwd`,`name`,`phone`,`address`,`email`,`postcode`)VALUES(?,?,?,?,?,?,?)");
			int postcode = 100000;
			for(int i = 100; i < 110; i++) {
				ps.setInt(1, i);
				ps.setString(2, "qingke" + i);
				ps.setString(3, "qingke" + i);
				ps.setString(4, "18888888888");
				ps.setString(5, "杭州市");
				ps.setString(6, "qingke" + i + "@163.com");
				ps.setInt(7, postcode + i);
				//ps.execute();
				ps.addBatch();
			}
			
			int[] result = ps.executeBatch();
			System.out.println("result:" + Arrays.toString(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			clean(conn, ps, res);
		}
		
	}
	
	public static void doCallableStatement() {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet res = null;
		
		try {
			conn = getConnection();
			cs = conn.prepareCall("call orders_manage_system.counts(?,?)");
			System.out.println("请输入查询用户名:");
			String name = sc.nextLine();
			
			cs.setString(1, name);
			cs.registerOutParameter(2, Types.INTEGER);
			
			cs.execute();
			int resultcount = cs.getInt(2);
			System.out.println("count：" + resultcount);
			
			res = cs.getResultSet();
			
			while(res.next()) {
				int id = res.getInt("customers_id");
				String pwd1 = res.getString("pwd");
				String name1 = res.getString("name");
				String phone1 = res.getString("phone");
				String address1 = res.getString("address");
				String email1 = res.getString("email");
				int postcode1 = res.getInt("postcode");
				System.out.println("id:" + id + 
						",name:" + name1 + 
						",pwd:" + pwd1 + 
						",phone:" + phone1 + 
						",address:" + address1 + 
						",email:" + email1 + 
						",postcode:" + postcode1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void doPreparedStatement() {
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select * from orders_manage_system.customers where name = ? and pwd = ?");
			//??????无法查询到杭州市这条信息？？？？无法识别eclipse的中文？？？？
			//编码问题，在url ？后面加useUnicode=true&characterEncoding=utf-8
			ps.setString(1, username);
			ps.setString(2, password);
			//ps.setString(3, "重庆市");
			res = ps.executeQuery();
			
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			clean(conn, ps, res);
		}
		
	}
	
	public static void doStatement() {
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		Connection conn = null;
		Statement sta = null;
		ResultSet res = null;
		try {
			conn = getConnection();
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
			clean(conn,sta,res);
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = getProperty("url");
		String user = getProperty("user");
		String password = getProperty("password");
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static String getProperty(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("connections"));
			
			return prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static void loadDriverClass() {
		try {
			Class.forName(getProperty("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clean(Connection conn, Statement sta,ResultSet res) {
		try {
			if(res != null) {
				res.close();
			}
			if(sta != null) {
				sta.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
}
