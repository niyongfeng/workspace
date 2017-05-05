package com.pengrui.besuper.command;

import com.pengrui.besuper.pojo.Player;

public abstract class CommandFactory {
	
	public static enum CommandCode{
		//SYSTEM
		EXIT,
		HELP,
		LOGIN,
		SIGNUP,
		//PLAYER
		ASK,
		ANSWER,
		LIST,
		ACCEPT
	}
	
	public static CommandFactory buildFactory(Player player) {
		if(player == null) {
			return new SystemCommandFactory();
		}
		return new PlayerCommandFactory(player);
	} 
	
	
	public abstract Command buildCommand(CommandCode cmd);
}
