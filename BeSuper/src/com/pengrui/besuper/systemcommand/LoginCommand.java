package com.pengrui.besuper.systemcommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.Command;
import com.pengrui.besuper.command.PlayerCommand;
import com.pengrui.besuper.command.SystemCommand;
import com.pengrui.besuper.pojo.Player;

public class LoginCommand implements Command {

	static Player player = null;
	private static Scanner sc = new Scanner(System.in);

	public static void login() {
		System.out.println("======================== 登录界面 ========================");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		conn = JDBC.getConnection();
		try {
			while (true) {
				System.out.println("请输入登录名：");
				System.out.print("cmd> ");
				String name = sc.nextLine();
				System.out.println("请输入登录密码：");
				System.out.print("cmd> ");
				String password = sc.nextLine();
				ps = conn.prepareStatement("select * from users where name = ? and pwd = ?");
				ps.setString(1, name);
				ps.setString(2, password);
				ps.execute();
				res = ps.getResultSet();
				if (res.next()) {
					player = new Player(res.getInt("id"),res.getString("name"),res.getString("pwd"),res.getInt("scores"));
					System.out.println("欢迎回来," + name);
					break;
				} else {
					System.out.println("用户名密码错误！");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Player getPlayer() {
		return player;
	}

	@Override
	public void excute() {
		login();
//		System.out.println("======================== 登录界面 ========================");
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet res = null;
//		conn = JDBC.getConnection();
//		try {
//			while (true) {
//				System.out.println("请输入登录名：");
//				System.out.print("cmd> ");
//				String name = sc.nextLine();
//				System.out.println("请输入登录密码：");
//				System.out.print("cmd> ");
//				String password = sc.nextLine();
//				ps = conn.prepareStatement("select * from users where name = ? and pwd = ?");
//				ps.setString(1, name);
//				ps.setString(2, password);
//				ps.execute();
//				res = ps.getResultSet();
//				if (res.next()) {
//					player = new Player(res.getInt("id"),res.getString("name"),res.getString("pwd"),res.getInt("scores"));
//					System.out.println("欢迎回来," + name);
//					break;
//				} else {
//					System.out.println("用户名密码错误！");
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
