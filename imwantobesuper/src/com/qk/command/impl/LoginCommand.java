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
		MyConsole.println("===========登录");
		String username;
		String password;
		while (true) {
			username = MyConsole.askUserInput("用户账号");
			password = MyConsole.askUserInput("用户密码");
			player = BesuperDao.toLogin(username, DigestUtils.md5Hex(password));
			if (player == null) {
				MyConsole.println("用户不存在或密码错误！");
				continue;

			}
			MyConsole.println("===========欢迎"+player.getName()+"回来");
			break;
		}
	}

	public Player getPlayer() {
		return player;
	}

}
