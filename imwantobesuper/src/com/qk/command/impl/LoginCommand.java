package com.qk.command.impl;

import org.apache.commons.codec.digest.DigestUtils;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Player;
import com.qk.command.Command;
import com.qk.util.MyConsole;

public class LoginCommand implements Command {
	private Player player = null;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("===========��¼");
		String username;
		String password;
		while (true) {
			username = MyConsole.askUserInput("�û��˺�");
			password = MyConsole.askUserInput("�û�����");
			player = BesuperDao.toLogin(username, DigestUtils.md5Hex(password));
			if (player == null) {
				MyConsole.println("�û������ڻ��������");
				continue;

			}
			MyConsole.println("===========��ӭ"+player.getName()+"����");
			break;
		}
	}

	public Player getPlayer() {
		return player;
	}

}
