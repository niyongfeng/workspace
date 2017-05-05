package com.qk.GO;

import com.qk.Object.Player;
import com.qk.command.AbstractCommandFactory;
import com.qk.command.AbstractCommandFactory.CommandCode;
import com.qk.command.Command;
import com.qk.command.impl.LoginCommand;
import com.qk.util.MyConsole;

public class ImWantToBeSuper {

	private static Command command = null;
	private static Player player = null;

	public static void main(String[] args) {
		MyConsole.println(" You are welcome to XUE BA!");
		MyConsole.println("Please command,you can input 'help' to get help");
		String info = null;
		int t = 0;
		while (true) {
			info = MyConsole.askUserInput("cmd");
			CommandCode cmd = null;

			try {
				cmd = CommandCode.valueOf(info.toUpperCase());
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				t = 1;
				MyConsole.println("����������������룡");

			}

			command = AbstractCommandFactory.getFactory(player).buildCommand(
					cmd);

			try {
				command.execute();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				if (t == 0) {
					MyConsole.println("����û�е�¼���޷�ʹ�øù��ܣ�");
				}
				t = 0;
			}

			if (info.equalsIgnoreCase("login")) {
				LoginCommand loginCommand = (LoginCommand) command;
				player = loginCommand.getPlayer();
				player.toString();
			}

		}

	}

}
