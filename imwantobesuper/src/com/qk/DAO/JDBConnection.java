package com.qk.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JDBConnection {
	private static Connection con = null;
	
	private JDBConnection() {
		try {
			Class.forName(getProperties("db.Driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static JDBConnection jdbConnection=new JDBConnection();
	public static JDBConnection getInstance(){
		return jdbConnection;
	}
	

	

	public Connection getConnection() {
		String url = getProperties("db.url");
		String user = getProperties("db.username");
		String pass = getProperties("db.password");
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


	private static String getProperties(String key) {
		Properties per = new Properties();
		try {
			per.load(new FileInputStream("jdbc.properties"));
			String str = per.getProperty(key);
			return str;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
