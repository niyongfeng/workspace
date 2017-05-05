package com.pengrui.besuper.command;

import com.pengrui.besuper.obj.Player;

public abstract class AbstractCommandFactory {
	
	public enum CommandCode {
		//system
		EXIT,
		HELP,
		SIGNUP,
		LOGIN,
				
		//player
		ASK,
		ANSWER,
		ACCEPT,
		SCORE,
		LIST
	}
	
//	public static AbstractCommandFactory getFactory(Player player) {
//		if(player == null) {
//			player = new SystemCommandFactory();
//		}
//		
//		return new PlayerCommandFactory();
//	}
}
