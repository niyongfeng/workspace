package com.zhq.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebServlet("/main")
public class MainServlet implements Servlet {
	
	public MainServlet() {
	
	}

	@Override
	public void destroy() {
		System.out.println("销毁servlet");
	}

	@Override
	public ServletConfig getServletConfig() {
		MainServlet ms = new MainServlet();
		ms.getServletInfo();
		System.out.println(ms);
		System.out.println("获取servlet配置信息");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("获取servlet信息");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化servlet");
		getServletConfig();
		System.out.println(arg0.getServletName());
		System.out.println(arg0.getInitParameter("name"));
		arg0.getServletContext().setAttribute("userName", "老蒋");
		System.out.println(arg0.getServletContext().getInitParameter("user"));
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("判断http请求");
		System.out.println(arg0.getRemoteAddr());
		System.out.println(arg0.getLocalAddr()+arg0.getLocalName()+arg0.getLocalPort());
		System.out.println(arg0.getParameter("username"));
		System.out.println("结果呢");
	}

}
