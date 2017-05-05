package com.pengrui.besuper;

import com.pengrui.besuper.command.CommandFactory;
import com.pengrui.besuper.command.CommandFactory.CommandCode;
import com.pengrui.besuper.command.Command;
import com.pengrui.besuper.pojo.Player;
import com.pengrui.besuper.systemcommand.LoginCommand;
import com.pengrui.besuper.utils.QingkeConsole;

public class BeSuperApp {

	private Player player;
	// 饿汉模式：
	private static BeSuperApp instance;

	private BeSuperApp() {

	}

	public static synchronized BeSuperApp getInstance() {
		if (instance == null) {
			instance = new BeSuperApp();
		}
		return instance;
	}

	// 懒汉模式：
//	private static BeSuperApp instance = new BeSuperApp();
//
//	private BeSuperApp() {
//
//	}
//
//	public static synchronized BeSuperApp getInstance() {
//		return instance;
//	}

	//登记模式：
//	private static BeSuperApp instance = null;
//	private static Map<String,BeSuperApp> map = new HashMap<String,BeSuperApp>();
//	
//	public static synchronized BeSuperApp getInstance(String identifier) {
//		BeSuperApp instance = map.get(identifier);
//		if(instance == null) {
//			instance = new BeSuperApp();
//			map.put(identifier,instance);
//		}
//	}
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You can use the 'HELP' for command usage. Have fun!");

		while (true) {
			String cmd = QingkeConsole.askUserInput("cmd");
			
			CommandCode cc = null;
			try {
			cc = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				QingkeConsole.println("please enter a valib command");
				continue;
			}
			Player player = BeSuperApp.getInstance().getPlayer();
			
			CommandFactory commandFactory = CommandFactory.buildFactory(player);
			Command command = commandFactory.buildCommand(cc);
			if (command != null) {
				command.excute();
			}
			
		}
	}

	public Player getPlayer() {
		return player;
	}

}
