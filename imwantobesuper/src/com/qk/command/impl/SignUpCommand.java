package com.qk.command.impl;

import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import com.qk.DAO.BesuperDao;
import com.qk.Object.Player;
import com.qk.command.Command;
import com.qk.util.MyConsole;

public class SignUpCommand implements Command {

	@Override
	public void execute() {
		MyConsole.println("===========注册");
		String nickname, username, password;

		nickname = MyConsole.askUserInput("昵称");
		while (true) {
			username = MyConsole.askUserInput("用户名");
			if(BesuperDao.isUserExist(username)){
				MyConsole.println("用户名已经存在，请重新输入！");
				continue;
			}
			while (true) {
				password = MyConsole.askUserInput("密码");
				try {
					voliDatePassword(password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					MyConsole.println("error>密码格式不对："+e.getMessage());
					continue;
				}
				break;
			}
			Player 	player = BesuperDao.SignUp(nickname, username, DigestUtils.md5Hex(password));
			MyConsole.println("==========="+player.getName()+"注册成功");
			break;
		}
	}

	private void voliDatePassword(String password) throws Exception {
		Pattern pat=Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!pat.matcher(password).find()){
			throw new Exception("密码长度必须大于等于6");
		}
		
		Pattern pat1=Pattern.compile("[0-9]");
		if(!pat1.matcher(password).find()){
			throw new Exception("密码中必须包含一个数字");
		}
		
		Pattern pat2=Pattern.compile("[a-zA-Z]");
		if(!pat2.matcher(password).find()){
			throw new Exception("密码中必须包含一个字母");
		}
		

	}

}
