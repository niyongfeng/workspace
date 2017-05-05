package com.qk.command.impl;

import com.qk.DAO.BesuperDao;
import com.qk.command.Command;
import com.qk.util.MyConsole;

public class ExitCommand implements Command {
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		BesuperDao.close();
		MyConsole.println("===============ª∂”≠œ¬¥Œπ‚¡Ÿ===============");
		System.exit(0);
	}

}
