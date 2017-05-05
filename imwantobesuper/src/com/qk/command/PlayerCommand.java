package com.qk.command;

import com.qk.Object.Player;

public abstract class PlayerCommand  implements Command{
	protected Player player;
	
	public PlayerCommand(Player player) {
		this.player = player;
	}
	
	

}
