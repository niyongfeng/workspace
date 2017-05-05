package com.qk.command.impl;

import java.util.List;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Answer;
import com.qk.Object.Player;
import com.qk.Object.Question;
import com.qk.command.Command;
import com.qk.command.PlayerCommand;
import com.qk.util.MyConsole;

public class AcceptQuestionCommand extends PlayerCommand implements Command {

	public AcceptQuestionCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("======== 你能够输入以下参数获得你提出的问题回答  ========");
		MyConsole.println("= MINE    -显示所有你提出的问题 ");
		MyConsole.println("= NULL    -其他任何输入跳过列出问题");
		String str = MyConsole.askUserInput("parameter");
		List<Question> qulist = BesuperDao.searchQuestionMINE(player.getId());
		if (str.equalsIgnoreCase("mine")) {
			if (qulist != null && qulist.size() > 0) {
				for (Question question : qulist) {
					MyConsole.println("ID：" + question.getId() + " 问题："
							+ question.getValue() + "  分值："
							+ question.getCredit()+"  开放："+question.getIsOpen());
				}
			} else {
				MyConsole.println("您并没有提出过问题！");
				return;
			}
		}

		int n = 0;
		int question_id;
		while (true) {
			question_id = MyConsole.askUserInputInt("问题ID");
			for (Question question : qulist) {
				if (question.getId() == question_id) {
					n++;
					break;
				}
			}
			if (n > 0) {
				break;
			} else {
				MyConsole.println("您输入了一个错误的问题ID，请重新输入！");
			}
		}
		List<Answer> an = BesuperDao.searchQuestionAllAnswer(question_id);
		if (an != null && an.size() > 0) {
			for (Answer answer : an) {
				MyConsole
						.println(String.format("回答ID：%d    回答：%s    Best：%s    回答者：%s",
								answer.getId(), answer.getValue(),answer.getBest(), BesuperDao
										.searchPlayer(answer.getPlayer_id())
										.getName()));
			}
		} else {
			MyConsole.println("当前问题没有回答!");
			return;
		}

		int answer_id;
		Answer ans = new Answer();
		Question que = new Question();
		int i = 0;
		while (true) {
			answer_id = MyConsole.askUserInputInt("接受回答的ID");
			for (Answer answer : an) {
				if (answer.getId() == answer_id) {
					i++;
					ans = answer;
					que.setId(ans.getQuestion_id());
					break;
				}
			}
			if (i == 0) {
				MyConsole.println("请输入正确的ID！");
				continue;
			}
			break;
		}
		que = BesuperDao.searchQuestionID(que.getId());
		boolean f = BesuperDao.acceptAnswer(que, ans);
		if (f) {
			MyConsole.println("========操作成功！");
		}else{
			MyConsole.println("========操作失败！");

		}

	}

}
