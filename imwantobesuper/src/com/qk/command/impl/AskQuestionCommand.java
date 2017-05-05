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
		MyConsole.println("=========== 欢迎提问");
		Question qu = new Question();
		String value;
		String isopen;
		int credit;
		int id = player.getId();
		while (true) {
			value = MyConsole.askUserInput("您的问题");
			if(value.trim().equals("")){
				MyConsole.println("问题不能为空，请重新输入！");
				continue;
			}
			break;
		}
		while (true) {
			 isopen= MyConsole.askUserInput("是否开放");
			 if(!isopen.equalsIgnoreCase("y")&&!isopen.equalsIgnoreCase("n")){
					MyConsole.println("请输入参数：y or n");
					continue;

				}
			 break;
		}
		while (true) {
			credit= MyConsole.askUserInputInt("问题分值");
			if(player.getScore()<credit){
				MyConsole.println("您当前的分值不够，请重新输入分值！");
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
			MyConsole.println("=========== 提问成功");
		} else {
			MyConsole.println("ask fail!");
		}
	}

}
