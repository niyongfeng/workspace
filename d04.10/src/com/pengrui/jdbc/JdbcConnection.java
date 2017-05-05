package com.pengrui.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
	public JdbcConnection() {

	}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String url = null;
		String user = null;
		String password = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = "jdbc:mysql://localhost:3306/project_manage?useSSL=false&useUnicode=true&characterEncoding=utf-8";
		user = "root";
		password = "921104nyf";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("数据库连接错误");
			e.printStackTrace();
		}
		String sql = "insert into user(name,gender,company,mobile_phone) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "nyf");
			ps.setString(2, "false");
			ps.setString(3, "pengrui");
			ps.setString(4, "18100174037");
			ps.execute();
		} catch (SQLException e) {
			System.out.println("数据库操作错误");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
