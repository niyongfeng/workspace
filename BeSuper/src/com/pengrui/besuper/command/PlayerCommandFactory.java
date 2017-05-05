package com.pengrui.besuper.command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.pengrui.besuper.playercommand.AcceptCommand;
import com.pengrui.besuper.playercommand.AnswerCommand;
import com.pengrui.besuper.playercommand.AskCommand;
import com.pengrui.besuper.playercommand.ListCommand;
import com.pengrui.besuper.pojo.Player;

public class PlayerCommandFactory extends SystemCommandFactory {

	private Player player = new Player();

	public PlayerCommandFactory(Player player) {
		this.player = player;
	}

	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();

	static {
		commandMap.put(CommandCode.ASK, AskCommand.class);
		commandMap.put(CommandCode.ACCEPT, AcceptCommand.class);
		commandMap.put(CommandCode.ANSWER, AnswerCommand.class);
		commandMap.put(CommandCode.LIST, ListCommand.class);
	}

	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> clzz = commandMap.get(cmd);
		
		try {
			Constructor<? extends Command> c = clzz.getConstructor(Player.class);
			
			Command command = c.newInstance(new Object[]{player});
			
			return command;
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Command command = super.buildCommand(cmd);
		return null;
	}

}
