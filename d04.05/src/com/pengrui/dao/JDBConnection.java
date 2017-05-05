package com.pengrui.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBConnection {
	private static Connection con = null;

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
	
	private static String getProperties(String key) {
		Properties per = new Properties();
		try {
			per.load(new FileInputStream("jdbc.properties"));
			String str = per.getProperty(key);
			return str;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(getProperties("url"),getProperties("username"),getProperties("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
