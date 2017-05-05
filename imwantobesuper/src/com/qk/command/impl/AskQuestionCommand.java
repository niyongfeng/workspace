package com.qk.command.impl;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Player;
import com.qk.Object.Question;
import com.qk.command.Command;
import com.qk.command.PlayerCommand;
import com.qk.util.MyConsole;

public class AskQuestionCommand extends PlayerCommand implements Command {

	public AskQuestionCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		MyConsole.println("=========== ��ӭ����");
		Question qu = new Question();
		String value;
		String isopen;
		int credit;
		int id = player.getId();
		while (true) {
			value = MyConsole.askUserInput("��������");
			if(value.trim().equals("")){
				MyConsole.println("���ⲻ��Ϊ�գ����������룡");
				continue;
			}
			break;
		}
		while (true) {
			 isopen= MyConsole.askUserInput("�Ƿ񿪷�");
			 if(!isopen.equalsIgnoreCase("y")&&!isopen.equalsIgnoreCase("n")){
					MyConsole.println("�����������y or n");
					continue;

				}
			 break;
		}
		while (true) {
			credit= MyConsole.askUserInputInt("�����ֵ");
			if(player.getScore()<credit){
				MyConsole.println("����ǰ�ķ�ֵ�����������������ֵ��");
				continue;

			}
			break;
		}
		player.setScore(player.getScore()-credit);
		BesuperDao.updatePlayer(player);
		qu.setValue(value);
		qu.setIsOpen(isopen);
		qu.setPlayer_id(id);
		qu.setCredit(credit);
		int i = BesuperDao.insertQuestion(qu);
		if (i == 1) {
			MyConsole.println("=========== ���ʳɹ�");
		} else {
			MyConsole.println("ask fail!");
		}
	}

}
