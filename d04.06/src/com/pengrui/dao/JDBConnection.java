package com.pengrui.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBConnection {
	private Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private JDBConnection() {
		
	}
	
	private static JDBConnection jdbc = new JDBConnection();
	
	public static JDBConnection getInstance() {
		return jdbc;
	}
	
	public static String getProperties(String key) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("jdbc.properties"));
			String str = pro.getProperty(key);
			return str;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection() {
		String url = getProperties("url");
		String username = getProperties("username");
		String password = getProperties("password");
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
