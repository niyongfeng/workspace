package com.pengrui.besuper.playercommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.PlayerCommand;
import com.pengrui.besuper.pojo.Player;

public class AcceptCommand extends PlayerCommand{
	public AcceptCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	private static Scanner sc = new Scanner(System.in);

	public static void getAccept(int usersId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		int scores = 0;
		int id = 0;
		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where users_id = ? and status = ?");
			ps.setInt(1, usersId);
			ps.setString(2, "UNSOLVED");
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("您没有未解决的问题！");
			} else {
				while (true) {
					id = res.getInt("id");
					String des = res.getString("description");
					scores = res.getInt("credit");
					System.out.println("[ " + id + " ] [ " + des + " ]");
					if(!res.next()) {
						break;
					}
				}
				System.out.println("请输入你要查看的问题序号：");
				System.out.print("cmd> ");
				int answersId = sc.nextInt();
				if (getAsk(answersId)) {
					System.out.println("请输入你采纳的答案序号：");
					System.out.print("cmd> ");
					int acceptId = sc.nextInt();
					accept(acceptId,id);
					addScores(scores, acceptId);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean getAsk(int id) {
		boolean b = true;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.answers where questions_id = ?");
			ps.setInt(1, id);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("此问题还没有人回答！");
				b = false;
			} else {
				while (true) {
					int answersId = res.getInt("id");
					String des = res.getString("description");
					int answersUserId = res.getInt("users_id");
					System.out.println("[ " + answersId + " ] [ " + des + " ] [ " + answersUserId + " ]");
					if(!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.clean(conn, ps, res);
		}
		return b;
	}

	public static void accept(int acceptId, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("update Be_Super.questions set status = 'SOLVED', answers_id = ? where id = ?");
			ps.setInt(1, acceptId);
			ps.setInt(2, id);
			if (!ps.execute()) {
				System.out.println("采纳成功！");
			} else {
				System.out.println("采纳失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
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
	
	public static void addScores(int scores, int acceptId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet res = null;
		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.answers where id = ?");
			ps.setInt(1, acceptId);
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				int answersId = res.getInt("users_id");
				ps2 = conn.prepareStatement("select scores from Be_super.users where id = ?");
				ps2.setInt(1, acceptId);
				ps2.execute();
				int score = ps2.getResultSet().getInt("scores");
				ps1 = conn.prepareStatement("update Be_Super.users set scores = ? where id = ?");
				ps1.setInt(1, score + scores);
				ps1.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void excute() {
		getAccept(player.getId());
		
	}

}
