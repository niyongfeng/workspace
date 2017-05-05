package com.qk.command.impl;

import com.qk.Object.Player;
import com.qk.command.Command;
import com.qk.command.PlayerCommand;
import com.qk.util.MyConsole;

public class ScorePlayerCommand extends PlayerCommand implements Command {

	public ScorePlayerCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("Your score:"+player.getScore());
	}

}
