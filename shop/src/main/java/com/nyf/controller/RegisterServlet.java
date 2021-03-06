package com.nyf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyf.pojo.User;
import com.nyf.serviceImp.UserServiceImp;
import com.nyf.util.ServiceFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("user");
		String password = request.getParameter("passwd");
		String password1 = request.getParameter("passwd2");
		PrintWriter out = response.getWriter();
		if(password.equals(password1)) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setRule(1);
			UserServiceImp usi = ServiceFactory.userServiceImp;
			try{
				usi.register(user);
				out.print("<script>alert('注册成功！');window.location.href='index.html';</script>");
			} catch(Exception e) {
				out.print("<script>alert('用户名已存在！');history.back();</script>");
			}
		}else {
			out.print("<script>alert('两次密码不一样！');history.back();</script>");
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
