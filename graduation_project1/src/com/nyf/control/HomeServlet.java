package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyf.dao.LoginDao;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		//String flag = request.getParameter("flag");
		LoginDao loginDao = MybatisSessionFactory.getSession().getMapper(LoginDao.class);
		Login login = new Login();
		login.setName(name);
		login.setPwd(pwd);
		List<Login> list = loginDao.selectByLogin(login);
		if(!list.isEmpty()){
			//request.getSession().setAttribute("user_id", 1);
			int i = list.get(0).getCode();
			
			request.getSession().setAttribute("userName", name);
			switch(i) {
			case 1:response.sendRedirect("studentIndex.jsp");break;
			case 2:response.sendRedirect("teacherIndex.jsp");break;
			case 3:response.sendRedirect("manageIndex.jsp");break;
			}
			
		}else {
			//response.sendRedirect("sign-in.html");
			PrintWriter out = response.getWriter();
			out.print("<script language='JavaScript' type='text/javascript'>alert('登录失败！请重新登录');window.location.href='sign-in.html';</script>");
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
