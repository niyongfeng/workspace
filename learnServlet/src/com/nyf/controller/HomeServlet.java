package com.nyf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig config;
	
    public HomeServlet() {
    
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.config = config;
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = config.getInitParameter("action");
		response.getWriter().append(name);
		response.getWriter().append((CharSequence) config.getServletContext().getAttribute("user"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/main");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
