package com.qk.command;

import java.util.HashMap;
import java.util.Map;

import com.qk.command.impl.ExitCommand;
import com.qk.command.impl.HelperCommand;
import com.qk.command.impl.LoginCommand;
import com.qk.command.impl.SignUpCommand;

public class SystemCommandFactroy extends AbstractCommandFactory {
	private static Map<CommandCode, Class<? extends Command>> map = new HashMap<>();
	static {
		map.put(CommandCode.HELP, HelperCommand.class);
		map.put(CommandCode.EXIT, ExitCommand.class);
		map.put(CommandCode.LOGIN, LoginCommand.class);
		map.put(CommandCode.SIGNUP, SignUpCommand.class);

	}

	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> command = map.get(cmd);

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
