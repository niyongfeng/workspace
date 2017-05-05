package com.pengrui.besuper.playercommand;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.PlayerCommand;
import com.pengrui.besuper.pojo.Player;

public class AskCommand extends PlayerCommand{
	
	public AskCommand(Player player) {
		super(player);
	}

	private static Scanner sc = new Scanner(System.in);

	public static void addQuestion(int answerId) {
		Connection conn = null;
		CallableStatement cs = null;
		String des = "";
		conn = JDBC.getConnection();
		try {
			cs = conn.prepareCall("call Be_Super.add_question (?,?,?)");
			while (true) {
				System.out.println("请输入你的问题：");
				System.out.print("cmd> ");
				des = sc.nextLine();
				if (isEmpty(des) == false) {
					break;
				}
			}
			System.out.println("请输入赏金：");
			System.out.print("cmd> ");
			int credit = sc.nextInt();
			cs.setString(1, des);
			cs.setInt(2, answerId);
			cs.setInt(3, getCredit(answerId,credit));
			if(!cs.execute()) {
				System.out.println("提交成功!");
			} else {
				System.out.println("提交失败！");
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

	private static boolean isEmpty(String des) {
		boolean b = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where description = ?");
			ps.setString(1, des);
			ps.execute();
			res = ps.getResultSet();
			if (res.next()) {
				System.out.println("此问题已存在!请重新输入！");
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
	
	public static int getCredit(int answerId, int credit) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;
		int putCredit = 0;
		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.users where id = ?");
			ps.setInt(1, answerId);
			ps.execute();
			res = ps.getResultSet();
			res.next();
			int hasCredit = res.getInt("scores");
			if(credit >= hasCredit) {
				putCredit = hasCredit;
			}else {
				putCredit = credit;
			}
			ps1 = conn.prepareStatement("update Be_Super.users set scores = ? where id = ?");
			ps1.setInt(1, (hasCredit - putCredit));
			ps1.setInt(2, answerId);
			ps1.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(res != null) {
					res.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(ps1 != null) {
					ps1.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		return putCredit;
		
	}

	@Override
	public void excute() {
		System.out.println("ask");
		addQuestion(player.getId());
		
	}



}
