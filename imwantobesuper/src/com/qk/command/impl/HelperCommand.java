package com.qk.command.impl;

import com.qk.command.Command;
import com.qk.util.MyConsole;

public class HelperCommand implements Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MyConsole.println("======== I want to be XUE BA commands ========");
		MyConsole.println("= EXIT    -Exit the application");
		MyConsole.println("= HELP    -Print command use");
		MyConsole.println("= LOGIN   -Login the application");
		MyConsole.println("= SIGNUP  -Sign up an player account");
		MyConsole.println("= LIST    -List question for ALL|MINE|OPEN|ID mode");
		MyConsole.println("= ASK     -Ask a question");
		MyConsole.println("= ANSWER  -Answer a question");
		MyConsole.println("= ACCEPT  -Set best answer for a question");
		MyConsole.println("= SCORE   -Show player's score");

	}

}
