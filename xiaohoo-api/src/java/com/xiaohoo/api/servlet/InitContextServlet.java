package com.xiaohoo.api.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xiaohoo.api.common.util.BizLogger;

public class InitContextServlet implements Servlet {
	
	private BizLogger logger= BizLogger.getLogger(InitContextServlet.class);

	@Override
	public void init(ServletConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		logger.info("There is no real service function here.");

	}

}

