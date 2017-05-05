package com.pengrui.besuper.systemcommand;
  
import com.pengrui.besuper.command.SystemCommand;
import com.pengrui.besuper.utils.QingkeConsole;

public class ExitCommand extends SystemCommand{

	@Override
	public void excute() {
		QingkeConsole.terminate();
	}

}
