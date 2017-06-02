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
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class StudentPwd
 */
@WebServlet("/StudentPwd")
public class StudentPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String firstPwd = request.getParameter("firstPwd");
		String secondPwd = request.getParameter("secondPwd");
		System.out.println(firstPwd+ ":" + secondPwd);
		String name = request.getSession().getAttribute("userName").toString();
		System.out.println(name);
		SqlSession session = MybatisSessionFactory.getSession();
		LoginDao ld = session.getMapper(LoginDao.class);
		PrintWriter out = response.getWriter();
		Login l = new Login();
		List<Login> list = ld.selectByNameA(name);
		int code = list.get(0).getCode();
		if(firstPwd.equals(secondPwd)) {
			l.setId(list.get(0).getId());
			l.setName(name);
			l.setPwd(firstPwd);
			System.out.println(l);
			if(ld.update(l)) {
				session.commit();
				out.print("<script>alert('密码修改成功！');window.location.href='sign-in.html';</script>");
			}else {		
				if(code == 1) {
					out.print("<script>alert('密码修改失败！');window.location.href='studentIndex.jsp';</script>");
				}else if(code == 2) {
					out.print("<script>alert('密码修改失败！');window.location.href='teacherIndex.jsp';</script>");
				}else {
					out.print("<script>alert('密码修改失败！');window.location.href='manIndex.jsp';</script>");
				}
				
			}
		}else{
			if(code == 1) {
				out.print("<script>alert('两次密码不一致！');window.location.href='pwd.jsp';</script>");
			}else if(code == 2) {
				out.print("<script>alert('两次密码不一致！');window.location.href='pwd2.jsp';</script>");
			}else {
				out.print("<script>alert('两次密码不一致！');window.location.href='pwd3.jsp';</script>");
			}
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
