package com.qk.command.impl;

import java.util.List;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Answer;
import com.qk.Object.Player;
import com.qk.Object.Question;
import com.qk.command.Command;
import com.qk.command.PlayerCommand;
import com.qk.util.MyConsole;

public class AnswerQuestionCommand extends PlayerCommand implements Command {

	public AnswerQuestionCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("======== 你能够输入以下参数获得所有问题  ========");
		MyConsole.println("= ALL    -现实所有你提出的问题 ");
		MyConsole.println("= Null   -输入其他则跳过显示问题 ");
		String str = MyConsole.askUserInput("parameter");
		List<Question> qulist = BesuperDao.searchQuestionOpen();
		if (str.equalsIgnoreCase("all")) {
			if (qulist != null && qulist.size() > 0) {
				for (Question question : qulist) {
					MyConsole.println("ID：" + question.getId() + " 问题："
							+ question.getValue() + "  分值："
							+ question.getCredit());
				}
			} else {
				MyConsole.println("当前没有问题！");
				return;
			}
		}

		int id;
		Question question;
		while (true) {
			id = MyConsole.askUserInputInt("问题ID");
			question = BesuperDao.searchQuestionID(id);
			if (question == null) {
				MyConsole.println("输入了不存在的问题，请重新输入！");
				continue;
			} else if (question.getPlayer_id() == player.getId()) {
				MyConsole.println("您不能回答自己的问题，请重新输入！");
				continue;
			}
			MyConsole.println("问题：" + question.getValue() + "  分值："
					+ question.getCredit());
			break;
		}

		String value;
		while (true) {
			value = MyConsole.askUserInput("value");
			if (value.trim().equalsIgnoreCase("")) {
				System.out.println("问题不能为空，请重新输入！");
				continue;
			}
			break;
		}

		Answer answer = new Answer();
		answer.setValue(value);
		answer.setPlayer_id(player.getId());
		answer.setBest("n");
		answer.setQuestion_id(question.getId());
		int i = BesuperDao.insertAnswer(answer);
		if (i == 1) {
			MyConsole.println("=========== 回答成功");
		} else {
			MyConsole.println("answer fail!");
		}

	}

}
