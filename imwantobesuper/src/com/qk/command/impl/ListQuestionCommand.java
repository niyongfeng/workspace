package com.qk.command.impl;

import java.util.List;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Player;
import com.qk.Object.Question;
import com.qk.command.Command;
import com.qk.command.PlayerCommand;
import com.qk.util.MyConsole;

public class ListQuestionCommand extends PlayerCommand implements Command {

	public ListQuestionCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("=========== Parameter: ALL | MINE | OPEN");

		List<Question> list = null;
		Player player = super.player;
		while (true) {
			String say = MyConsole.askUserInput("parameter");
			if (say.equalsIgnoreCase("all")) {
				list = BesuperDao.searchQuestionALL();
				println(list);
				MyConsole.println("=========== 显示完成");
			} else if (say.equalsIgnoreCase("mine")) {
				list = BesuperDao.searchQuestionMINE(player.getId());
				println(list);
				MyConsole.println("=========== 显示完成");

			} else if (say.equalsIgnoreCase("open")) {
				list = BesuperDao.searchQuestionOpen();
				println(list);
				MyConsole.println("=========== 显示完成");
			} else {
				try {
					System.out.println(BesuperDao.searchQuestionID(Integer
							.parseInt(say)));
					MyConsole.println("=========== 显示完成");
				} catch (NumberFormatException e) {
					MyConsole.println("请输入一个正确的参数！");
					continue;
				}
			}
			break;
		}

	}

	private void println(List<Question> list) {
		for (Question question : list) {
			MyConsole.println(question);
		}
	}

}
