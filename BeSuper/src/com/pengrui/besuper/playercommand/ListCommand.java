package com.pengrui.besuper.playercommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.PlayerCommand;
import com.pengrui.besuper.pojo.Player;

public class ListCommand extends PlayerCommand{
	public ListCommand(Player playerProfile) {
		super(playerProfile);
		// TODO Auto-generated constructor stub
	}

	public static void listAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;
		ResultSet res1 = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions");
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("无记录！");
			} else {
				while (true) {
					int id = res.getInt("id");
					String questionsdes = res.getString("description");
					String status = res.getString("status");
					int questionsUserId = res.getInt("users_id");
					if ("solved".equals(status.toLowerCase())) {
						int answersId = res.getInt("answers_id");
						ps1 = conn.prepareStatement("select * from Be_Super.answers where id = ?");
						ps1.setInt(1, answersId);
						ps1.execute();
						res1 = ps1.getResultSet();
						while (res1.next()) {
							String answersdes = res1.getString("description");
							int answersUserId = res1.getInt("users_id");
							System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
									+ status + " ] [ " + answersdes + " ] [ " + answersUserId + " ]");
						}
					} else {
						System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
								+ status + " ]");
					}
					if (!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ListCommandClean(conn, ps, ps1, res, res1);
		}

	}

	public static void listMine(int usersId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;
		ResultSet res1 = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where users_id = ?");
			ps.setInt(1, usersId);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("无记录！");
			} else {
				while (true) {
					int id = res.getInt("id");
					String questionsdes = res.getString("description");
					String status = res.getString("status");
					int questionsUserId = res.getInt("users_id");
					if ("solved".equals(status.toLowerCase())) {
						int answersId = res.getInt("answers_id");
						ps1 = conn.prepareStatement("select * from Be_Super.answers where id = ?");
						ps1.setInt(1, answersId);
						ps1.execute();
						res1 = ps1.getResultSet();
						while (res1.next()) {
							String answersdes = res1.getString("description");
							int answersUserId = res1.getInt("users_id");
							System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
									+ status + " ] [ " + answersdes + " ] [ " + answersUserId + " ]");
						}
					} else {
						System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
								+ status + " ]");
					}
					if (!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ListCommandClean(conn, ps, ps1, res, res1);
		}

	}

	public static void listOpen() {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;
		ResultSet res1 = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where status = ?");
			ps.setString(1, "UNSOLVED");
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("无记录！");
			} else {
				while (true) {
					int id = res.getInt("id");
					String questionsdes = res.getString("description");
					String status = res.getString("status");
					int questionsUserId = res.getInt("users_id");
					if ("solved".equals(status.toLowerCase())) {
						int answersId = res.getInt("answers_id");
						ps1 = conn.prepareStatement("select * from Be_Super.answers where id = ?");
						ps1.setInt(1, answersId);
						ps1.execute();
						res1 = ps1.getResultSet();
						while (res1.next()) {
							String answersdes = res1.getString("description");
							int answersUserId = res1.getInt("users_id");
							System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
									+ status + " ] [ " + answersdes + " ] [ " + answersUserId + " ]");
						}
					} else {
						System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
								+ status + " ]");
					}
					if (!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ListCommandClean(conn, ps, ps1, res, res1);
		}

	}

	public static void listId(int sId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;
		ResultSet res1 = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where id = ?");
			ps.setInt(1, sId);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("无记录！");
			} else {
				while (true) {
					int id = res.getInt("id");
					String questionsdes = res.getString("description");
					String status = res.getString("status");
					int questionsUserId = res.getInt("users_id");
					if ("solved".equals(status.toLowerCase())) {
						int answersId = res.getInt("answers_id");
						ps1 = conn.prepareStatement("select * from Be_Super.answers where id = ?");
						ps1.setInt(1, answersId);
						ps1.execute();
						res1 = ps1.getResultSet();
						while (res1.next()) {
							String answersdes = res1.getString("description");
							int answersUserId = res1.getInt("users_id");
							System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
									+ status + " ] [ " + answersdes + " ] [ " + answersUserId + " ]");
						}
					} else {
						System.out.println("[ " + id + " ] [ " + questionsUserId + " ] [ " + questionsdes + " ] [ "
								+ status + " ]");
					}
					if (!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ListCommandClean(conn, ps, ps1, res, res1);
		}

	}

	public static void ListCommandClean(Connection conn, PreparedStatement ps, PreparedStatement ps1, ResultSet res,
			ResultSet res1) {
		try {
			if (res != null) {
				res.close();
			}
			if (res1 != null) {
				res.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (ps1 != null) {
				ps1.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excute() {
		
		
	}


}
