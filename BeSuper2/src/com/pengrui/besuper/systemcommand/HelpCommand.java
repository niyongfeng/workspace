package com.pengrui.besuper.systemcommand;



public class HelpCommand{
	public void excute() {
		System.out.println("======================== 帮助界面 ========================");
		System.out.println("= EXIT    - Exit the application");
		System.out.println("= HELP    - Print command usage");
		System.out.println("= LOGIN   - Login the application");
		System.out.println("= SIGNUP  - Sign up an player account");
		System.out.println("= LIST    - List questions for ALL|MINE|OPEN|ID mode");
		System.out.println("= ASK     - Ask a question");
		System.out.println("= ANSWER  - Answer a question");
		System.out.println("= ACCEPT  - Set best answer for a question");
		System.out.println("= SCORE   - Show player's score");
	}
}
