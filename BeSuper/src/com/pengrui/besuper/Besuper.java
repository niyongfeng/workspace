package com.pengrui.besuper;

import com.pengrui.besuper.command.Command;
import com.pengrui.besuper.command.CommandFactory;
import com.pengrui.besuper.command.CommandFactory.CommandCode;
import com.pengrui.besuper.pojo.Player;
import com.pengrui.besuper.systemcommand.LoginCommand;
import com.pengrui.besuper.utils.QingkeConsole;

public class Besuper {
	private static Command command = null;
	private static Player player = null;

	public static void main(String[] args) {
		System.out.println("Please command,you can input 'help' to get help");
		String info = null;
		int t = 0;
		while (true) {
			info = QingkeConsole.askUserInput("cmd");
			CommandCode cmd = null;

			try {
				cmd = CommandCode.valueOf(info.toUpperCase());
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				t = 1;
				QingkeConsole.println("命令错误，请重新输入！");

			}

			command = CommandFactory.buildFactory(player).buildCommand(
					cmd);

			try {
				command.excute();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				if (t == 0) {
					QingkeConsole.println("您还没有登录，无法使用该功能！");
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
