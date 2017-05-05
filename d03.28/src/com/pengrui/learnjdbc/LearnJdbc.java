package com.pengrui.learnjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class LearnJdbc {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//注册驱动方法1：
			Class.forName(getProperty("jdbc.driver"));
			//注册驱动方法2：
			DriverManager.registerDriver(new Driver());
			
			String url = getProperty("url");
			String user = getProperty("user");
			String password = getProperty("password");
			
			//创建连接
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("get database: " + conn);
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
}
