package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.LoginDao;
import com.nyf.dao.UserDao;
import com.nyf.projo.Login;
import com.nyf.projo.User;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser2")
public class UpdateUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser2() {
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
		//int status = Integer.valueOf(request.getParameter("status"));
		String name = request.getParameter("username1");
		String pwd = request.getParameter("userpwd1");
		int code = Integer.valueOf(request.getParameter("code1"));
		Login l = new Login();	
		PrintWriter out = response.getWriter();
		l.setName(name);
		l.setPwd(pwd);
		l.setCode(code);
		//l.setStatus(status);
		if(cd.insert(l)){
			session.commit();
			List<Login> list = cd.selectByLogin(l);
			if(code == 1) {
				User user = new User();
				user.setName(name);
				user.setStudent_number(name);
				System.out.println(list.get(0).getId());
				user.setLogin_id(list.get(0).getId());
				UserDao ud = session.getMapper(UserDao.class);
				if(ud.insert(user)) {
					session.commit();
					out.print("<script>alert('添加成功！');window.location.href='manUserManage2.jsp';</script>");
				}else {
					out.print("<script>alert('添加失败！');window.location.href='manUserManage2.jsp';</script>");
				}
			}	
		}else {
			out.print("<script>alert('添加失败！');window.location.href='manUserManage2.jsp';</script>");
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
