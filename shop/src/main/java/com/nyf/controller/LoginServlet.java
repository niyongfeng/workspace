package com.nyf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyf.pojo.User;
import com.nyf.serviceImp.UserServiceImp;
import com.nyf.util.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("u");
		String password = request.getParameter("p");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		System.out.println(user);
		UserServiceImp usi = ServiceFactory.userServiceImp;
		List<User> list = usi.login(user);
		System.out.println(list);
		PrintWriter out = response.getWriter();
		if(list.size() != 0) {
			request.getSession().setAttribute("user", user);
			out.print("<script>alert('登录成功！');window.location.href='product';</script>");
		}else {
			out.print("<script>alert('登录失败！');window.location.href='index.html';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
