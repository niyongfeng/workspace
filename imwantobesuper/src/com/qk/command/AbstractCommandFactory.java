package com.qk.command;

import com.qk.Object.Player;

public abstract class AbstractCommandFactory {

	public enum CommandCode {
		//system
		EXIT,
		HELP,
		LOGIN,
		SIGNUP,
		
		//PLAYER
		ASK,
		ACCEPT,
		ANSWER,
		SCORE,
		LIST
	}

	public static AbstractCommandFactory getFactory(Player player) {
		if (player == null) {
			return new SystemCommandFactroy();
		}
		return new PlayerCommandFactory(player);
	}

	public abstract Command buildCommand(CommandCode cmd);

}
