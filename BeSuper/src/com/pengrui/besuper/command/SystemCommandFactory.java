package com.pengrui.besuper.command;

import java.util.HashMap;
import java.util.Map;

import com.pengrui.besuper.systemcommand.ExitCommand;
import com.pengrui.besuper.systemcommand.HelpCommand;
import com.pengrui.besuper.systemcommand.LoginCommand;
import com.pengrui.besuper.systemcommand.SignCommand;

public class SystemCommandFactory extends CommandFactory{
	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	
	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
	}
	

//	@Override
//	public Command buildCommand(CommandCode cmd) {
//		return commandMap.get(cmd);
//	}
	
	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> command = commandMap.get(cmd);

		if (command != null){
			try {
				return command.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return null;
	}
	
}
