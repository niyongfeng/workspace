package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.LoginDao;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		LoginDao cd = session.getMapper(LoginDao.class);
		int status = Integer.valueOf(request.getParameter("status"));
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		int code = Integer.valueOf(request.getParameter("code"));
		Login l = new Login();	
		l.setName(name);
		l.setPwd(pwd);
		l.setCode(code);
		l.setStatus(status);
		cd.updateByName(l);
		session.commit();
		response.sendRedirect("manUserManage2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
