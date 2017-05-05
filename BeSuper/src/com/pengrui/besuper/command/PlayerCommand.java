package com.pengrui.besuper.command;

import com.pengrui.besuper.pojo.Player;

public abstract class PlayerCommand implements Command {

	protected Player player;
	
	public PlayerCommand(Player player) {
		this.player = player;
	}
}
