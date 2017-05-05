package com.pengrui.besuper.systemcommand;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.SystemCommand;

public class SignCommand extends SystemCommand{
	private static Scanner sc = new Scanner(System.in);

	public static void register() {
		System.out.println("======================== 注册界面 ========================");
		Connection conn = null;
		CallableStatement cs = null;

		try {
			String name = "";
			while (true) {
				System.out.println("请输入注册名字：");
				System.out.print("cmd> ");
				name = sc.nextLine();
				if (isExist(name) == true) {
					System.out.println("用户名已存在！请重新输入！");
				} else {
					break;
				}
			}
			System.out.println("请输入注册密码：");
			System.out.print("cmd> ");
			String password = sc.nextLine();
			conn = JDBC.getConnection();
			cs = conn.prepareCall("call Be_Super.register (?,?,0)");

			cs.setString(1, name);
			cs.setString(2, password);

			if(!cs.execute()) {
				System.out.println("注册成功！");
				System.out.println("用户名：" + name + "\n密码：" + password);
			} else {
				System.out.println("注册失败！");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static boolean isExist(String name) {
		boolean b = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		conn = JDBC.getConnection();
		try {
			ps = conn.prepareStatement("select * from Be_Super.users where name = ?");
			ps.setString(1, name);
			ps.execute();
			res = ps.getResultSet();
			if (res.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.clean(conn, ps, res);
		}
		return b;

	}

	@Override
	public void excute() {
		register();		
	}
}
