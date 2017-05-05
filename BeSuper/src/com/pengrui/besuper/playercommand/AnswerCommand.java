package com.pengrui.besuper.playercommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pengrui.besuper.JDBC;
import com.pengrui.besuper.command.PlayerCommand;
import com.pengrui.besuper.pojo.Player;

public class AnswerCommand extends PlayerCommand{
	public AnswerCommand(Player player) {
		super(player);
	}

	private static Scanner sc = new Scanner(System.in);

	public static void getAnswer(int usersId) {
		ListCommand.listAll();
		System.out.println("请输入你要回答的问题序号：");
		System.out.print("cmd> ");
		int id = sc.nextInt();
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet res = null;

		try {
			conn = JDBC.getConnection();
			ps = conn.prepareStatement("select * from Be_Super.questions where id = ?");
			ps.setInt(1, id);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				System.out.println("无此问题！");
			} else {
				while (true) {
					System.out.println(res.getString("description"));
					System.out.println("请输入问题答案：");
					System.out.print("cmd> ");
					String answersdes = sc.next();
					//String answersdes = QingkeConsole.askUserInput("cmd");
					ps1 = conn.prepareStatement("call Be_Super.add_answer(?, ?, ?)");
					ps1.setString(1, answersdes);
					ps1.setInt(2, id);
					ps1.setInt(3, usersId);
					if(!ps1.execute()) {
						System.out.println("提交成功！");
					}else {
						System.out.println("提交失败！");
					}
					if (!res.next()) {
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void excute() {
		getAnswer(player.getId());
		
	}


}
