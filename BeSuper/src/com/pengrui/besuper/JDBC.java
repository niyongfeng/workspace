package com.pengrui.besuper;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC {
	
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
			prop.load(new FileInputStream("connectionlink"));
			
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
