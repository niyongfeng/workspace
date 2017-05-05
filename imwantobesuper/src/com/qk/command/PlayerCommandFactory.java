package com.qk.command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.qk.Object.Player;
import com.qk.command.impl.AcceptQuestionCommand;
import com.qk.command.impl.AnswerQuestionCommand;
import com.qk.command.impl.AskQuestionCommand;
import com.qk.command.impl.ListQuestionCommand;
import com.qk.command.impl.ScorePlayerCommand;

public class PlayerCommandFactory extends SystemCommandFactroy {
	private Player player = new Player();

	public PlayerCommandFactory(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
	}
	
	private static Map<CommandCode,Class<? extends Command>> map=new HashMap<>();
	static {
		map.put(CommandCode.ACCEPT,AcceptQuestionCommand.class);
		map.put(CommandCode.ANSWER,AnswerQuestionCommand.class);
		map.put(CommandCode.ASK,AskQuestionCommand.class);
		map.put(CommandCode.LIST,ListQuestionCommand.class);
		map.put(CommandCode.SCORE,ScorePlayerCommand.class);
	}
	@Override
	public Command buildCommand(CommandCode cmd) {
		// TODO Auto-generated method stub]
		Class<? extends Command> cla=map.get(cmd);
		if(cla!=null){
			try {
				Constructor<? extends Command> c=cla.getConstructor(new Class[]{Player.class});
				Command com=(Command) c.newInstance(new Object[]{player});
				return com;
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
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
		}
		Command command=super.buildCommand(cmd);
		
		return command;
	}

}
