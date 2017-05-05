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
		MyConsole.println("======== ���ܹ��������²�����������������ش�  ========");
		MyConsole.println("= MINE    -��ʾ��������������� ");
		MyConsole.println("= NULL    -�����κ����������г�����");
		String str = MyConsole.askUserInput("parameter");
		List<Question> qulist = BesuperDao.searchQuestionMINE(player.getId());
		if (str.equalsIgnoreCase("mine")) {
			if (qulist != null && qulist.size() > 0) {
				for (Question question : qulist) {
					MyConsole.println("ID��" + question.getId() + " ���⣺"
							+ question.getValue() + "  ��ֵ��"
							+ question.getCredit()+"  ���ţ�"+question.getIsOpen());
				}
			} else {
				MyConsole.println("����û����������⣡");
				return;
			}
		}

		int n = 0;
		int question_id;
		while (true) {
			question_id = MyConsole.askUserInputInt("����ID");
			for (Question question : qulist) {
				if (question.getId() == question_id) {
					n++;
					break;
				}
			}
			if (n > 0) {
				break;
			} else {
				MyConsole.println("��������һ�����������ID�����������룡");
			}
		}
		List<Answer> an = BesuperDao.searchQuestionAllAnswer(question_id);
		if (an != null && an.size() > 0) {
			for (Answer answer : an) {
				MyConsole
						.println(String.format("�ش�ID��%d    �ش�%s    Best��%s    �ش��ߣ�%s",
								answer.getId(), answer.getValue(),answer.getBest(), BesuperDao
										.searchPlayer(answer.getPlayer_id())
										.getName()));
			}
		} else {
			MyConsole.println("��ǰ����û�лش�!");
			return;
		}

		int answer_id;
		Answer ans = new Answer();
		Question que = new Question();
		int i = 0;
		while (true) {
			answer_id = MyConsole.askUserInputInt("���ܻش��ID");
			for (Answer answer : an) {
				if (answer.getId() == answer_id) {
					i++;
					ans = answer;
					que.setId(ans.getQuestion_id());
					break;
				}
			}
			if (i == 0) {
				MyConsole.println("��������ȷ��ID��");
				continue;
			}
			break;
		}
		que = BesuperDao.searchQuestionID(que.getId());
		boolean f = BesuperDao.acceptAnswer(que, ans);
		if (f) {
			MyConsole.println("========�����ɹ���");
		}else{
			MyConsole.println("========����ʧ�ܣ�");

		}

	}

}
