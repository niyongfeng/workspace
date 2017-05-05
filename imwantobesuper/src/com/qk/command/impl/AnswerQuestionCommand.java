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
		MyConsole.println("======== ���ܹ��������²��������������  ========");
		MyConsole.println("= ALL    -��ʵ��������������� ");
		MyConsole.println("= Null   -����������������ʾ���� ");
		String str = MyConsole.askUserInput("parameter");
		List<Question> qulist = BesuperDao.searchQuestionOpen();
		if (str.equalsIgnoreCase("all")) {
			if (qulist != null && qulist.size() > 0) {
				for (Question question : qulist) {
					MyConsole.println("ID��" + question.getId() + " ���⣺"
							+ question.getValue() + "  ��ֵ��"
							+ question.getCredit());
				}
			} else {
				MyConsole.println("��ǰû�����⣡");
				return;
			}
		}

		int id;
		Question question;
		while (true) {
			id = MyConsole.askUserInputInt("����ID");
			question = BesuperDao.searchQuestionID(id);
			if (question == null) {
				MyConsole.println("�����˲����ڵ����⣬���������룡");
				continue;
			} else if (question.getPlayer_id() == player.getId()) {
				MyConsole.println("�����ܻش��Լ������⣬���������룡");
				continue;
			}
			MyConsole.println("���⣺" + question.getValue() + "  ��ֵ��"
					+ question.getCredit());
			break;
		}

		String value;
		while (true) {
			value = MyConsole.askUserInput("value");
			if (value.trim().equalsIgnoreCase("")) {
				System.out.println("���ⲻ��Ϊ�գ����������룡");
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
			MyConsole.println("=========== �ش�ɹ�");
		} else {
			MyConsole.println("answer fail!");
		}

	}

}
