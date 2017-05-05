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
		MyConsole.println("===========ע��");
		String nickname, username, password;

		nickname = MyConsole.askUserInput("�ǳ�");
		while (true) {
			username = MyConsole.askUserInput("�û���");
			if(BesuperDao.isUserExist(username)){
				MyConsole.println("�û����Ѿ����ڣ����������룡");
				continue;
			}
			while (true) {
				password = MyConsole.askUserInput("����");
				try {
					voliDatePassword(password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					MyConsole.println("error>�����ʽ���ԣ�"+e.getMessage());
					continue;
				}
				break;
			}
			Player 	player = BesuperDao.SignUp(nickname, username, DigestUtils.md5Hex(password));
			MyConsole.println("==========="+player.getName()+"ע��ɹ�");
			break;
		}
	}

	private void voliDatePassword(String password) throws Exception {
		Pattern pat=Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!pat.matcher(password).find()){
			throw new Exception("���볤�ȱ�����ڵ���6");
		}
		
		Pattern pat1=Pattern.compile("[0-9]");
		if(!pat1.matcher(password).find()){
			throw new Exception("�����б������һ������");
		}
		
		Pattern pat2=Pattern.compile("[a-zA-Z]");
		if(!pat2.matcher(password).find()){
			throw new Exception("�����б������һ����ĸ");
		}
		

	}

}
